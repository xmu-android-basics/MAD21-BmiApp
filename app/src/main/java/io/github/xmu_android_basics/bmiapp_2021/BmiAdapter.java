package io.github.xmu_android_basics.bmiapp_2021;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class BmiAdapter extends RecyclerView.Adapter<BmiViewHolder> {
    private List<BmiRecord> data = new ArrayList<>();

    @NonNull
    @Override
    public BmiViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new BmiViewHolder(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull BmiViewHolder holder, int position) {
        holder.bind(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void setBmi(List<BmiRecord> bmiRecords) {
        data = bmiRecords;
        notifyDataSetChanged();
    }
}
