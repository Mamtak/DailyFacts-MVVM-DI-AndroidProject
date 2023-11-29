package com.app.dailyfacts.ui;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static com.app.dailyfacts.DailyFactsRepositoryMock.getDailyDogFacts;

import android.content.Context;
import android.content.Intent;

import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.rule.ActivityTestRule;

import com.app.dailyfacts.DailyFactsRepositoryMock;
import com.app.dailyfacts.R;
import com.app.dailyfacts.custom.RecyclerViewMatcher;
import com.app.dailyfacts.repository.DailyFactsRepository;
import com.app.dailyfacts.ui.dailyfacts.DailyFactsActivity;

import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class DailyFactsActivityTest {

    @Rule
    public ActivityTestRule<DailyFactsActivity> mActivityRule =
            new ActivityTestRule<DailyFactsActivity>(DailyFactsActivity.class, true, false) {
        @Override
        protected void beforeActivityLaunched() {
            super.beforeActivityLaunched();
        }
    };

    @BeforeClass
    public static void setUp() {
        DailyFactsRepository dailyFactsRepositoryMock = DailyFactsRepositoryMock.getRepositoryMocking();
        DailyFactsRepositoryMock.setupDummyMocks();
    }

    @Test
    public void testDailyFactsFragment(){
        Mockito.when(DailyFactsRepositoryMock.getRepositoryMocking().getDailyDogFacts()).thenReturn(getDailyDogFacts()) ;
        launchActivity();
        onView(withText(getResourceString(R.string.main_activity_title))).check(matches(ViewMatchers.isDisplayed()));
        onView(new RecyclerViewMatcher(R.id.rec_list_activity)
                .atPositionOnView(0, R.id.lbl_facts))
                .check(matches(withText("Dogs can use their sense of smell to gauge our emotions")));
        onView(new RecyclerViewMatcher(R.id.rec_list_activity)
                .atPositionOnView(1, R.id.lbl_facts))
                .check(matches(withText("Americans love dogs! 44% of U.S. households have a dog")));
        onView(new RecyclerViewMatcher(R.id.rec_list_activity)
                .atPositionOnView(0, R.id.lbl_facts))
                .check(matches(withText("Two stray dogs in Afghanistan saved 50 American soliders")));
        onView(new RecyclerViewMatcher(R.id.rec_list_activity)
                .atPositionOnView(0, R.id.lbl_facts))
                .check(matches(withText("Dogs curl up to keep themselves warm and protect vital organs.")));
    }


    private void launchActivity(){
        Intent intent = new Intent();
        mActivityRule.launchActivity(intent);
    }

    private static final int ITEM_BELOW_THE_FOLD = 40;

//    /**
//     * Use {@link ActivityScenario} to create and launch the activity under test. This is a
//     * replacement for {@link androidx.test.rule.ActivityTestRule}.
//     */
//    @Rule
//    public ActivityScenarioRule<DailyFactsActivity> activityScenarioRule =
//            new ActivityScenarioRule<DailyFactsActivity>(DailyFactsActivity.class);
//
//    @Test(expected = PerformException.class)
//    public void itemWithText_doesNotExist() {
//        // Attempt to scroll to an item that contains the special text.
//        onView(ViewMatchers.withId(R.id.rec_list_activity))
//                // scrollTo will fail the test if no item matches.
//                .perform(RecyclerViewActions.scrollTo(
//                        hasDescendant(withText("not in the list"))
//                ));
//    }
//
//    @Test
//    public void scrollToItemBelowFold_checkItsText() {
//        // First scroll to the position that needs to be matched and click on it.
//        onView(ViewMatchers.withId(R.id.rec_list_activity))
//                .perform(RecyclerViewActions.actionOnItemAtPosition(ITEM_BELOW_THE_FOLD, click()));
//
//        // Match the text in an item below the fold and check that it's displayed.
//        String itemElementText = getApplicationContext().getResources().getString(
//                R.string.item_element_text) + String.valueOf(ITEM_BELOW_THE_FOLD);
//        onView(withText(itemElementText)).check(matches(isDisplayed()));
//    }
//
//    @Test
//    public void itemInMiddleOfList_hasSpecialText() {
//        // First, scroll to the view holder using the isInTheMiddle matcher.
//        onView(ViewMatchers.withId(R.id.rec_list_activity))
//                .perform(RecyclerViewActions.scrollToHolder(isInTheMiddle()));
//
//        // Check that the item has the special text.
//        String middleElementText =
//                getApplicationContext().getResources().getString(R.string.middle);
//        onView(withText(middleElementText)).check(matches(isDisplayed()));
//    }


    private String getResourceString(int id){
        Context targetContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        return targetContext.getResources().getString(id);
    }
}
