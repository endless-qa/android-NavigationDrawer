package com.example.android.navigationdrawer.tests.matchers;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

public class DrawableMatcher extends TypeSafeMatcher<View> {

    private String expectedResourceName;

    DrawableMatcher(String expectedName) {
        expectedResourceName = expectedName;
    }

    @Override
    protected boolean matchesSafely(View targetView) {

        // do not perform comparison if the target view is not ImageView
        if (!(targetView instanceof ImageView)) {
            return false;
        }

        ImageView imageView = (ImageView) targetView;

        Context currentContext = targetView.getContext();
        Resources resources = currentContext.getResources();

        int expectedDrawableId = resources.getIdentifier(expectedResourceName.toLowerCase(),
                "drawable", currentContext.getPackageName());

        Drawable expectedDrawable = resources.getDrawable(expectedDrawableId);

        // do not perform comparison if couldn't get drawable from the resources
        if (expectedDrawable == null) {
            return false;
        }

        Bitmap actualDisplayedBitmap = createBitmapFromDrawable(imageView.getDrawable());
        Bitmap expectedBitmapFromResources = createBitmapFromDrawable(expectedDrawable);

        return actualDisplayedBitmap.sameAs(expectedBitmapFromResources);
    }

    @Override
    public void describeTo(Description description) {
        description.appendText(
                "Actual drawable from the image view doesn't match to the expected resource one");
    }

    /**
     * Creates a bitmap from the specified drawable object
     * @param drawable a Drawable object to create a bitmap from
     * @return Actual bitmap created from the passed Drawable object
     */
    private Bitmap createBitmapFromDrawable(Drawable drawable) {
        Bitmap bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(),
                drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);

        Canvas canvas = new Canvas(bitmap);

        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);

        return bitmap;
    }
}