package com.example.pizzaon;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.pizzaon.databinding.ActivityItemDetailBinding;


public class ItemDetailActivity extends AppCompatActivity {

    ActivityItemDetailBinding itemDetailBinding;

    String selectedItemName, selectedItemDescription;
    int selectedItemImage, selectedItemPrice;

    SQLiteDBHelper dbHelper;


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

        dbHelper = new SQLiteDBHelper(this);

        itemDetailBinding.buttonOrderSelectedItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean insertSuccess = dbHelper.insertOrder(
                        itemDetailBinding.textUserNameSelectedItemDetail.getText().toString(),
                        itemDetailBinding.textUserMobileNumberSelectedItemDetail.getText().toString(),
                        selectedItemName,
                        selectedItemPrice,
                        Integer.parseInt(itemDetailBinding.textQuantitySelectedItemDetail.getText().toString()),
                        selectedItemDescription,
                        selectedItemImage
                );
                if (insertSuccess)
                    Toast.makeText(ItemDetailActivity.this, "Value Inserted", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(ItemDetailActivity.this, "Failed !", Toast.LENGTH_SHORT).show();
            }
        });

    }
}