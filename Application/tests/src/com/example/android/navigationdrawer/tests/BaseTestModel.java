package com.example.android.navigationdrawer.tests;

import com.example.android.navigationdrawer.tests.helpers.TestHelper;
import com.example.android.navigationdrawer.tests.pages.PlanetsShowRoomPage;
import com.example.android.navigationdrawer.tests.pages.StartPage;
import com.squareup.spoon.SpoonRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;

/**
 * A parent class, initializer and holder of actions that are executed before/after
 * each test of its descendants
 */
public class BaseTestModel extends TestHelper{

    protected PlanetsShowRoomPage planetsShowRoomPage;

    @Rule
    public final SpoonRule spoon = new SpoonRule();

    /**
     * Common setup method that is executed before each test methods of child classes,
     * initializes {@link StartPage} and navigates to the {@link PlanetsShowRoomPage}.
     * As a result, the shared PlanetsShowRoomPage object is initialized and ready for interaction
     */
    @Before
    public void testSetUp() {
        StartPage startPage = new StartPage();
        planetsShowRoomPage = startPage.enterPlanetsShowRoom();
    }

    /**
     * Common teardown method that is executed after each test method of child classes.
     * Currently servers for taking a screenshot from the activity after each test
     */
    @After
    public void tearDown() {
        spoon.screenshot(getCurrentActivity(), "attachment");
    }
}