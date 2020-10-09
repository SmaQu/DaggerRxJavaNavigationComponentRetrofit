package com.alastor.daggerrxjavanavigationcomponentretrofit.di;

import com.alastor.daggerrxjavanavigationcomponentretrofit.di.auth.AuthViewModelModule;
import com.alastor.daggerrxjavanavigationcomponentretrofit.ui.auth.AuthActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuildersModule {

    @ContributesAndroidInjector(
            modules = {AuthViewModelModule.class}
    )
    abstract AuthActivity contributeAuthActivity();

}
