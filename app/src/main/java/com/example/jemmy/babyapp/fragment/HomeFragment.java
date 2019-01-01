package com.example.jemmy.babyapp.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.jemmy.babyapp.MainActivity;
import com.example.jemmy.babyapp.R;

public class HomeFragment extends Fragment {

    private LinearLayout perkembanganBayi;
    private LinearLayout checklist;
    private LinearLayout activities;
    private LinearLayout resepMakanan;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_home, container, false);

        perkembanganBayi = view.findViewById(R.id.homePerkembanganBayi);
        checklist = view.findViewById(R.id.homeChecklist);
        activities = view.findViewById(R.id.homeActivities);
        resepMakanan = view.findViewById(R.id.homeResepMpasi);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        perkembanganBayi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               MainActivity mainActivity = (MainActivity) getActivity();
               mainActivity.changeToPerkembangan();
            }
        });

        activities.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity mainActivity = (MainActivity) getActivity();
                mainActivity.changeToActivities();
            }
        });

        checklist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity mainActivity = (MainActivity) getActivity();
                mainActivity.changeToChecklist();
            }
        });

        resepMakanan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity mainActivity = (MainActivity) getActivity();
                mainActivity.changeToResepMakanan();
            }
        });
    }
}
