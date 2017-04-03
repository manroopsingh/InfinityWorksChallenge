package com.example.singh.infinityworkschallenge.utility;

import com.example.singh.infinityworkschallenge.model.authorities.Authorities;
import com.example.singh.infinityworkschallenge.model.establishments.Establishments;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;
import rx.Observable;
import rx.schedulers.Schedulers;

/**
 * Created by singh on 29-Mar-17.
 */

public class RetrofitHelper {

    private static final String BASE_URL = "http://api.ratings.food.gov.uk";

    public static Retrofit create() {
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.createWithScheduler(Schedulers.io()))
                .build();
    }


    public static Observable<Authorities> createAuthoritiesObs() {
        Retrofit retrofit = create();
        RestroFitService service = retrofit.create(RestroFitService.class);
        return service.getAuthoritiesObservable();
    }


    public static Observable<Establishments> createEstablishmentsObs(String authorityId, String rating) {
        Retrofit retrofit = create();
        RestroFitService service = retrofit.create(RestroFitService.class);
        return service.getEstablishmentsObservable(authorityId, rating);
    }

    public interface RestroFitService {


        @Headers("x-api-version: 2")
        @GET("/authorities")
        Observable<Authorities> getAuthoritiesObservable();

        @Headers("x-api-version: 2")
        @GET("/establishments")
        Observable<Establishments> getEstablishmentsObservable(@Query("localAuthorityId") String authorityId, @Query("ratingKey") String rating);




    }

}
