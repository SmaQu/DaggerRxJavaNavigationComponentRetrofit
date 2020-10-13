package com.alastor.daggerrxjavanavigationcomponentretrofit.di.auth;

import com.alastor.daggerrxjavanavigationcomponentretrofit.network.auth.AuthApi;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class AuthModule {

    @AuthScope
    @Provides
    static AuthApi provideAuthApi(Retrofit retrofit) {
        return retrofit.create(AuthApi.class);
    }
    
}
