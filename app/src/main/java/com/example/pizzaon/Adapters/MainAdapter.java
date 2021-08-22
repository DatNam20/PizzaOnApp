package com.example.pizzaon.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pizzaon.ItemDetailActivity;
import com.example.pizzaon.Models.MainModel;
import com.example.pizzaon.R;

import java.util.ArrayList;


public class MainAdapter extends RecyclerView.Adapter<MainAdapter.itemViewHolder> {

    ArrayList<MainModel> itemList;
    Context mainContext;


    public MainAdapter(ArrayList<MainModel> itemList, Context context) {
        this.itemList = itemList;
        this.mainContext = context;
    }


    @NonNull
    @Override
    public itemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(mainContext).inflate(R.layout.item_each_layout, parent, false);
        return new itemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull itemViewHolder holder, int position) {

        final  MainModel mainModel = itemList.get(position);
        holder.imageItem.setImageResource(mainModel.getEachItemImage());
        holder.textItemName.setText(mainModel.getEachItemName());
        holder.textItemPrice.setText(mainModel.getEachItemPrice());
        holder.textItemDescription.setText(mainModel.getEachItemDescription());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mainContext, ItemDetailActivity.class);
                intent.putExtra("image", mainModel.getEachItemImage());
                intent.putExtra("name", mainModel.getEachItemName());
                intent.putExtra("description", mainModel.getEachItemDescription());
                intent.putExtra("price", mainModel.getEachItemPrice());
                intent.putExtra("callType", "order");
                mainContext.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }


    public class itemViewHolder extends RecyclerView.ViewHolder {

        ImageView imageItem;
        TextView textItemName, textItemPrice, textItemDescription;

        public itemViewHolder(@NonNull View itemView) {
            super(itemView);

            imageItem = itemView.findViewById(R.id.image_eachItem);
            textItemName = itemView.findViewById(R.id.text_name_eachItem);
            textItemPrice = itemView.findViewById(R.id.text_price_eachItem);
            textItemDescription = itemView.findViewById(R.id.text_description_eachItem);

        }
    }

}
