package com.alastor.daggerrxjavanavigationcomponentretrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import javax.inject.Inject;

import dagger.android.DaggerActivity;

public class AuthActivity extends DaggerActivity {

    private static final String TAG = "AuthActivity";

    @Inject
    String test;

    @Inject
    boolean isAppNull;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);

        Log.d(TAG, "onCreate: " + test);
        Log.d(TAG, "onCreate: is app null" + isAppNull);
    }
}