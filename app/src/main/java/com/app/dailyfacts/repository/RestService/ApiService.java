package com.app.dailyfacts.repository.RestService;


import com.app.dailyfacts.model.Facts;

import io.reactivex.Observable;
import retrofit2.http.GET;


public interface ApiService {
    @GET("facts?number=10")
    Observable<Facts> getDailyFacts();
}
