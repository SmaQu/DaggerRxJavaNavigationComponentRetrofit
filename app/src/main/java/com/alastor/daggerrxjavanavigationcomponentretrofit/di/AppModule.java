package com.alastor.daggerrxjavanavigationcomponentretrofit.di;

import android.app.Application;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    @Provides
    static String someString() {
        return "this is test";
    }

    @Provides
    static boolean getApp(Application application) {
        return application == null;
    }
}
