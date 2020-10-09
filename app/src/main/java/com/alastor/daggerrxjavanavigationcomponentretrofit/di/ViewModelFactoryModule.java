package com.alastor.daggerrxjavanavigationcomponentretrofit.di;

import androidx.lifecycle.ViewModelProvider;

import com.alastor.daggerrxjavanavigationcomponentretrofit.viewmodels.ViewModelProviderFactory;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class ViewModelFactoryModule {

    @Binds
    public abstract ViewModelProvider.Factory binViewModelFactory(ViewModelProviderFactory modelProviderFactory);
}
