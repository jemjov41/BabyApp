package com.example.jemmy.babyapp.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.jemmy.babyapp.R;
import com.example.jemmy.babyapp.entities.Activities;

import java.util.ArrayList;
import java.util.List;

public class ActivitiesListAdapter extends ArrayAdapter<Activities> {

    private Context mContext;
    private List<Activities> activitiesList = new ArrayList<>();

    public ActivitiesListAdapter(@NonNull Context context, ArrayList<Activities> resource) {
        super(context, 0, (List<Activities>) resource);

        this.mContext= context;
        this.activitiesList = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItem = convertView;
        if(listItem == null)
            listItem = LayoutInflater.from(mContext).inflate(R.layout.fragment2_activities_list_content,parent,false);

        Activities activities = activitiesList.get(position);

        TextView textActivities = (TextView)listItem.findViewById(R.id.textListActivities);
        textActivities.setText(activities.getText());

        CheckBox checkActivies = (CheckBox) listItem.findViewById(R.id.checkListActivities);
        checkActivies.setChecked(activities.isDone());
        if (activities.isDone()){
            checkActivies.setEnabled(false);
        }


        return listItem;
    }
}
