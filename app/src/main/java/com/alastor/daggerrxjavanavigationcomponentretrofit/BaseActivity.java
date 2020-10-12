package com.alastor.daggerrxjavanavigationcomponentretrofit;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;

import com.alastor.daggerrxjavanavigationcomponentretrofit.ui.auth.AuthActivity;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public abstract class BaseActivity extends DaggerAppCompatActivity {

    private static final String TAG = "BaseActivity";

    @Inject
    public SessionManager sessionManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        subscribeObserver();
    }

    private void subscribeObserver() {
        sessionManager.getAuthUser().observe(this, authResource -> {
            if (authResource != null) {
                switch (authResource.status) {
                    case LOADING:

                        break;
                    case AUTHENTICATED:
                        Log.d(TAG, "onChanged: LOGIN SUCCESS: " + authResource.data.getEmail());

                        break;
                    case ERROR:
                        Log.e(TAG, "onChanged: " + authResource.message);

                        break;
                    case NOT_AUTHENTICATED:
                        navLoginScreen();
                        break;
                }
            }
        });
    }

    private void navLoginScreen(){
        final Intent intent = new Intent(this, AuthActivity.class);
        startActivity(intent);
        finish();
    }
}
