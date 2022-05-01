package com.siqi.timestamp.today;

import android.content.Context;
import android.graphics.Paint;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.siqi.timestamp.Model;
import com.siqi.timestamp.R;

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
        View entryView = inflater.inflate(R.layout.layout_today_entry, parent, false);
        return new EntryViewHolder(entryView);
    }

    @Override
    public void onBindViewHolder(@NonNull EntryViewHolder holder, int position) {
        holder.textView.setText(this.entrySource.get(position).content);
    }

    @Override
    public int getItemCount() {
        return this.entrySource.count();
    }

    public static class EntryViewHolder extends RecyclerView.ViewHolder{
        TextView textView;
        public EntryViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.id_tv_entry);
            initTextView(textView);
        }
    }

    public static void initTextView(TextView textView){
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("CLICK", "Onclick entry");
                if (textView.getPaint().getFlags() != Paint.STRIKE_THRU_TEXT_FLAG){
                    textView.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
                    textView.setText(textView.getText());
                    Log.i("CLICK", "Set strike");
                }
                else{
                    textView.getPaint().setFlags(0);
                    textView.setText(textView.getText());
                    Log.i("CLICK", "Undo strike");
                }
            }
        });
    }
}
