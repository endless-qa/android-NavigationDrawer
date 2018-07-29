package com.example.android.navigationdrawer.tests.matchers;

import android.view.View;
import org.hamcrest.Matcher;

/**
 * Class-holder for custom matchers that don't exist in Espresso by default
 */
public class CustomMatchers {

    /**
     * Checks that a proper drawable that matches the specified
     * resource name is loaded on the image view
     * @param expectedName a resource name that needs to be checked
     * @return an appropriate matcher object to be used
     */
    public static Matcher<View> withDrawableByName(String expectedName) {
        return new DrawableMatcher(expectedName);
    }
}