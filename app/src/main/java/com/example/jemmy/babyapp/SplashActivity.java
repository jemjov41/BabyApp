package com.example.jemmy.babyapp;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.jemmy.babyapp.fragment.SplashFragment;

public class SplashActivity extends BaseActivity{
    private static final String CURRENT_VIEW = "CURRENT_VIEW";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        final FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.fragmentContainer, new SplashFragment(), CURRENT_VIEW);
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        transaction.commit();

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
