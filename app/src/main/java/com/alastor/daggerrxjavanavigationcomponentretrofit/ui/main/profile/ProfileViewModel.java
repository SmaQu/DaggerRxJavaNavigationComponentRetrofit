package com.alastor.daggerrxjavanavigationcomponentretrofit.ui.main.profile;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.alastor.daggerrxjavanavigationcomponentretrofit.SessionManager;
import com.alastor.daggerrxjavanavigationcomponentretrofit.models.User;
import com.alastor.daggerrxjavanavigationcomponentretrofit.ui.auth.AuthResource;

import javax.inject.Inject;

public class ProfileViewModel extends ViewModel {

    private static final String TAG = "ProfileViewModel";

    private final SessionManager sessionManager;

    @Inject
    public ProfileViewModel(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }

    public LiveData<AuthResource<User>> getAuthenticatedUser() {
        return sessionManager.getAuthUser();
    }
}
