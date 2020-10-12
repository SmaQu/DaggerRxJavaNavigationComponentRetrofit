package com.alastor.daggerrxjavanavigationcomponentretrofit.di.main;

import android.view.View;

import androidx.lifecycle.ViewModel;

import com.alastor.daggerrxjavanavigationcomponentretrofit.di.ViewModelKey;
import com.alastor.daggerrxjavanavigationcomponentretrofit.ui.main.posts.PostsViewModel;
import com.alastor.daggerrxjavanavigationcomponentretrofit.ui.main.profile.ProfileViewModel;

import javax.inject.Inject;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class MainViewModelsModule {

    @Binds
    @IntoMap
    @ViewModelKey(ProfileViewModel.class)
    public abstract ViewModel bindProfileViewModel(ProfileViewModel viewModel);

    @Binds
    @IntoMap
    @ViewModelKey(PostsViewModel.class)
    public abstract ViewModel bindPostViewModel(PostsViewModel postsViewModel);
}
