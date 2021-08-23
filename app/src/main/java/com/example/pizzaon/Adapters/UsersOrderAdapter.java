package com.example.pizzaon.Adapters;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pizzaon.ItemDetailActivity;
import com.example.pizzaon.Models.UsersOrderModel;
import com.example.pizzaon.R;
import com.example.pizzaon.SQLiteDBHelper;

import java.util.ArrayList;


public class UsersOrderAdapter extends RecyclerView.Adapter<UsersOrderAdapter.orderViewHolder>{

    ArrayList<UsersOrderModel> orderList;
    Context orderContext;
    SQLiteDBHelper sqLiteDBHelper;


    public UsersOrderAdapter(ArrayList<UsersOrderModel> orderList, Context orderContext) {
        this.orderList = orderList;
        this.orderContext = orderContext;
    }


    @NonNull
    @Override
    public orderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View orderView = LayoutInflater.from(orderContext).inflate(R.layout.order_each_layout, parent, false);
        return new UsersOrderAdapter.orderViewHolder(orderView);
    }


    @Override
    public void onBindViewHolder(@NonNull UsersOrderAdapter.orderViewHolder holder, int position) {

        final UsersOrderModel usersOrderModel = orderList.get(position);
        holder.imageOrder.setImageResource(usersOrderModel.getEachOrderImage());
        holder.textOrderName.setText(usersOrderModel.getEachOrderName());
        holder.textOrderPrice.setText(usersOrderModel.getEachOrderPrice());
        holder.textOrderQuantity.setText(usersOrderModel.getEachOrderQuantity());
        holder.textOrderID.setText(usersOrderModel.getEachOrderID());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(orderContext, ItemDetailActivity.class);
                intent.putExtra("id", usersOrderModel.getEachOrderID());
                intent.putExtra("callType", "update");
                orderContext.startActivity(intent);
            }
        });

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                new AlertDialog.Builder(orderContext)
                        .setTitle("Delete Order")
                        .setMessage("\nAre you sure ?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                sqLiteDBHelper = new SQLiteDBHelper(orderContext);
                                if (sqLiteDBHelper.deleteOrder(usersOrderModel.getEachOrderID()) > 0)
                                    Toast.makeText(orderContext, "Successfully Deleted", Toast.LENGTH_SHORT).show();
                                else
                                    Toast.makeText(orderContext, "Failed !", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        })
                        .setIcon(R.drawable.icon_delete)
                        .show();

                return false;
            }
        });
    }


    @Override
    public int getItemCount() {
        return orderList.size();
    }


    public class orderViewHolder extends RecyclerView.ViewHolder {

        ImageView imageOrder;
        TextView textOrderName, textOrderPrice, textOrderQuantity, textOrderID;

        public orderViewHolder(@NonNull View orderView) {
            super(orderView);

            imageOrder = itemView.findViewById(R.id.image_eachOrder);
            textOrderName = itemView.findViewById(R.id.text_name_eachOrder);
            textOrderPrice = itemView.findViewById(R.id.text_price_eachOrder);
            textOrderQuantity = itemView.findViewById(R.id.text_quantity_eachOrder);
            textOrderID = itemView.findViewById(R.id.text_orderID_eachOrder);

        }
    }

}

/*
        sqLiteDBHelper = new SQLiteDBHelper(orderContext);
        if (sqLiteDBHelper.deleteOrder(usersOrderModel.getEachOrderID()) > 0)
                Toast.makeText(orderContext, "Successfully Deleted", Toast.LENGTH_SHORT).show();
        else
                Toast.makeText(orderContext, "Failed !", Toast.LENGTH_SHORT).show();

 */