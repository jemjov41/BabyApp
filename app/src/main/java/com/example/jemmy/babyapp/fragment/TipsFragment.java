package com.example.jemmy.babyapp.fragment;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
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
import android.widget.Toolbar;

import com.example.jemmy.babyapp.MainActivity;
import com.example.jemmy.babyapp.R;
import com.example.jemmy.babyapp.adapter.TipsArrayAdapter;
import com.example.jemmy.babyapp.util.Utils;

import java.util.ArrayList;

public class TipsFragment extends Fragment {

    private String TAG="TipsFragment";

    private LinearLayout imageBack;

    private ImageView imgTips;
    private ListView listView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment2_tips, container, false);

        imageBack = view.findViewById(R.id.tipsBack);

        imgTips = view.findViewById(R.id.tipsImage);
        listView = view.findViewById(R.id.tispListVIew);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ArrayList<String> tipsList = new ArrayList<>();
        tipsList.add("Sleep");
        tipsList.add("Feeding");
        tipsList.add("Crying");
        tipsList.add("baby care");
        tipsList.add("safety");
        tipsList.add("Sleep");
        tipsList.add("Feeding");
        tipsList.add("Crying");
        tipsList.add("baby care");
        tipsList.add("safety");

        listView.setAdapter(new TipsArrayAdapter(getActivity(),tipsList));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d(TAG,String.format("clicked %s",position));
                Log.d(TAG,String.format("clicked %s",listView.getItemAtPosition(position)));
                Bundle arguments = new Bundle();
                arguments.putString( "title" , listView.getItemAtPosition(position).toString());
                MainActivity main = (MainActivity) getActivity();
                main.changeToTips2(arguments);
            }
        });

        imageBack.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Utils.buttonSmallerEffect(getActivity(),event,imageBack);
                return true;
            }
        });

        imageBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,String.format("back button clicked"));
                Log.d(TAG,String.format("back button click %s",getFragmentManager().getBackStackEntryCount()));
            }
        });

    }
}
