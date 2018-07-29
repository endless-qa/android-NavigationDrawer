package com.example.android.navigationdrawer.tests.pages;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * A model that represents the entry activity of the application
 */
public class StartPage {

    private static final String PLANETS_SHOWROOM_ENTER_TITLE = "Navigation Drawer Example";

    /**
     * Navigates to the planets showroom page (planets selection and displaying activity)
     * @return a new {@link PlanetsShowRoomPage} object for further interaction
     */
    public PlanetsShowRoomPage enterPlanetsShowRoom() {
        onView(withText(PLANETS_SHOWROOM_ENTER_TITLE)).perform(click());

        return new PlanetsShowRoomPage();
    }
}