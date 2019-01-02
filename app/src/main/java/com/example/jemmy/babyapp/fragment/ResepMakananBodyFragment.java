package com.example.jemmy.babyapp.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.example.jemmy.babyapp.R;
import com.example.jemmy.babyapp.entities.ResepMakananList;

public class ResepMakananBodyFragment extends Fragment {


    private String TAG = "resepMakananBody";

    private static final String RESEP_TYPE_KONTENT = "RESEP_TYPE_KONTENT";

    private static ResepMakananList resepList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment2_resep_makanan_content, container, false);

        Log.d(TAG, String.format("resep makanan %s", getArguments().getParcelable("text")));

        resepList = getArguments().getParcelable("text");

        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        FrameLayout resepContent = view.findViewById(R.id.flResepMakananContent);

        final ResepMakananTypeFragment resepTypeFragment =
                ResepMakananTypeFragment.newInstance(ResepMakananTypeFragment.Kind.ALL,resepContent);

        transaction.replace(R.id.flResepMakananType, resepTypeFragment, RESEP_TYPE_KONTENT);
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        transaction.commit();

        return view;
    }

    public static ResepMakananBodyFragment newInstance(ResepMakananList content) {

        ResepMakananBodyFragment f = new ResepMakananBodyFragment();
        Bundle b = new Bundle();
        b.putParcelable("text", content);

        f.setArguments(b);

        return f;
    }

    public static ResepMakananList getResepList(){
        return resepList;
    }
}
