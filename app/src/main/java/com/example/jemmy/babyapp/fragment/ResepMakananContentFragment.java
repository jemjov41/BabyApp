package com.example.jemmy.babyapp.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jemmy.babyapp.R;
import com.example.jemmy.babyapp.adapter.ResepMakananRecycleAdapter;
import com.example.jemmy.babyapp.entities.ResepMakanan;
import com.example.jemmy.babyapp.entities.ResepMakananList;

public class ResepMakananContentFragment extends Fragment {

    private String TAG = "ResepMakannContentFrag";

    private RecyclerView rvContent;

    public static ResepMakananContentFragment newInstance(ResepMakananTypeFragment.Kind kind) {
        final ResepMakananContentFragment f = new ResepMakananContentFragment();

        Bundle b = new Bundle();
        b.putSerializable(ResepMakananTypeFragment.PARAM_KIND, kind);
        f.setArguments(b);

        return f;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment2_resep_makan_list, container, false);

        rvContent = view.findViewById(R.id.resepMakananRecycler);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        rvContent.setLayoutManager(layoutManager);
        ResepMakananRecycleAdapter resepAdapter = new ResepMakananRecycleAdapter(getActivity());
        rvContent.setAdapter(resepAdapter);

        Log.d(TAG, String.format("get resep from content fragment %s", ResepMakananBodyFragment.getResepList()));

        ResepMakananTypeFragment.Kind kind = (ResepMakananTypeFragment.Kind) getArguments().getSerializable(ResepMakananTypeFragment.PARAM_KIND);

        ResepMakananList resepList = ResepMakananBodyFragment.getResepList();
        switch (kind) {
            case ALL:
                resepAdapter.clean();
                for (ResepMakanan resepMakanan : resepList.getResepMakanans()) {
                    resepAdapter.add(resepMakanan);
                }
                break;
            case BOOKMARK:
                resepAdapter.clean();
                for (ResepMakanan resepMakanan : resepList.getResepMakanans()) {
                    if (resepMakanan.isBookmark()) {
                        resepAdapter.add(resepMakanan);
                    }
                }
                break;
        }

    }
}
