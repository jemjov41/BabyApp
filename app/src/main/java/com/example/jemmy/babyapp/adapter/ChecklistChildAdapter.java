package com.example.jemmy.babyapp.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.jemmy.babyapp.R;
import com.example.jemmy.babyapp.entities.Checklist;
import com.example.jemmy.babyapp.entities.ChecklistChild;
import com.example.jemmy.babyapp.entities.ChecklistParentContent;

import java.util.ArrayList;

public class ChecklistChildAdapter extends ArrayAdapter<ChecklistChild> {

    private String TAG="ChecklistChildAdapter";

    private Context mContext;
    private ArrayList<ChecklistChild> checklistList ;

    public ChecklistChildAdapter(@NonNull Context context,  ArrayList<ChecklistChild> resource) {
        super(context, 0,resource);

        this.mContext= context;
        this.checklistList = resource;

        Log.d(TAG,String.format("write 1 child %s",checklistList.size()));
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItem = convertView;
        if(listItem == null)
            listItem = LayoutInflater.from(mContext).inflate(R.layout.fragment2_checklist_list_child_content,parent,false);

        Log.d(TAG,String.format("write 1 child"));
        TextView textView = listItem.findViewById(R.id.textListChecklist);
        textView.setText(checklistList.get(position).getText());

        CheckBox checkBox = listItem.findViewById(R.id.checkChecklist);
        checkBox.setChecked(checklistList.get(position).isDone());

        return listItem;
    }
}
