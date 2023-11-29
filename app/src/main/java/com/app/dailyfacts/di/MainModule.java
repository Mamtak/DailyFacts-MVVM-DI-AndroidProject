package com.app.dailyfacts.di;

import android.app.Application;

import androidx.lifecycle.ViewModelProvider;

import com.app.dailyfacts.di.Components.ServiceComponent;
import com.app.dailyfacts.repository.DailyFactsRepository;
import com.app.dailyfacts.repository.RestService.ApiService;
import com.app.dailyfacts.viewModel.CustomViewModelFactory;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class MainModule {

    ApiService service;

    public MainModule(Application application) {
        this.service = (new ServiceComponent()).getService();
    }


    @Provides
    @Singleton
    DailyFactsRepository providePeopleRepository() {
        return new DailyFactsRepository(service);
    }

    @Provides
    @Singleton
    ApiService providePeopleService() {
        return this.service;
    }

    @Provides
    @Singleton
    ViewModelProvider.Factory provideViewModelFactory(DailyFactsRepository repository) {
        return new CustomViewModelFactory(repository);
    }
}
