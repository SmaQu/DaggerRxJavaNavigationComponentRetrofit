package com.alastor.daggerrxjavanavigationcomponentretrofit.di;

import com.alastor.daggerrxjavanavigationcomponentretrofit.di.auth.AuthModule;
import com.alastor.daggerrxjavanavigationcomponentretrofit.di.auth.AuthScope;
import com.alastor.daggerrxjavanavigationcomponentretrofit.di.auth.AuthViewModelModule;
import com.alastor.daggerrxjavanavigationcomponentretrofit.di.main.MainFragmentBuildersModule;
import com.alastor.daggerrxjavanavigationcomponentretrofit.di.main.MainModule;
import com.alastor.daggerrxjavanavigationcomponentretrofit.di.main.MainScope;
import com.alastor.daggerrxjavanavigationcomponentretrofit.di.main.MainViewModelsModule;
import com.alastor.daggerrxjavanavigationcomponentretrofit.ui.auth.AuthActivity;
import com.alastor.daggerrxjavanavigationcomponentretrofit.ui.main.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuildersModule {

    @AuthScope
    @ContributesAndroidInjector(
            modules = {AuthViewModelModule.class, AuthModule.class}
    )
    abstract AuthActivity contributeAuthActivity();

    @MainScope
    @ContributesAndroidInjector(
            modules = {MainFragmentBuildersModule.class, MainViewModelsModule.class, MainModule.class}
    )
    abstract MainActivity contributeMainActivity();

}
