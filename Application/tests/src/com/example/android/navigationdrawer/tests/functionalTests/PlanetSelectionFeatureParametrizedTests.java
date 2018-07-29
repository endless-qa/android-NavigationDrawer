package com.example.android.navigationdrawer.tests.functionalTests;

import android.support.test.rule.ActivityTestRule;

import com.example.android.navigationdrawer.MainActivity;
import com.example.android.navigationdrawer.tests.BaseTestModel;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;


@RunWith(Parameterized.class)
public class PlanetSelectionFeatureParametrizedTests extends BaseTestModel {

    @Parameterized.Parameters(name = "{0}")
    public static Object[] inputListOfPlanets() {
        return new Object[]
                { "Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune" };
    }

    @Parameterized.Parameter
    public String planetName;

    @Rule
    public ActivityTestRule<MainActivity>
            mainActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void checkPlanetCanBeSelectedAndDisplayedToUser() {
        planetsShowRoomPage.openPlanetsSelectionMenu();
        planetsShowRoomPage.selectPlanet(planetName);
        planetsShowRoomPage.verifyPlanetPictureIsLoaded(planetName);

        assertEquals("Incorrect planet's name is displayed to the user",
                planetName, getCurrentActivity().getActionBar().getTitle());
    }
}