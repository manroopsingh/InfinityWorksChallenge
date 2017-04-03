package com.example.singh.infinityworkschallenge.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.singh.infinityworkschallenge.R;
import com.example.singh.infinityworkschallenge.model.authorities.Authorities;
import com.example.singh.infinityworkschallenge.model.authorities.Authority;
import com.example.singh.infinityworkschallenge.utility.AuthorityListAdapter;
import com.example.singh.infinityworkschallenge.utility.RetrofitHelper;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class AuthorityListActivity extends AppCompatActivity {

    private static final String TAG = "AuthoritiesListActivity";
    @BindView(R.id.rvAuthorityList)
    RecyclerView rvAuthorityList;

    private RecyclerView.LayoutManager layoutManager;
    private AuthorityListAdapter adapter;
    private DefaultItemAnimator defaultItemAnimator;
    private List<Authority> authorityList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authority_list);
        ButterKnife.bind(this);
        setTitle("Local Authorities");

        setupRecyclerView();

        rx.Observable<Authorities> videosObservable = RetrofitHelper.createAuthoritiesObs();
        videosObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Authorities>() {
                    @Override
                    public void onCompleted() {
                    adapter.notifyDataSetChanged();
                    }


                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onNext(Authorities authorities) {
                        authorityList.addAll(authorities.getAuthorities());
                    }
                });

    }

    private void setupRecyclerView() {
        adapter = new AuthorityListAdapter(this, authorityList);
        layoutManager = new LinearLayoutManager(this);
        defaultItemAnimator = new DefaultItemAnimator();
        rvAuthorityList.setAdapter(adapter);
        rvAuthorityList.setLayoutManager(layoutManager);
        rvAuthorityList.setItemAnimator(defaultItemAnimator);
    }
}
