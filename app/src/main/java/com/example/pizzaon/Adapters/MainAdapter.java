package com.example.pizzaon.Adapters;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class MainAdapter {

    public class viewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textName, textPrice, textDescription;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
