package com.alastor.daggerrxjavanavigationcomponentretrofit.di.main;

import com.alastor.daggerrxjavanavigationcomponentretrofit.ui.main.posts.PostsFragment;
import com.alastor.daggerrxjavanavigationcomponentretrofit.ui.main.profile.ProfileFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class MainFragmentBuildersModule {

    @ContributesAndroidInjector
    abstract ProfileFragment contributeProfileFragment();

    @ContributesAndroidInjector
    abstract PostsFragment contributePostFragment();
}
