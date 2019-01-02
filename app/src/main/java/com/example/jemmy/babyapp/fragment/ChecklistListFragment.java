package com.example.jemmy.babyapp.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jemmy.babyapp.R;
import com.example.jemmy.babyapp.adapter.ChecklistRecyclerAdapter;
import com.example.jemmy.babyapp.entities.Checklist;
import com.example.jemmy.babyapp.entities.ChecklistParentContent;
import com.example.jemmy.babyapp.view.CustomLinearLayoutManager;

public class ChecklistListFragment extends Fragment {

    private String TAG="ChecklistListFragment";

    private RecyclerView recyclerChecklist;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment2_checklist_recycler_content, container, false);

        recyclerChecklist = v.findViewById(R.id.recyclerChecklist);

        RecyclerView.LayoutManager layoutManager = new CustomLinearLayoutManager(getActivity());
        recyclerChecklist.setLayoutManager(layoutManager);
        ChecklistRecyclerAdapter checkAdapter = new ChecklistRecyclerAdapter(getActivity());
        recyclerChecklist.setAdapter(checkAdapter);

        Checklist checklist = getArguments().getParcelable("text");
        Log.d(TAG,String.format("checlist data recycler %s",checklist));

        for (ChecklistParentContent parent : checklist.getChecklistParentContents()){
            checkAdapter.add(parent);
        }

        return v;
    }

    public static ChecklistListFragment newInstance(Checklist content) {

        ChecklistListFragment f = new ChecklistListFragment();
        Bundle b = new Bundle();
        b.putParcelable("text", content);

        f.setArguments(b);

        return f;
    }
}
