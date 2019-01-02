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
    private ArrayList<Checklist> test;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment2_checklist, container, false);

        viewPager = view.findViewById(R.id.contentChecklist);

        test = new ArrayList<>();

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

        ChecklistParentContent checklistParentContent1 = new ChecklistParentContent();
        checklistParentContent1.setParent("test");

        ArrayList<ChecklistChild> checklistChildArray1 = new ArrayList<>();
        ChecklistChild checklistChild11 = new ChecklistChild();
        checklistChild11.setDone(true);
        checklistChild11.setText("coba 2 recycler");
        checklistChildArray1.add(checklistChild11);


        checklistParentContent1.setChecklistChildren(checklistChildArray1);

        test1.add(checklistParentContent1);

        ChecklistParentContent checklistParentContent2 = new ChecklistParentContent();
        checklistParentContent2.setParent("test test test");

        ArrayList<ChecklistChild> checklistChildArray2= new ArrayList<>();
        ChecklistChild checklistChild21 = new ChecklistChild();
        checklistChild21.setDone(true);
        checklistChild21.setText("coba 3 recycler");
        checklistChildArray2.add(checklistChild21);

        ChecklistChild checklistChild22 = new ChecklistChild();
        checklistChild22.setDone(true);
        checklistChild22.setText("coba  3 recycler 1 ");
        checklistChildArray2.add(checklistChild22);


        checklistParentContent2.setChecklistChildren(checklistChildArray2);

        test1.add(checklistParentContent2);

        Checklist checklist = new Checklist();
        checklist.setChecklistParentContents(test1);

        test.add(checklist);
        test.add(checklist);
        test.add(checklist);
        test.add(checklist);

        Log.d(TAG,String.format("object send %s",test));

        viewPager.setAdapter(new ChecklistAdapter(getChildFragmentManager(),getActivity(), test));

        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.tablayoutChecklist);
        tabLayout.setupWithViewPager(viewPager);

        return view;

    }

}
