package com.example.prototypofinance.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.prototypofinance.R;

public class RecycleView_Account_Category extends RecyclerView.Adapter<RecycleView_Account_Category.MyViewHolder> {

    private String[] itemList;

    public RecycleView_Account_Category(String[] itemList) {
        this.itemList = itemList;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView recycleView_account_textView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            recycleView_account_textView = itemView.findViewById(R.id.recycleView_account_textView);
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_account_recycleview, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.recycleView_account_textView.setText(itemList[position]);
        holder.recycleView_account_textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return itemList.length;
    }

}
