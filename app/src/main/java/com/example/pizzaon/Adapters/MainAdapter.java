package com.example.pizzaon.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pizzaon.Models.MainModel;
import com.example.pizzaon.R;

import java.util.ArrayList;


public class MainAdapter extends RecyclerView.Adapter<MainAdapter.viewHolder> {

    ArrayList<MainModel> itemList;
    Context context;


    public MainAdapter(ArrayList<MainModel> itemList, Context context) {
        this.itemList = itemList;
        this.context = context;
    }


    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_each_layout, parent, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainAdapter.viewHolder holder, int position) {

        final  MainModel mainModel = itemList.get(position);
        holder.imageItem.setImageResource(mainModel.getEachItemImage());
        holder.textName.setText(mainModel.getEachItemName());
        holder.textPrice.setText(mainModel.getEachItemPrice());
        holder.textDescription.setText(mainModel.getEachItemDescription());

    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {

        ImageView imageItem;
        TextView textName, textPrice, textDescription;

        public viewHolder(@NonNull View itemView) {
            super(itemView);

            imageItem = itemView.findViewById(R.id.image_eachItem);
            textName = itemView.findViewById(R.id.text_name_eachItem);
            textPrice = itemView.findViewById(R.id.text_price_eachItem);
            textDescription = itemView.findViewById(R.id.text_description_eachItem);

        }
    }

}
