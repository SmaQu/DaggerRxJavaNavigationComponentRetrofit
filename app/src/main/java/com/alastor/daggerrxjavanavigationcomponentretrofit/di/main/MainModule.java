package com.alastor.daggerrxjavanavigationcomponentretrofit.di.main;

import com.alastor.daggerrxjavanavigationcomponentretrofit.network.main.MainApi;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class MainModule {

    @Provides
    static MainApi provideMainApi(Retrofit retrofit) {
        return retrofit.create(MainApi.class);
    }
}
