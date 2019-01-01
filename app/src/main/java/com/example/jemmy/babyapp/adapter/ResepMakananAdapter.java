package com.example.jemmy.babyapp.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.jemmy.babyapp.entities.Activities;
import com.example.jemmy.babyapp.entities.ResepMakananList;
import com.example.jemmy.babyapp.fragment.ActivitiesContentFragment;
import com.example.jemmy.babyapp.fragment.ResepMakananBodyFragment;

import java.util.ArrayList;

public class ResepMakananAdapter extends FragmentPagerAdapter {

    private Context mContext;
    private ArrayList<ResepMakananList> listPerkembangan;

    public ResepMakananAdapter(FragmentManager fm, Context mContext, ArrayList<ResepMakananList> list) {
        super(fm);
        this.mContext = mContext;
        this.listPerkembangan = list;
    }

    @Override
    public Fragment getItem(int position) {
        return ResepMakananBodyFragment.newInstance(listPerkembangan.get(position));
    }

    @Override
    public int getCount() {
        return listPerkembangan.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return "page makanan ke " + position;
    }
}
