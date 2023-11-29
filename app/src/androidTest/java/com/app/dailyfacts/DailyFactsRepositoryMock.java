package com.app.dailyfacts;

import com.app.dailyfacts.model.Facts;
import com.app.dailyfacts.repository.DailyFactsRepository;

import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;

@RunWith(MockitoJUnitRunner.class)
public class DailyFactsRepositoryMock {
    private static DailyFactsRepository dailyFactsRepositoryMock;

    public static DailyFactsRepository getRepositoryMocking() {;
        if (dailyFactsRepositoryMock == null) {
            dailyFactsRepositoryMock = Mockito.mock(DailyFactsRepository.class);
        }
        return dailyFactsRepositoryMock;
    }

    public static void setupDummyMocks() {
        Mockito.when(DailyFactsRepositoryMock.getDailyDogFacts()).thenReturn(getDailyDogFacts());
//        Mockito.doReturn(getDailyFacts()).when(dailyFactsRepositoryMock.getDailyDogFacts());
    }


    public static List<String> getDailyFacts() {
        List<String> dailyFacts = new ArrayList<>();
        dailyFacts.add("Dogs can use their sense of smell to gauge our emotions");
        dailyFacts.add("Americans love dogs! 44% of U.S. households have a dog");
        dailyFacts.add("Two stray dogs in Afghanistan saved 50 American soliders");
        dailyFacts.add("Dogs curl up to keep themselves warm and protect vital organs.");
        return dailyFacts;
    }

    public static Observable<Facts> getDailyDogFacts() {
        Facts facts = new Facts();
        List<String> dailyFacts = new ArrayList<>();
        dailyFacts.add("Dogs can use their sense of smell to gauge our emotions");
        dailyFacts.add("Americans love dogs! 44% of U.S. households have a dog");
        dailyFacts.add("Two stray dogs in Afghanistan saved 50 American soliders");
        dailyFacts.add("Dogs curl up to keep themselves warm and protect vital organs.");
        facts.setFacts(dailyFacts);
        return Observable.just(facts);
    }
}
