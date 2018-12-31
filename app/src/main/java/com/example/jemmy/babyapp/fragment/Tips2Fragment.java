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
import com.example.jemmy.babyapp.adapter.TipsArrayAdapter;
import com.example.jemmy.babyapp.entities.TipsLevel2;
import com.example.jemmy.babyapp.util.Utils;

import java.util.ArrayList;

public class Tips2Fragment extends Fragment {
    private String TAG = "Tips2Fragment";

    private LinearLayout imageBack;
    private TextView tvTitle;

    private ListView listView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment2_tips2, container, false);

        imageBack = view.findViewById(R.id.tips2Back);
        tvTitle = view.findViewById(R.id.titleTips2);

        listView = view.findViewById(R.id.tispList2VIew);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Bundle arguments = getArguments();

        tvTitle.setText(arguments.getString("title"));
        ArrayList<TipsLevel2> tipsList = new ArrayList<>();
        TipsLevel2 tips = new TipsLevel2();
        tips.setText("How Much Sleep");
        tipsList.add(tips);

        TipsLevel2 tips1 = new TipsLevel2();
        tips1.setText("Sleep Routine");
        tipsList.add(tips1);

        TipsLevel2 tips2 = new TipsLevel2();
        tips2.setText("How Much Sleep");
        tipsList.add(tips2);

        TipsLevel2 tips3 = new TipsLevel2();
        tips3.setText("Good Sleep");
        tipsList.add(tips3);

        TipsLevel2 tips4 = new TipsLevel2();
        tips4.setText("Sleep Tips");
        tipsList.add(tips4);

        TipsLevel2 tips5 = new TipsLevel2();
        tips5.setText("Sleep Trouble");
        tipsList.add(tips5);

        listView.setAdapter(new Tips2ArrayAdapter(getActivity(), tipsList));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d(TAG, String.format("clicked %s", position));
                Log.d(TAG, String.format("clicked %s", listView.getItemAtPosition(position)));

                Bundle arguments = new Bundle();
                TipsLevel2 tipsLevel2 = (TipsLevel2) listView.getItemAtPosition(position);
                arguments.putString( "title" , tipsLevel2.getText());
                MainActivity main = (MainActivity) getActivity();
                main.changeToTips3(arguments);
            }
        });

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
