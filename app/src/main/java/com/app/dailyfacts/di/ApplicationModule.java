package com.app.dailyfacts.di;

import android.app.Application;

import com.app.dailyfacts.HostApplication;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {
    private final HostApplication application;

    public ApplicationModule(HostApplication application) {
        this.application = application;
    }

    @Provides
    HostApplication provideExampleAndroidAppApplication() {
        return application;
    }

    @Provides
    Application provideApplication() {
        return application;
    }
}
