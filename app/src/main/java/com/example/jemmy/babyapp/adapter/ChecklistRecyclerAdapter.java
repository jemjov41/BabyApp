package com.example.jemmy.babyapp.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.jemmy.babyapp.R;
import com.example.jemmy.babyapp.entities.ChecklistParentContent;

import java.util.ArrayList;

public class ChecklistRecyclerAdapter extends RecyclerView.Adapter<ChecklistRecyclerAdapter.ViewHolder> {

    private String TAG="ChecklistRecyclerAdapter";

    private Context mContext;

    private FragmentActivity activity;

    private ArrayList<ChecklistParentContent> checklists = new ArrayList<>();

    public ChecklistRecyclerAdapter(FragmentActivity activity) {
        this.activity = activity;
    }

    public void add(final ChecklistParentContent checklist) {
        this.checklists.add(checklist);
        notifyItemInserted(this.checklists.size());
        Log.e(TAG,String.format("checklist size %s",checklists.size()));
    }

    public void clean(){
        this.checklists.clear();
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        return new ChecklistRecyclerAdapter.ViewHolder(LayoutInflater.from(parent.getContext()).
                inflate(R.layout.fragment2_checklist_content, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        ChecklistChildAdapter checklistChildAdapter = new ChecklistChildAdapter(activity,checklists.get(position).getChecklistChildren());
        holder.listContent.setAdapter(checklistChildAdapter);

        int totalHeight = 0;
        for (int i = 0; i < checklistChildAdapter.getCount(); i++) {
            View listItem = checklistChildAdapter.getView(i, null, holder.listContent);
            listItem.measure(0, 0);
            totalHeight += listItem.getMeasuredHeight();
        }
        ViewGroup.LayoutParams params = holder.listContent.getLayoutParams();
        params.height = totalHeight + (holder.listContent.getDividerHeight() * (checklistChildAdapter.getCount() - 1));
        holder.listContent.setLayoutParams(params);
        holder.listContent.requestLayout();

        holder.tvTitle.setText(checklists.get(position).getParent());

        holder.checklishTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.expandMenu.setVisibility(holder.expandMenu.isShown()? View.GONE:View.VISIBLE);
                if(holder.expandMenu.isShown()){
                    holder.expandIndicator.setImageResource(R.drawable.ic_up_arrow);
                }else{
                    holder.expandIndicator.setImageResource(R.drawable.ic_down_arrow);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return checklists.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private LinearLayout checklishTitle;
        private TextView tvTitle;

        private ImageView expandIndicator;

        private LinearLayout expandMenu;
        private ListView listContent;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            checklishTitle = itemView.findViewById(R.id.checklishTitle);
            tvTitle = itemView.findViewById(R.id.titleChecklist);

            expandIndicator = itemView.findViewById(R.id.arrowExpandIndicator);

            expandMenu = itemView.findViewById(R.id.checklishExpandMenu);
            listContent = itemView.findViewById(R.id.listChecklistChild);
        }
    }
}
