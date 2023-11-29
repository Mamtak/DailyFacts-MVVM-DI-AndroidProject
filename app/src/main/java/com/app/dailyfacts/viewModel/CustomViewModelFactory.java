package com.app.dailyfacts.viewModel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.app.dailyfacts.repository.DailyFactsRepository;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class CustomViewModelFactory implements ViewModelProvider.Factory {
    private final DailyFactsRepository repository;

    @Inject
    public CustomViewModelFactory(DailyFactsRepository repository) {
        this.repository = repository;
    }

    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        if (modelClass.isAssignableFrom(DailyFactsViewModel.class))
            return (T) new DailyFactsViewModel(repository);
        else {
            throw new IllegalArgumentException("ViewModel Not Found");
        }
    }
}
