package com.alastor.daggerrxjavanavigationcomponentretrofit;

import com.alastor.daggerrxjavanavigationcomponentretrofit.di.DaggerAppComponent;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;

public class BaseApplication extends DaggerApplication {

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerAppComponent.builder().application(this).build();
    }
}
