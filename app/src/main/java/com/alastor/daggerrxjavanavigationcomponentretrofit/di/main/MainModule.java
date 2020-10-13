package com.alastor.daggerrxjavanavigationcomponentretrofit.di.main;

import androidx.recyclerview.widget.RecyclerView;

import com.alastor.daggerrxjavanavigationcomponentretrofit.network.main.MainApi;
import com.alastor.daggerrxjavanavigationcomponentretrofit.ui.main.posts.PostsRecyclerAdapter;
import com.alastor.daggerrxjavanavigationcomponentretrofit.util.VerticalSpacingItemDecoration;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class MainModule {

    @MainScope
    @Provides
    static VerticalSpacingItemDecoration provideVerticalSpacingItemDecoration() {
        return new VerticalSpacingItemDecoration(15);
    }

    @MainScope
    @Provides
    static PostsRecyclerAdapter provideAdapter() {
        return new PostsRecyclerAdapter();
    }

    @MainScope
    @Provides
    static MainApi provideMainApi(Retrofit retrofit) {
        return retrofit.create(MainApi.class);
    }
}
