package com.siqi.timestamp.calendar.dailyEventCard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class DailyViewAdapter extends RecyclerView.Adapter<DailyViewAdapter.DailyViewHolder> {
    Context context;
    LayoutInflater inflater;
    DailyModel.DataSource dataSource;
    public DailyViewAdapter(Context context, DailyModel.DataSource dataSource){
        this.context = context;
        this.dataSource = dataSource;
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
