package com.alastor.daggerrxjavanavigationcomponentretrofit.network.auth;

import com.alastor.daggerrxjavanavigationcomponentretrofit.models.User;

import io.reactivex.Flowable;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface AuthApi {

    @GET("users/{id}")
    public Flowable<User> getUser(@Path("id") long id);
}
