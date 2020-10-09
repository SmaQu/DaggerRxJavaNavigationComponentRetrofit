package com.alastor.daggerrxjavanavigationcomponentretrofit.di.auth;

import androidx.lifecycle.ViewModel;

import com.alastor.daggerrxjavanavigationcomponentretrofit.di.ViewModelKey;
import com.alastor.daggerrxjavanavigationcomponentretrofit.ui.auth.AuthViewModel;

import javax.inject.Inject;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class AuthViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(AuthViewModel.class)
    public abstract ViewModel bindAuthViewModel(AuthViewModel viewModel);
}
