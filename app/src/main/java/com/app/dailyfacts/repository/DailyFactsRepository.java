package com.app.dailyfacts.repository;


import com.app.dailyfacts.model.Facts;
import com.app.dailyfacts.repository.RestService.ApiService;

import javax.inject.Inject;

import io.reactivex.Observable;

public class DailyFactsRepository {

    ApiService service;

    @Inject
    public DailyFactsRepository(ApiService service) {
        this.service = service;
    }

    public Observable<Facts> getDailyDogFacts() {
        return service.getDailyFacts();
    }

}
