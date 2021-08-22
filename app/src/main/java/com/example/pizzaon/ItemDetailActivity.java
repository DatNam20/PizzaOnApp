package com.example.pizzaon;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
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

        dbHelper = new SQLiteDBHelper(this);

        if ( "order".equals(getIntent().getStringExtra("callType")) ) {

            selectedItemImage = getIntent().getIntExtra("image", 0);
            selectedItemName = getIntent().getStringExtra("name");
            selectedItemDescription = getIntent().getStringExtra("description");
            selectedItemPrice = Integer.parseInt(getIntent().getStringExtra("price"));

            itemDetailBinding.imageSelectedItemDetail.setImageResource(selectedItemImage);
            itemDetailBinding.textNameSelectedItemDetail.setText(selectedItemName);
            itemDetailBinding.textDescriptionSelectedItemDetail.setText(selectedItemDescription);
            itemDetailBinding.textPriceSelectedItemDetail.setText(String.format("%d", selectedItemPrice));

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
                        Toast.makeText(ItemDetailActivity.this, "Order Added", Toast.LENGTH_SHORT).show();
                    else
                        Toast.makeText(ItemDetailActivity.this, "Failed !", Toast.LENGTH_SHORT).show();
                }
            });
        }

        else {
            String orderID = getIntent().getStringExtra("id");
            Cursor queryCursor = dbHelper.getOrderByID(orderID);

            itemDetailBinding.textUserNameSelectedItemDetail.setText(queryCursor.getString(1));
            itemDetailBinding.textUserMobileNumberSelectedItemDetail.setText(queryCursor.getString(2));
            itemDetailBinding.textNameSelectedItemDetail.setText(queryCursor.getString(3));
            itemDetailBinding.textPriceSelectedItemDetail.setText(String.format("%d", queryCursor.getInt(4)));
            itemDetailBinding.textQuantitySelectedItemDetail.setText(queryCursor.getInt(5)+"");
            itemDetailBinding.textDescriptionSelectedItemDetail.setText(queryCursor.getString(6));
            itemDetailBinding.imageSelectedItemDetail.setImageResource(queryCursor.getInt(7));

            itemDetailBinding.buttonOrderSelectedItem.setText(R.string.string_updateSelected);
            itemDetailBinding.buttonOrderSelectedItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    boolean updateSuccess = dbHelper.updateOrder(
                            itemDetailBinding.textUserNameSelectedItemDetail.getText().toString(),
                            itemDetailBinding.textUserMobileNumberSelectedItemDetail.getText().toString(),
                            itemDetailBinding.textNameSelectedItemDetail.getText().toString(),
                            Integer.parseInt(itemDetailBinding.textPriceSelectedItemDetail.getText().toString()),
                            Integer.parseInt(itemDetailBinding.textQuantitySelectedItemDetail.getText().toString()),
                            itemDetailBinding.textDescriptionSelectedItemDetail.getText().toString(),
                            queryCursor.getInt(7),
                            orderID
                    );
                    if (updateSuccess)
                        Toast.makeText(ItemDetailActivity.this, "Order Updated", Toast.LENGTH_SHORT).show();
                    else
                        Toast.makeText(ItemDetailActivity.this, "Failed !", Toast.LENGTH_SHORT).show();
                }
            });
        }

    }
}