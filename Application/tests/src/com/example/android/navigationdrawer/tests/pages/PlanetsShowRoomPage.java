package com.example.android.navigationdrawer.tests.pages;

import com.example.android.navigationdrawer.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.*;
import static android.support.test.espresso.matcher.ViewMatchers.*;
import static com.example.android.navigationdrawer.tests.matchers.CustomMatchers.withDrawableByName;

import android.support.test.espresso.contrib.DrawerActions;

/**
 * Model class that represents planets selection and displaying activity
 */
public class PlanetsShowRoomPage {

    private static final String PLANETS_NAVIGATION_DRAWER_TITLE = "Navigation Drawer";

    /**
     * Opens planets selection menu (drawer) and verifies that it's completely opened for further
     * interactions (planets selection)
     */
    public void openPlanetsSelectionMenu() {
        onView(withId(R.id.drawer_layout)).perform(DrawerActions.open());
        onView(withText(PLANETS_NAVIGATION_DRAWER_TITLE)).check(matches(isDisplayed()));
    }

    /**
     * Closes the planets selection menu and verifies that it was completely closed
     */
    public void closePlanetsSelectionMenu() {
        onView(withId(R.id.drawer_layout)).perform(DrawerActions.close());
        onView(withText(PLANETS_NAVIGATION_DRAWER_TITLE)).check(doesNotExist());
    }

    /**
     * Selects a planet from the menu, closes the menu and verifies that it was completely closed
     * @param planet a planet's name to be selected from the menu
     */
    public void selectPlanet(String planet) {
        onView(withText(planet)).perform(click());
        closePlanetsSelectionMenu();
    }

    /**
     * Checks if there is a specific number of planets available for selection in the left menu
     * @param num a desired number of planets in the menu
     */
    public void verifyNumberOfPlanetsAvailable(int num) {
        onView(withId(R.id.left_drawer)).check(matches(hasChildCount(num)));
    }

    /**
     * Verifies that the displayed planet's picture corresponds to it's appropriate resource file
     * by comparing the resource drawable with the actual drawable taken from the ImageView
     * @param planet a planet's name to verify the displayed picture for
     */
    public void verifyPlanetPictureIsLoaded(String planet) {
        onView(withId(R.id.image)).check(matches(withDrawableByName(planet)));
    }

    /**
     * Initiates web-search for the currently displayed on the showroom page planet
     */
    public void searchCurrentPlanetInfo() {
        onView(withId(R.id.action_websearch)).perform(click());
    }
}