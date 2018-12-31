package com.example.jemmy.babyapp.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.jemmy.babyapp.MainActivity;
import com.example.jemmy.babyapp.R;
import com.example.jemmy.babyapp.adapter.Tips2ArrayAdapter;
import com.example.jemmy.babyapp.entities.TipsLevel2;
import com.example.jemmy.babyapp.util.Utils;

import java.util.ArrayList;

public class Tips3Fragment extends Fragment {
    private String TAG = "Tips2Fragment";

    private LinearLayout imageBack;
    private TextView tvTitle;

    private ImageView imgContent;
    private TextView contentTitle;
    private TextView contentDesc;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment2_tips3_content, container, false);

        imageBack = view.findViewById(R.id.tips3Back);
        tvTitle = view.findViewById(R.id.titleTips3);

        imgContent = view.findViewById(R.id.tips3Image);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Bundle arguments = getArguments();

        tvTitle.setText(arguments.getString("title"));

        
        imageBack.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Utils.buttonSmallerEffect(getActivity(),event, imageBack);
                getActivity().onBackPressed();
                return true;
            }
        });

    }
}
