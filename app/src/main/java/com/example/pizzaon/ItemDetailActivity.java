package com.example.pizzaon;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.pizzaon.databinding.ActivityItemDetailBinding;


public class ItemDetailActivity extends AppCompatActivity {

    ActivityItemDetailBinding itemDetailBinding;
    String selectedItemName, selectedItemDescription;
    int selectedItemImage, selectedItemPrice;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        itemDetailBinding = ActivityItemDetailBinding.inflate(getLayoutInflater());
        setContentView(itemDetailBinding.getRoot());

        selectedItemImage = getIntent().getIntExtra("image", 0);
        selectedItemName = getIntent().getStringExtra("name");
        selectedItemDescription = getIntent().getStringExtra("description");
        selectedItemPrice = Integer.parseInt(getIntent().getStringExtra("price"));

        itemDetailBinding.imageSelectedItemDetail.setImageResource(selectedItemImage);
        itemDetailBinding.textNameSelectedItemDetail.setText(selectedItemName);
        itemDetailBinding.textDescriptionSelectedItemDetail.setText(selectedItemDescription);
        itemDetailBinding.textPriceSelectedItemDetail.setText(String.format("%d", selectedItemPrice));

    }
}