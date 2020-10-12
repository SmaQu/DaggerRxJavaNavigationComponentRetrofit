package com.alastor.daggerrxjavanavigationcomponentretrofit.network.main;

import com.alastor.daggerrxjavanavigationcomponentretrofit.models.Post;

import java.util.List;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MainApi {

    @GET("posts")
    Flowable<List<Post>> getPostsFromUser(@Query("userId") long id);
}
