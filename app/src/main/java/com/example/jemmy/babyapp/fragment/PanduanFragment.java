package com.example.jemmy.babyapp.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.jemmy.babyapp.R;
import com.example.jemmy.babyapp.database.PanduanDBHelper;
import com.example.jemmy.babyapp.entities.PanduanTest;
import com.example.jemmy.babyapp.util.Utils;

import java.util.List;

public class PanduanFragment extends Fragment {

    private String TAG="PanduanFragment";

    PanduanDBHelper myDB;

//    private TextView textPanduan;
//    private CheckBox textCheck;
    private int displayWidth;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_panduan, container, false);

//        textPanduan = view.findViewById(R.id.textPanduan);
//        textCheck = view.findViewById(R.id.panduanCheck);

//        LinearLayout layout = view.findViewById(R.id.layoutPerkembangan);
//
//        ViewGroup.LayoutParams params = layout.getLayoutParams();
//
//        displayWidth = Utils.getDisplayWidth(getActivity());
//        int widthBackground = displayWidth/2
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

//        myDB = new PanduanDBHelper(getActivity());
//
//        List<PanduanTest> listPanduan = myDB.getAllNotes();
//        for(final PanduanTest list : listPanduan) {
//            textPanduan.setText(list.getText());
//            textCheck.setChecked(list.isDone());
//            Log.d(TAG, String.format("list Panduan %s", list));
//            textCheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//                @Override
//                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                    if(textCheck.isChecked()) {
//                        Log.d(TAG,String.format("updating..."));
//                        myDB.updateNote(list);
//                    }
//                }
//            });
//        }

    }
}
