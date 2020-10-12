package com.alastor.daggerrxjavanavigationcomponentretrofit.ui.main.posts;

import androidx.lifecycle.ViewModel;

import com.alastor.daggerrxjavanavigationcomponentretrofit.SessionManager;
import com.alastor.daggerrxjavanavigationcomponentretrofit.network.main.MainApi;

import javax.inject.Inject;

public class PostsViewModel extends ViewModel {

    private static final String TAG = "PostsViewModel";

    private SessionManager sessionManager;
    private MainApi mainApi;

    @Inject
    public PostsViewModel(SessionManager sessionManager, MainApi mainApi) {
        this.sessionManager = sessionManager;
        this.mainApi = mainApi;
    }
}
