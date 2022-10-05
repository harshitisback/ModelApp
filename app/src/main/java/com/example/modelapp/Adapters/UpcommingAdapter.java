package com.example.modelapp.Adapters;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.modelapp.Models.UpcommingModel;
import com.example.modelapp.R;

import java.util.List;

public class UpcommingAdapter extends RecyclerView.Adapter<UpcommingAdapter.ViewHolder> {

    private Context context;
    private List<UpcommingModel> upcommingModelList;

    public UpcommingAdapter(Context context, List<UpcommingModel> upcommingModelList) {
        this.context = context;
        this.upcommingModelList = upcommingModelList;
    }

    @NonNull
    @Override
    public UpcommingAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.upcomming_rec_model,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull UpcommingAdapter.ViewHolder holder, int position) {
        Glide.with(context).load(upcommingModelList.get(position).getUrlImg()).into(holder.eventImg);
        holder.name.setText(upcommingModelList.get(position).getName());
        holder.date.setText(upcommingModelList.get(position).getDate());
        holder.mode.setText(upcommingModelList.get(position).getMode());



    }

    @Override
    public int getItemCount() {
        return upcommingModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView eventImg;
        TextView name, mode, date;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            eventImg = itemView.findViewById(R.id.upcoming_events_photo);
            name = itemView.findViewById(R.id.upcoming_events_name);
            mode = itemView.findViewById(R.id.mode);
            date = itemView.findViewById(R.id.date);
        }

    }
}
