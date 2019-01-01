package com.example.jemmy.babyapp.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.jemmy.babyapp.R;
import com.example.jemmy.babyapp.entities.Checklist;
import com.example.jemmy.babyapp.entities.ChecklistParentContent;

import java.util.ArrayList;
import java.util.List;

public class ChecklistListAdapter extends ArrayAdapter<ChecklistParentContent> {

    private Context mContext;
    private ArrayList<ChecklistParentContent> checklistList ;

    private ListView listViewChecklsit;

    private LinearLayout parentMenu;
    private LinearLayout childMenu;

    public ChecklistListAdapter(@NonNull Context context, ArrayList<ChecklistParentContent> resource) {
        super(context, 0, resource);

        this.mContext= context;
        this.checklistList = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItem = convertView;
        if(listItem == null)
            listItem = LayoutInflater.from(mContext).inflate(R.layout.fragment2_checklist_content,parent,false);

        TextView parentChecklist= (TextView)listItem.findViewById(R.id.titleChecklist);
        parentChecklist.setText(checklistList.get(position).getParent());

        listViewChecklsit = listItem.findViewById(R.id.listChecklistChild);
        listViewChecklsit.setAdapter(new ChecklistChildAdapter(mContext, checklistList.get(position).getChecklistChildren()));


        parentMenu = listItem.findViewById(R.id.checklishTitle);
        childMenu = listItem.findViewById(R.id.checklishExpandMenu);

        parentMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                childMenu.setVisibility(childMenu.isShown()? View.GONE: View.VISIBLE);
            }
        });

        return listItem;
    }
}
