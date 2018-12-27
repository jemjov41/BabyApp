package com.example.jemmy.babyapp;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.view.Window;

/**
 * Created by rio on 11/23/17.
 */

public class BaseActivity extends AppCompatActivity {

    private static final String TAG = "BaseActivity";

    static {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            final Window w = getWindow();
            w.setStatusBarColor(ContextCompat.getColor(getApplicationContext(), R.color.appBar));
        }

    }
}
