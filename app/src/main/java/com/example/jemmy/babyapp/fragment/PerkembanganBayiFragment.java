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
import com.example.jemmy.babyapp.adapter.PagerPerkembanganBayiAdapter;
import com.example.jemmy.babyapp.entities.PerkembanganBayi;

import java.util.ArrayList;

public class PerkembanganBayiFragment extends Fragment {

    private ViewPager viewPager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment2_perkembangan_bayi, container, false);

        viewPager = view.findViewById(R.id.contentPerkembangan);
        ArrayList<PerkembanganBayi> listPerkembanganBayis = new ArrayList<>();
        PerkembanganBayi perkembanganBayi = new PerkembanganBayi();
        perkembanganBayi.setText("HELLO");
        listPerkembanganBayis.add(perkembanganBayi);
        PerkembanganBayi perkembanganBayi1 = new PerkembanganBayi();
        perkembanganBayi1.setText("HELLO WORLD");
        listPerkembanganBayis.add(perkembanganBayi1);
        PerkembanganBayi perkembanganBayi2 = new PerkembanganBayi();
        perkembanganBayi2.setText("HELLO WORLD !!!!");
        listPerkembanganBayis.add(perkembanganBayi2);
        viewPager.setAdapter(new PagerPerkembanganBayiAdapter(getChildFragmentManager(),getActivity(), listPerkembanganBayis));
        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.tablayoutPerkembangan);
        tabLayout.setupWithViewPager(viewPager);

        return view;
    }
}
