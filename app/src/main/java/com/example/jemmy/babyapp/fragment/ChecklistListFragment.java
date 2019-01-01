package com.example.jemmy.babyapp.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.jemmy.babyapp.R;
import com.example.jemmy.babyapp.adapter.ChecklistListAdapter;
import com.example.jemmy.babyapp.entities.Checklist;
import com.example.jemmy.babyapp.entities.ChecklistParentContent;

public class ChecklistListFragment extends Fragment {

    private String TAG="ChecklistListFragment";

    private ListView listChecklist;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment2_checklist_list_content, container, false);

        listChecklist = v.findViewById(R.id.listChecklist);

        Checklist checklist = getArguments().getParcelable("text");
        Log.d(TAG,String.format("checklist object in checklist fragment %s",checklist));

        listChecklist.setAdapter(new ChecklistListAdapter(getActivity(),checklist.getChecklistParentContents()));

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
