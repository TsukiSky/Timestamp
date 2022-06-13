package com.siqi.timestamp.calendar.dailyInfo;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class DailyViewAdapter extends RecyclerView.Adapter<DailyViewAdapter.DailyViewHolder> {
    public DailyViewAdapter(){

    }

    @NonNull
    @Override
    public DailyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull DailyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    // DailyView
    public static class DailyViewHolder extends RecyclerView.ViewHolder{

        public DailyViewHolder(@NonNull View itemView) {
            super(itemView);

        }
    }

}
