package com.alastor.daggerrxjavanavigationcomponentretrofit.ui.auth;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.LiveDataReactiveStreams;
import androidx.lifecycle.ViewModel;

import com.alastor.daggerrxjavanavigationcomponentretrofit.SessionManager;
import com.alastor.daggerrxjavanavigationcomponentretrofit.models.User;
import com.alastor.daggerrxjavanavigationcomponentretrofit.network.auth.AuthApi;

import javax.inject.Inject;

import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class AuthViewModel extends ViewModel {

    private static final String TAG = "AuthViewModel";

    private final AuthApi authApi;
    private final SessionManager sessionManager;

    @Inject
    public AuthViewModel(AuthApi authApi, SessionManager sessionManager) {
        this.authApi = authApi;
        this.sessionManager = sessionManager;
    }

    public void authenticateWithId(long userId) {
        Log.d(TAG, "authenticateWithId: attempting to login.");
        sessionManager.authenticateWithId(queryUserId(userId));
    }

    private LiveData<AuthResource<User>> queryUserId(long userId) {
        return LiveDataReactiveStreams.fromPublisher(
                authApi.getUser(userId)

                        .onErrorReturn(throwable -> {
                            final User errorUser = new User();
                            errorUser.setId(-1);
                            return errorUser;
                        })

                        .map((Function<User, AuthResource<User>>) user -> {
                            if (user.getId() == -1) {
                                return AuthResource.error("Could not authenticate", null);
                            }
                            return AuthResource.authenticated(user);
                        })

                        .subscribeOn(Schedulers.io()));
    }

    public LiveData<AuthResource<User>> observeAuthState() {
        return sessionManager.getAuthUser();
    }
}
