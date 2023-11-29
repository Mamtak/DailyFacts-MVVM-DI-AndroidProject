package com.app.dailyfacts.viewModel;


import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.app.dailyfacts.model.Facts;
import com.app.dailyfacts.repository.DailyFactsRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class DailyFactsViewModel extends ViewModel {

    private DailyFactsRepository repository;
    private MutableLiveData<List<String>> dailyFactsList = new MutableLiveData<>();

    @Inject
    DailyFactsViewModel(DailyFactsRepository repository) {
        this.repository = repository;
    }

    public MutableLiveData<List<String>> getDailyFactsList() {
        return dailyFactsList;
    }

    public void getDailyDogFacts() {
        Observable<Facts> factsObservable = repository.getDailyDogFacts();
        factsObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableObserver<Facts>() {
                    @Override
                    public void onNext(Facts facts) {
                        dailyFactsList.postValue(facts.getFacts());
                    }
                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }

}
