package com.example.android.navigationdrawer.tests.functionalTests;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.example.android.navigationdrawer.MainActivity;
import com.example.android.navigationdrawer.tests.BaseTestModel;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(AndroidJUnit4.class)
public class BasicFunctionalityTests extends BaseTestModel {

    private static final int NUMBER_OF_PLANETS_SOLAR_SYSTEM = 8;
    private static final String DEFAULT_PLANET_ON_APPLICATION_START = "Mercury";

    @Rule
    public ActivityTestRule<MainActivity>
            mainActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void checkDefaultPlanetIsDisplayedOnStart() {
        planetsShowRoomPage.verifyPlanetPictureIsLoaded(DEFAULT_PLANET_ON_APPLICATION_START);

        assertEquals(
                "Default planet's name isn't displayed to the user on application start",
                DEFAULT_PLANET_ON_APPLICATION_START, getCurrentActivity().getActionBar().getTitle());
    }

    @Test
    public void checkCorrectPlanetsNumberIsAvailableForUser() {
        planetsShowRoomPage.openPlanetsSelectionMenu();

        spoon.screenshot(getCurrentActivity(), "OpenedPlanetsMenu");

        planetsShowRoomPage.verifyNumberOfPlanetsAvailable(NUMBER_OF_PLANETS_SOLAR_SYSTEM);

        planetsShowRoomPage.closePlanetsSelectionMenu();
    }
}