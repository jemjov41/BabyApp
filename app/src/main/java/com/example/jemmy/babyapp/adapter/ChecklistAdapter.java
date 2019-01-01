package com.example.jemmy.babyapp.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.jemmy.babyapp.entities.Checklist;
import com.example.jemmy.babyapp.entities.ChecklistParentContent;
import com.example.jemmy.babyapp.fragment.ChecklistListFragment;

import java.util.ArrayList;

public class ChecklistAdapter extends FragmentPagerAdapter {

    private Context mContext;
    private ArrayList<Checklist> listChecklist;

    public ChecklistAdapter(FragmentManager fm, Context mContext, ArrayList<Checklist> list) {
        super(fm);
        this.mContext = mContext;
        this.listChecklist = list;
    }

    @Override
    public Fragment getItem(int position) {
        return ChecklistListFragment.newInstance(listChecklist.get(position));
    }

    @Override
    public int getCount() {
        return listChecklist.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return "page activies ke " + position;
    }
}
