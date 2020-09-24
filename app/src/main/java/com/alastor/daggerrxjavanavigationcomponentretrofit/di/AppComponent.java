package com.alastor.daggerrxjavanavigationcomponentretrofit.di;

import android.app.Application;

import com.alastor.daggerrxjavanavigationcomponentretrofit.BaseApplication;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;

@Component(
        modules = {
                AndroidInjectionModule.class,
                ActivityBuildersModule.class,
        }
)
public interface AppComponent extends AndroidInjector<BaseApplication> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }
}
