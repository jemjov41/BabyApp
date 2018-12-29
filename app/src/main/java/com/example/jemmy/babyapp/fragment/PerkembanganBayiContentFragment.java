package com.example.jemmy.babyapp.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.jemmy.babyapp.R;
import com.example.jemmy.babyapp.entities.PerkembanganBayi;

public class PerkembanganBayiContentFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment2_perkembangan_bayi_content, container, false);

        return v;
    }

    public static PerkembanganBayiContentFragment newInstance(PerkembanganBayi content) {

        PerkembanganBayiContentFragment f = new PerkembanganBayiContentFragment();
        Bundle b = new Bundle();
        b.putString("text", content.getText());

        f.setArguments(b);

        return f;
    }
}
