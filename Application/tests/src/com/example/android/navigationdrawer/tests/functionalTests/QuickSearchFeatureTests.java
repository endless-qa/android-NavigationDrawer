package com.example.android.navigationdrawer.tests.functionalTests;

import android.app.SearchManager;
import android.content.Intent;
import android.support.test.espresso.intent.rule.IntentsTestRule;

import com.example.android.navigationdrawer.MainActivity;
import com.example.android.navigationdrawer.tests.BaseTestModel;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.*;
import static org.hamcrest.Matchers.*;

public class QuickSearchFeatureTests extends BaseTestModel {

    private static final String
            GOOGLE_QUICK_SEARCH_PACKAGE = "com.google.android.googlequicksearchbox";

    private static final String DEFAULT_PLANET_ON_APPLICATION_START = "Mercury";

    @Rule
    public IntentsTestRule<MainActivity> intentsTestRule =
            new IntentsTestRule<>(MainActivity.class);

    @Test
    public void checkSearchForCurrentPlanetSendsProperIntent() {
        planetsShowRoomPage.searchCurrentPlanetInfo();

        intended(allOf(
                hasAction(equalTo(Intent.ACTION_WEB_SEARCH)),
                hasExtra(SearchManager.QUERY, DEFAULT_PLANET_ON_APPLICATION_START),
                toPackage(GOOGLE_QUICK_SEARCH_PACKAGE)));

        closeThirdPartyAppByPackage(GOOGLE_QUICK_SEARCH_PACKAGE);
    }
}