package com.alastor.daggerrxjavanavigationcomponentretrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import dagger.android.DaggerActivity;

public class AuthActivity extends DaggerActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);
    }
}