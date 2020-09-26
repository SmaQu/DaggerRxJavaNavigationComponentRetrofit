package com.alastor.daggerrxjavanavigationcomponentretrofit.di;

import com.alastor.daggerrxjavanavigationcomponentretrofit.AuthActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuildersModule {

    @ContributesAndroidInjector
    abstract AuthActivity contributeAuthActivity();


}
