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

        SQLiteDBHelper sqLiteDBHelper = new SQLiteDBHelper(this);
        orderList = sqLiteDBHelper.getSelectedOrdersList();

        UsersOrderAdapter usersOrderAdapter = new UsersOrderAdapter(orderList, this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);

        usersOrderBinding.recyclerViewUsersOrder.setAdapter(usersOrderAdapter);
        usersOrderBinding.recyclerViewUsersOrder.setLayoutManager(linearLayoutManager);

    }
}