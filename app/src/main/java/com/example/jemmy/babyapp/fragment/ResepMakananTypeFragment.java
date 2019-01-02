package com.example.jemmy.babyapp.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.jemmy.babyapp.R;

import java.io.Serializable;

public class ResepMakananTypeFragment extends Fragment {

    private String TAG = "ResepMakananTypeFrag";

    private static FrameLayout typeSelected;
    public static final String PARAM_KIND = "kind";

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
                resepAllShow(getFragmentManager());
                selectSign();
                enableAndDisableClick();
            }
        });

        resepBookmark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resepBookmarkShow(getFragmentManager());
                selectSign();
                enableAndDisableClick();
            }
        });

        final Bundle b = getArguments();
        final Kind kind = (Kind) b.getSerializable(PARAM_KIND);
        switch (kind) {
            case ALL:
                resepAllShow(getFragmentManager());
                selectSign();
                enableAndDisableClick();
                break;
            case BOOKMARK:
                resepBookmarkShow(getFragmentManager());
                selectSign();
                enableAndDisableClick();
                break;
        }

        return view;
    }

    public static ResepMakananTypeFragment newInstance(Kind kind, FrameLayout resepContent) {
        final ResepMakananTypeFragment f = new ResepMakananTypeFragment();

        Bundle b = new Bundle();
        b.putSerializable(PARAM_KIND, kind);
        f.setArguments(b);

        typeSelected = resepContent;
        return f;
    }

    public static void resepAllShow(FragmentManager fm) {
        final FragmentTransaction ft = fm.beginTransaction();
        ft.setCustomAnimations(R.anim.enter_from_left, R.anim.exit_to_right);

        ResepMakananContentFragment resepContent = ResepMakananContentFragment.newInstance(Kind.ALL);
        ft.replace(typeSelected.getId(), resepContent);
        ft.commit();
        flag = Kind.ALL;
    }

    public static void resepBookmarkShow(FragmentManager fm) {
        Log.d("asd", String.format("frame content resep id %s", typeSelected.getId()));
        final FragmentTransaction ft = fm.beginTransaction();
        ft.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left);

        ResepMakananContentFragment resepContent = ResepMakananContentFragment.newInstance(Kind.BOOKMARK);
        ft.replace(typeSelected.getId(), resepContent);
        ft.commit();
        flag = Kind.BOOKMARK;
    }

    private void selectSign() {
        switch (flag) {
            case ALL:
                signAll.setVisibility(View.VISIBLE);
                signBookmark.setVisibility(View.INVISIBLE);
                break;
            case BOOKMARK:
                signAll.setVisibility(View.INVISIBLE);
                signBookmark.setVisibility(View.VISIBLE);
                break;
        }
    }

    private void enableAndDisableClick() {
        switch (flag) {
            case ALL:
                resepAll.setEnabled(false);
                resepBookmark.setEnabled(true);
                break;
            case BOOKMARK:
                resepAll.setEnabled(true);
                resepBookmark.setEnabled(false);
                break;
        }
    }
}
