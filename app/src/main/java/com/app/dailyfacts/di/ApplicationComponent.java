package com.app.dailyfacts.di;

import android.app.Application;

import com.app.dailyfacts.ui.dailyfacts.DailyFactsActivity;
import com.app.dailyfacts.ui.dailyfacts.DailyFactsFragment;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class, MainModule.class})
public interface ApplicationComponent {

    void inject(DailyFactsActivity dailyFactsActivity);

    void inject(DailyFactsFragment dailyFactsFragment);

    Application application();
}