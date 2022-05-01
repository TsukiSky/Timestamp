package com.siqi.timestamp.today;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.siqi.timestamp.Model;

public class EntryAdapter extends RecyclerView.Adapter<EntryAdapter.EntryViewHolder> {

    Context context;
    LayoutInflater inflater;
    Model.EntrySource entrySource;

    public EntryAdapter(Context context, Model.EntrySource entrySource){
        this.context = context;
        this.inflater = LayoutInflater.from(context);
        this.entrySource = entrySource;
    }



    @NonNull
    @Override
    public EntryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull EntryViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class EntryViewHolder extends RecyclerView.ViewHolder{

        public EntryViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
