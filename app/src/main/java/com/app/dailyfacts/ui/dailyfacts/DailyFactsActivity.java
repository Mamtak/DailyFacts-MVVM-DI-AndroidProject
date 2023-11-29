package com.app.dailyfacts.ui.dailyfacts;

import android.os.Bundle;
import android.view.View;

import androidx.core.splashscreen.SplashScreen;
import androidx.fragment.app.FragmentManager;

import com.app.dailyfacts.databinding.ActivityDailyFactsBinding;
import com.app.dailyfacts.ui.error.ErrorFragment;
import com.app.dailyfacts.util.BaseActivity;

public class DailyFactsActivity extends BaseActivity {

    private static final String LIST_FRAG = "DAILY_FACTS_LIST_FRAG";
    private static final String ERROR_FRAG = "ERROR_FRAG";

    private ActivityDailyFactsBinding activityDailyFactsBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // inflating our xml layout in our activity main binding
        SplashScreen.installSplashScreen(this);
        activityDailyFactsBinding = activityDailyFactsBinding.inflate(getLayoutInflater());

        // getting our root layout in our view.
        View view = activityDailyFactsBinding.getRoot();

        // below line is to set
        // Content view for our layout.
        setContentView(view);
        FragmentManager manager = getSupportFragmentManager();
        if (!isNetworkConnected()) {
            ErrorFragment fragment = (ErrorFragment) manager.findFragmentByTag(ERROR_FRAG);
            if (fragment == null) {
                fragment = ErrorFragment.newInstance();
            }
            addFragmentToActivity(manager,
                    fragment,
                    activityDailyFactsBinding.rootActivityList.getId(),
                    ERROR_FRAG
            );
        } else {
            DailyFactsFragment fragment = (DailyFactsFragment) manager.findFragmentByTag(LIST_FRAG);
            if (fragment == null) {
                fragment = DailyFactsFragment.newInstance();
            }
            addFragmentToActivity(manager,
                    fragment,
                    activityDailyFactsBinding.rootActivityList.getId(),
                    LIST_FRAG
            );
        }
    }

    public void clearFragment(Bundle savedInstanceState) {
        ErrorFragment fragment = (ErrorFragment) getSupportFragmentManager().getFragment(savedInstanceState, ERROR_FRAG);
        getSupportFragmentManager().beginTransaction().remove(fragment).commit();
    }
}