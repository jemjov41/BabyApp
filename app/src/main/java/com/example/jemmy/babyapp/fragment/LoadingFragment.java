package com.example.jemmy.babyapp.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jemmy.babyapp.R;

public class LoadingFragment extends Fragment {

    public static LoadingFragment createInstance() {
        LoadingFragment fragment = new LoadingFragment();

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_loading, container, false);

        return view;
    }
}
