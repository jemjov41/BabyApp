package com.example.jemmy.babyapp.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jemmy.babyapp.R;
import com.example.jemmy.babyapp.adapter.ChecklistAdapter;
import com.example.jemmy.babyapp.entities.Checklist;
import com.example.jemmy.babyapp.entities.ChecklistParentContent;
import com.example.jemmy.babyapp.entities.ChecklistChild;

import java.util.ArrayList;

public class ChecklistFragment extends Fragment {

    private String TAG = "ChecklistFragment";

    private ViewPager viewPager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment2_checklist, container, false);

        viewPager = view.findViewById(R.id.contentChecklist);

        ArrayList<Checklist> test = new ArrayList<>();

        ArrayList<ChecklistParentContent> test1 = new ArrayList<>();
        ChecklistParentContent checklistParentContent = new ChecklistParentContent();
        checklistParentContent.setParent("test");

        ArrayList<ChecklistChild> checklistChildArray = new ArrayList<>();
        ChecklistChild checklistChild = new ChecklistChild();
        checklistChild.setDone(true);
        checklistChild.setText("coba recycler");

        checklistChildArray.add(checklistChild);

        ChecklistChild checklistChild1 = new ChecklistChild();
        checklistChild1.setDone(true);
        checklistChild1.setText("coba recycler 1 ");
        checklistChildArray.add(checklistChild1);

        ChecklistChild checklistChild2 = new ChecklistChild();
        checklistChild2.setDone(true);
        checklistChild2.setText("coba recycler 2 ");
        checklistChildArray.add(checklistChild2);

        checklistParentContent.setChecklistChildren(checklistChildArray);

        test1.add(checklistParentContent);

        Checklist checklist = new Checklist();
        checklist.setChecklistParentContents(test1);

        test.add(checklist);
        test.add(checklist);
        test.add(checklist);
        test.add(checklist);

        Log.d(TAG,String.format("object send %s",test));

        viewPager.setAdapter(new ChecklistAdapter(getActivity().getSupportFragmentManager(),getActivity(), test));

        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.tablayoutChecklist);
        tabLayout.setupWithViewPager(viewPager);

        return view;

    }
}
