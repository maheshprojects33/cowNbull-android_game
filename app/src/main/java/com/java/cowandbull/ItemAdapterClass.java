package com.java.cowandbull;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ItemAdapterClass extends RecyclerView.Adapter<ItemAdapterClass.ItemViewHolder> {

    private Context mContext;
    private ArrayList<ItemListClass> itemArray;

    public ItemAdapterClass(Context mContext, ArrayList<ItemListClass> itemArray) {
        this.mContext = mContext;
        this.itemArray = itemArray;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_layout, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        ItemListClass itemClass = itemArray.get(position);
        holder.guess.setText(itemClass.getGuessWord());
        holder.cow.setText(itemClass.getCow());
        holder.bull.setText(itemClass.getBull());
        holder.sno.setText(itemClass.getSno());



    }

    @Override
    public int getItemCount() {
        return itemArray.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {

        private TextView guess, cow, bull, sno;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);

            guess = itemView.findViewById(R.id.tvGuess);
            cow = itemView.findViewById(R.id.tvCow);
            bull = itemView.findViewById(R.id.tvBull);
            sno = itemView.findViewById(R.id.tvSno);
        }
    }
}
