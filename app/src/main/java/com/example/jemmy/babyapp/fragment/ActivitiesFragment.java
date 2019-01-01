package com.example.jemmy.babyapp.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jemmy.babyapp.R;
import com.example.jemmy.babyapp.adapter.ActivitiesAdapter;
import com.example.jemmy.babyapp.adapter.PagerPerkembanganBayiAdapter;
import com.example.jemmy.babyapp.entities.Activities;
import com.example.jemmy.babyapp.entities.PerkembanganBayi;

import java.util.ArrayList;

public class ActivitiesFragment extends Fragment {

    private ViewPager viewPager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment2_activities, container, false);

        viewPager = view.findViewById(R.id.contentActivities);

        ArrayList<Activities> listPerkembanganBayis = new ArrayList<>();
        Activities perkembanganBayi = new Activities();
        perkembanganBayi.setText("HELLO");
        listPerkembanganBayis.add(perkembanganBayi);
        Activities perkembanganBayi1 = new Activities();
        perkembanganBayi1.setText("HELLO WORLD");
        listPerkembanganBayis.add(perkembanganBayi1);
        Activities perkembanganBayi2 = new Activities();
        perkembanganBayi2.setText("HELLO WORLD !!!!");
        listPerkembanganBayis.add(perkembanganBayi2);
        Activities perkembanganBayi3 = new Activities();
        perkembanganBayi3.setText("HELLO WORLD .....!!!!");
        listPerkembanganBayis.add(perkembanganBayi3);
        Activities perkembanganBayi4 = new Activities();
        perkembanganBayi4.setText("HELLO WORLD .....!!!!");
        listPerkembanganBayis.add(perkembanganBayi4);
        Activities perkembanganBayi5 = new Activities();
        perkembanganBayi5.setText("HELLO WORLD .....!!!!");
        listPerkembanganBayis.add(perkembanganBayi5);
        Activities perkembanganBayi6 = new Activities();
        perkembanganBayi6.setText("HELLO WORLD .....!!!!");
        listPerkembanganBayis.add(perkembanganBayi6);

        viewPager.setAdapter(new ActivitiesAdapter(getActivity().getSupportFragmentManager(),getActivity(), listPerkembanganBayis));
        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.tablayoutActivities);
        tabLayout.setupWithViewPager(viewPager);

        return view;
    }
}
