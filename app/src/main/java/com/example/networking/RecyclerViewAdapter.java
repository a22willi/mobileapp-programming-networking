package com.example.networking;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private List<Mountain> mountains;
    private Context context;

    public RecyclerViewAdapter(Context context, List<Mountain> mountains) {
        this.context = context;
        this.mountains = mountains;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.mountain_item, parent, false);
        return new RecyclerViewAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.MyViewHolder holder, int position) {
        holder.mountainName.setText(mountains.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return mountains.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView mountainName;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            mountainName = itemView.findViewById(R.id.textView);
        }
    }
}
