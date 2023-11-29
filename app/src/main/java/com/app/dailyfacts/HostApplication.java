package com.app.dailyfacts;

import android.app.Application;

import com.app.dailyfacts.di.ApplicationComponent;
import com.app.dailyfacts.di.ApplicationModule;
import com.app.dailyfacts.di.DaggerApplicationComponent;
import com.app.dailyfacts.di.MainModule;


public class HostApplication extends Application {
    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        applicationComponent = DaggerApplicationComponent
                .builder()
                .applicationModule(new ApplicationModule(this))
                .mainModule(new MainModule(this))
                .build();
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}
