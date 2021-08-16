package com.example.pizzaon;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.example.pizzaon.Adapters.UsersOrderAdapter;
import com.example.pizzaon.Models.UsersOrderModel;
import com.example.pizzaon.databinding.ActivityMainBinding;
import com.example.pizzaon.databinding.ActivityUsersOrderBinding;

import java.util.ArrayList;


public class UsersOrderActivity extends AppCompatActivity {

    ActivityUsersOrderBinding usersOrderBinding;
    ArrayList<UsersOrderModel> orderList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        usersOrderBinding = ActivityUsersOrderBinding.inflate(getLayoutInflater());
        setContentView(usersOrderBinding.getRoot());


        orderList = new ArrayList<>();

        orderList.add(new UsersOrderModel(R.drawable.cheese_corn_pizza, "Cheese & Corn Pizza", "180",
                "2", "21133"));
        orderList.add(new UsersOrderModel(R.drawable.margherita_pizza, "Margherita Pizza", "100",
                "1", "21541"));
        orderList.add(new UsersOrderModel(R.drawable.paneer_makhani_pizza, "Paneer Makhani Pizza", "225",
                "5", "21774"));
        orderList.add(new UsersOrderModel(R.drawable.zucchini_pizza, "Zucchini Pizza", "320",
                "2", "21926"));


        UsersOrderAdapter usersOrderAdapter = new UsersOrderAdapter(orderList, this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);

        usersOrderBinding.recyclerViewUsersOrder.setAdapter(usersOrderAdapter);
        usersOrderBinding.recyclerViewUsersOrder.setLayoutManager(linearLayoutManager);

    }
}