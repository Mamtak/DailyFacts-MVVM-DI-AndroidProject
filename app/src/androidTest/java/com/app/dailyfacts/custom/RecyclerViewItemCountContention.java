package com.app.dailyfacts.custom;

import static androidx.test.espresso.matcher.ViewMatchers.assertThat;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;
import androidx.test.espresso.NoMatchingViewException;
import androidx.test.espresso.ViewAssertion;

import org.hamcrest.Matcher;

public class RecyclerViewItemCountContention implements ViewAssertion {
    private final Matcher<Integer> matcher;

    private RecyclerViewItemCountContention(Matcher<Integer> matcher) {
        this.matcher = matcher;
    }

    private static RecyclerViewItemCountContention withItemCount(int expectedCount) {
        return withItemCount(expectedCount);
    }

    private static RecyclerViewItemCountContention withItemCount(Matcher<Integer> matcher) {
        return new RecyclerViewItemCountContention(matcher);
    }

    @Override
    public void check(View view, NoMatchingViewException noViewFoundException) {
        if (noViewFoundException != null) {
            throw noViewFoundException;
        }

        RecyclerView recyclerView = (RecyclerView) view;
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        assertThat(adapter.getItemCount(), matcher);
    }
}
