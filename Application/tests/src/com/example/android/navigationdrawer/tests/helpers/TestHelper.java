package com.example.android.navigationdrawer.tests.helpers;

import android.app.Activity;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.lifecycle.ActivityLifecycleMonitorRegistry;
import android.support.test.uiautomator.UiDevice;

import java.io.IOException;
import java.util.Collection;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.runner.lifecycle.Stage.RESUMED;

/**
 * Contains additional methods that help to manage applications and flows while testing
 */
public class TestHelper {

    /**
     * Gets the current resumed activity from the appropriate registry
     * @return the current resumed activity
     */
    protected Activity getCurrentActivity(){
        final Activity[] currentActivity = {null};

        getInstrumentation().runOnMainSync(new Runnable() {
            public void run() {
                Collection resumedActivities = ActivityLifecycleMonitorRegistry.getInstance().getActivitiesInStage(RESUMED);
                if (resumedActivities.iterator().hasNext()){
                    currentActivity[0] = (Activity) resumedActivities.iterator().next();
                }
            }
        });

        return currentActivity[0];
    }

    /**
     * Closes a third-party application by its package name
     * @param packageName package name of a third-party application to be closed
     */
    protected void closeThirdPartyAppByPackage(String packageName) {
        try {
            UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())
                    .executeShellCommand(String.format("am force-stop %s", packageName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}