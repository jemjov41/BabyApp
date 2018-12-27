package com.example.jemmy.babyapp.fragment;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jemmy.babyapp.MainActivity;
import com.example.jemmy.babyapp.R;
import com.example.jemmy.babyapp.SplashActivity;

public class SplashFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_splash, container, false);

        final FragmentTransaction ft = getChildFragmentManager().beginTransaction();
        ft.replace(R.id.fragmentSplashContainer, new LoadingFragment());
        ft.commit();

        return view;
    }
}
