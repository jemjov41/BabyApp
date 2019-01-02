package com.example.jemmy.babyapp.adapter;

import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.jemmy.babyapp.R;
import com.example.jemmy.babyapp.entities.ResepMakanan;

import java.util.ArrayList;

public class ResepMakananRecycleAdapter extends RecyclerView.Adapter<ResepMakananRecycleAdapter.ViewHolder> {

    private String TAG="ResepMakananRecycleAdapter";

    private FragmentActivity activity;

    private ArrayList<ResepMakanan> resepMakanans = new ArrayList<>();

    public ResepMakananRecycleAdapter(FragmentActivity activity) {
        this.activity = activity;
    }

    public void add(final ResepMakanan resep) {
        this.resepMakanans.add(resep);
        notifyItemInserted(this.resepMakanans.size());
        Log.e(TAG,String.format("news size %s",resepMakanans.size()));
    }

    public void clean(){
        this.resepMakanans.clear();
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        return new ResepMakananRecycleAdapter.ViewHolder(LayoutInflater.from(parent.getContext()).
                inflate(R.layout.fragment2_resep_makanan_list_content, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.tvKisaranUsia.setText(resepMakanans.get(position).getKisaranUsia());
        holder.tvTitleResep.setText(resepMakanans.get(position).getNamaResep());
        holder.checkBookmark.setChecked(resepMakanans.get(position).isBookmark());
    }

    @Override
    public int getItemCount() {
        return resepMakanans.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public final TextView tvKisaranUsia;
        public final TextView tvTitleResep;
        public final CheckBox checkBookmark;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvKisaranUsia = itemView.findViewById(R.id.resepKisaranUsia);
            tvTitleResep = itemView.findViewById(R.id.resepTitle);
            checkBookmark = itemView.findViewById(R.id.bookmarkResep);


        }
    }
}
