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
import com.example.modelapp.Models.PastEventModel;
import com.example.modelapp.R;

import java.util.List;

public class PastEventAdapter extends RecyclerView.Adapter<PastEventAdapter.ViewHolder> {

    Context context;
    List<PastEventModel> list;

    public PastEventAdapter(Context context, List<PastEventModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public PastEventAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.pastevents_rec_model,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull PastEventAdapter.ViewHolder holder, int position) {
        Glide.with(context).load(list.get(position).getImg_url()).into(holder.pastEventImg);
        holder.pastName.setText(list.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView pastEventImg;
        TextView pastName;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            pastEventImg = itemView.findViewById(R.id.past_event_img);
            pastName  = itemView.findViewById(R.id.past_event_name);
        }
    }
}
