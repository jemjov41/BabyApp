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
import com.example.jemmy.babyapp.adapter.ResepMakananAdapter;
import com.example.jemmy.babyapp.entities.ResepMakanan;
import com.example.jemmy.babyapp.entities.ResepMakananList;

import java.util.ArrayList;

public class ResepMakananFragment extends Fragment {

    private ViewPager viewPager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment2_resep_makanan, container, false);

        ArrayList<ResepMakananList> listResep = new ArrayList<>();

        ResepMakananList resepList = new ResepMakananList();

        ArrayList<ResepMakanan> resepMakanans = new ArrayList<>();

        ResepMakanan resepMakanan = new ResepMakanan();
        resepMakanan.setBookmark(false);
        resepMakanan.setImageUrl("image url");
        resepMakanan.setKisaranUsia("6 - 8 bulan");
        resepMakanan.setNamaResep("bubur");

        resepMakanans.add(resepMakanan);
        resepMakanans.add(resepMakanan);
        resepMakanans.add(resepMakanan);

        resepList.setResepMakanans(resepMakanans);

        listResep.add(resepList);
        listResep.add(resepList);
        listResep.add(resepList);
        listResep.add(resepList);

        viewPager = view.findViewById(R.id.contentResepMakann);
        viewPager.setAdapter(new ResepMakananAdapter(getActivity().getSupportFragmentManager(),getActivity(), listResep));
        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.tablayoutResepMakanan);
        tabLayout.setupWithViewPager(viewPager);
        return view;
    }
}
