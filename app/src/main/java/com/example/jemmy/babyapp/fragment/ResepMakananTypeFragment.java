package com.example.jemmy.babyapp.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.jemmy.babyapp.R;
import com.example.jemmy.babyapp.adapter.ResepMakananAdapter;

import java.io.Serializable;

public class ResepMakananTypeFragment extends Fragment {

    private static FrameLayout typeSelected;

    private LinearLayout resepAll;
    private LinearLayout resepBookmark;
    private ImageView signAll;
    private ImageView signBookmark;
    private static Kind flag;

    public enum Kind implements Serializable {
        ALL,
        BOOKMARK
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment2_resep_type, container, false);

        resepAll = view.findViewById(R.id.all_resep_wrap);
        resepBookmark = view.findViewById(R.id.bookmark_resep_wrap);

        signAll = view.findViewById(R.id.selectedSignAllResep);
        signBookmark = view.findViewById(R.id.selectedSignBookmark);

        resepAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        resepBookmark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        return view;
    }

    public static ResepMakananTypeFragment newInstance(FrameLayout resepContent) {
        final ResepMakananTypeFragment f = new ResepMakananTypeFragment();

        typeSelected = resepContent;
        return f;
    }

    public static void resepAllShow(FragmentActivity activity) {
        final FragmentTransaction ft = activity.getSupportFragmentManager().beginTransaction();
        ft.setCustomAnimations(R.anim.enter_from_left, R.anim.exit_to_right);
        ft.replace(typeSelected.getId(), new ResepMakananContentFragment());
        ft.commit();
        flag = Kind.ALL;
    }

    public static void resepBookmarkShow(FragmentActivity activity) {
        final FragmentTransaction ft = activity.getSupportFragmentManager().beginTransaction();
        ft.setCustomAnimations(R.anim.enter_from_left, R.anim.exit_to_right);
        ft.replace(typeSelected.getId(), new ResepMakananContentFragment());
        ft.commit();
        flag = Kind.BOOKMARK;
    }

    private void selectSign(){
        switch (flag){
            case ALL:

                break;
            case BOOKMARK:

                break;
        }
    }

    private void enableAndDisableClick(){
        switch (flag){
            case ALL:

                break;
            case BOOKMARK:

                break;
        }
    }
}
