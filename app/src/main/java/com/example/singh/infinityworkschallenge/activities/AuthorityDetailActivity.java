package com.example.singh.infinityworkschallenge.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.singh.infinityworkschallenge.R;
import com.example.singh.infinityworkschallenge.model.authorities.Authority;
import com.example.singh.infinityworkschallenge.model.establishments.Establishments;
import com.example.singh.infinityworkschallenge.utility.RetrofitHelper;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class AuthorityDetailActivity extends AppCompatActivity {

    private static final String TAG = "AuthorityDetailActivity";
    String[] ratings;
    int ratingCounter = 0;

    @BindView(R.id.tvRating1)
    TextView tvRating1;

    @BindView(R.id.tvRating2)
    TextView tvRating2;

    @BindView(R.id.tvRating3)
    TextView tvRating3;

    @BindView(R.id.tvRating4)
    TextView tvRating4;

    @BindView(R.id.tvRating5)
    TextView tvRating5;

    @BindView(R.id.tvExempt)
    TextView tvExempt;

    @BindView(R.id.tvPass)
    TextView tvPass;

    @BindView(R.id.tvImprovement)
    TextView tvImprovement;

    @BindView(R.id.tvAwaiting)
    TextView tvAwaiting;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authority_detail);
        ButterKnife.bind(this);

        Authority authority = (Authority) getIntent().getSerializableExtra("authority");
        setTitle(authority.getName());

        if (authority.getRegionName().toLowerCase().equals("scotland"))
            ratings = new String[]{"Pass", "ImprovementRequired", "AwaitingInspection", "Exempt"};
        else
            ratings = new String[]{"1", "2", "3", "4", "5"};

        for (int i = 0; i < ratings.length; i++) {

            ratingCounter++;
            rx.Observable<Establishments> videosObservable = RetrofitHelper.createEstablishmentsObs(String.valueOf(authority.getLocalAuthorityId()), ratings[i]);
            videosObservable.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Subscriber<Establishments>() {
                        @Override
                        public void onCompleted() {
                        }

                        @Override
                        public void onError(Throwable e) {
                            e.printStackTrace();
                        }

                        @Override
                        public void onNext(Establishments establishments) {
                            testResults(establishments);

                        }
                    });
        }
    }

    List<String> rating = new ArrayList<>();
    List<Integer> ratingCount = new ArrayList<>();

    private void testResults(Establishments establishments) {
        rating.add(establishments.getEstablishments().get(0).getRatingValue());
        ratingCount.add(establishments.getEstablishments().size());
        if (ratingCounter == ratings.length) {
            countRatings(rating, ratingCount);
        }
    }

    private void countRatings(List<String> ratingString, List<Integer> ratingsCount) {
        int total = 0;
        for (int i = 0; i < ratingsCount.size(); i++) {
            total = total + ratingsCount.get(i);
        }
        double percentage;
        String percent;
        for (int i = 0; i < ratingsCount.size(); i++) {
            percentage = (double) ratingsCount.get(i) / total * 100;
            percentage = Math.round(percentage);
            percent = String.valueOf(percentage) + "%";
            switch (ratingString.get(i)) {
                case "1":
                    tvRating1.setText(percent);
                    break;
                case "2":
                    tvRating2.setText(percent);
                    break;
                case "3":
                    tvRating3.setText(percent);
                    break;
                case "4":
                    tvRating4.setText(percent);
                    break;
                case "5":
                    tvRating5.setText(percent);
                    break;
                case "Pass":
                    tvPass.setText(percent);
                    break;
                case "Improvement Required":
                    tvImprovement.setText(percent);
                    break;
                case "Awaiting Inspection":
                    tvAwaiting.setText(percent);
                    break;
                case "Exempt":
                    tvExempt.setText(percent);
                    break;

            }

        }

    }

}
