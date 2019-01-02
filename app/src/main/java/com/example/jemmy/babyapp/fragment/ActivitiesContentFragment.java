package com.example.jemmy.babyapp.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.jemmy.babyapp.R;
import com.example.jemmy.babyapp.adapter.ActivitiesListAdapter;
import com.example.jemmy.babyapp.entities.Activities;

import java.util.ArrayList;

public class ActivitiesContentFragment extends Fragment {

    private ListView listActivites;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment2_activities_content, container, false);

        listActivites = v.findViewById(R.id.listActivites);
        ArrayList<Activities> activitiesList = new ArrayList<>();
        Activities activities = new Activities();
        activities.setText("text 1");
        activities.setDone(false);
        activitiesList.add(activities);

        Activities activities1 = new Activities();
        activities1.setText("text 2");
        activities1.setDone(true);
        activitiesList.add(activities1);

        Activities activities2 = new Activities();
        activities2.setText("text 3");
        activities2.setDone(true);
        activitiesList.add(activities2);

        Activities activities3 = new Activities();
        activities3.setText("text 4");
        activities3.setDone(false);
        activitiesList.add(activities3);

        Activities activities4 = new Activities();
        activities4.setText("text 5");
        activities4.setDone(true);
        activitiesList.add(activities4);
        listActivites.setAdapter(new ActivitiesListAdapter(getActivity(),activitiesList));

        return v;
    }

    public static ActivitiesContentFragment newInstance(Activities content) {

        ActivitiesContentFragment f = new ActivitiesContentFragment();
        Bundle b = new Bundle();
        b.putString("text", content.getText());

        f.setArguments(b);

        return f;
    }
}
