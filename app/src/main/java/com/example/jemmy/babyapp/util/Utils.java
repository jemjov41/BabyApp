package com.example.jemmy.babyapp.util;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;

public class Utils {

    public static int getDisplayWidth(Activity activity) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int width = displayMetrics.widthPixels;
        return width;
    }

    public static void buttonSmallerEffect(Activity activity, MotionEvent event, final LinearLayout button) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                ObjectAnimator scaleDownX = ObjectAnimator.ofFloat(button,
                        "scaleX", 0.8f);
                ObjectAnimator scaleDownY = ObjectAnimator.ofFloat(button,
                        "scaleY", 0.8f);
                scaleDownX.setDuration(50);
                scaleDownY.setDuration(50);

                AnimatorSet scaleDown = new AnimatorSet();
                scaleDown.play(scaleDownX).with(scaleDownY);

                scaleDown.start();

                break;

            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL:
                ObjectAnimator scaleDownX2 = ObjectAnimator.ofFloat(
                        button, "scaleX", 1f);
                ObjectAnimator scaleDownY2 = ObjectAnimator.ofFloat(
                        button, "scaleY", 1f);
                scaleDownX2.setDuration(400);
                scaleDownY2.setDuration(400);

                AnimatorSet scaleDown2 = new AnimatorSet();
                scaleDown2.play(scaleDownX2).with(scaleDownY2);

                scaleDown2.start();

                Log.d("asd", String.format("back button clicked"));
                Log.d("asd", String.format("back button click %s", activity.getFragmentManager().getBackStackEntryCount()));
                break;
        }
    }
}
