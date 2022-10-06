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
import com.example.modelapp.Models.OngoingModel;
import com.example.modelapp.R;

import java.util.List;

public class OngoingAdapter extends RecyclerView.Adapter<OngoingAdapter.ViewHolder> {
    Context context;
    List<OngoingModel> list;

    public OngoingAdapter(Context context, List<OngoingModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public OngoingAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.ongoing_rec_model,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull OngoingAdapter.ViewHolder holder, int position) {
        Glide.with(context).load(list.get(position).getImg_url()).into(holder.imageView);
        holder.name.setText(list.get(position).getName());
        holder.date.setText(list.get(position).getDate());
        holder.mode.setText(list.get(position).getMode());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView name, date, mode;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.ongoing_events_photo);
            name = itemView.findViewById(R.id.ongoing_events_name);
            mode = itemView.findViewById(R.id.ongoing_mode);
            date = itemView.findViewById(R.id.ongoing_date);

        }
    }
}
