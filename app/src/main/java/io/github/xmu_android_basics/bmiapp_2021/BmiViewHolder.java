package io.github.xmu_android_basics.bmiapp_2021;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class BmiViewHolder extends RecyclerView.ViewHolder {
    private final TextView bmiDate;
    private final TextView bmiWeight;
    private final TextView bmiBmi;

    public BmiViewHolder(@NonNull View itemView) {
        super(itemView);
        bmiDate = itemView.findViewById(R.id.bmi_date);
        bmiWeight = itemView.findViewById(R.id.bmi_weight);
        bmiBmi = itemView.findViewById(R.id.bmi_bmi);
    }

    public BmiViewHolder(@NonNull ViewGroup parent) {
        this(
                LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.recyclerview_item_bmi_record, parent, false)
        );
    }

    public void bind(BmiRecord bmiRecord) {
        bmiDate.setText(bmiRecord.timestamp);
        bmiWeight.setText(String.valueOf(bmiRecord.weight));
        bmiBmi.setText(String.valueOf(bmiRecord.bmi));
    }

    public static BmiViewHolder create(@NonNull ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_item_bmi_record, parent, false);
        return new BmiViewHolder(view);
    }
}
