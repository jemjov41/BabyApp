package com.example.jemmy.babyapp.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.jemmy.babyapp.R;

import java.util.ArrayList;
import java.util.List;

public class TipsArrayAdapter extends ArrayAdapter<String> {

    private Context mContext;
    private List<String> stringTipsList = new ArrayList<>();

    public TipsArrayAdapter(@NonNull Context context, ArrayList<String> resource) {
        super(context, 0,resource);

        this.mContext= context;
        this.stringTipsList = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItem = convertView;
        if(listItem == null)
            listItem = LayoutInflater.from(mContext).inflate(R.layout.fragment2_tips_list_content,parent,false);

        String tips = stringTipsList.get(position);

        TextView textActivities = (TextView)listItem.findViewById(R.id.textTips);
        textActivities.setText(tips);

        return listItem;
    }

}
