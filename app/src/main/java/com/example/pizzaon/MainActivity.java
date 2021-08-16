package com.example.pizzaon;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.example.pizzaon.Adapters.MainAdapter;
import com.example.pizzaon.Models.MainModel;
import com.example.pizzaon.databinding.ActivityMainBinding;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    ActivityMainBinding mainBinding;
    ArrayList<MainModel> itemList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mainBinding.getRoot());


        itemList = new ArrayList<>();

        itemList.add(new MainModel(R.drawable.cheese_corn_pizza, "Cheese & Corn Pizza", "180",
                "Delicious Pizza stuffed with corn and cheese"));
        itemList.add(new MainModel(R.drawable.homemade_pizza, "Home-Made Pizza", "100",
                "Pizza with homemade quality and stuffed up quantity"));
        itemList.add(new MainModel(R.drawable.margherita_pizza, "Margherita Pizza", "100",
                "As original as the name, filled with traditional Italian toppings"));
        itemList.add(new MainModel(R.drawable.double_cheese_margherita_pizza, "Double Cheese Margherita Pizza", "150",
                "Stuffed with double cheese layer over the traditional Italian toppings"));
        itemList.add(new MainModel(R.drawable.greek_pizza, "Greek Pizza", "210",
                "Delicious and healthy pizza with traditional greek flavor"));
        itemList.add(new MainModel(R.drawable.neapolitan_pizza, "Neapolitan Pizza", "150",
                "Simple, traditional and delicious pizza"));
        itemList.add(new MainModel(R.drawable.paneer_makhani_pizza, "Paneer Makhani Pizza", "225",
                "Giving the sweet taste of paneer makhani, stuffed with paneer"));
        itemList.add(new MainModel(R.drawable.tandoori_paneer_pizza, "Tandoori Paneer Pizza", "250",
                "Spiced up Pizza with onion and red paprika"));
        itemList.add(new MainModel(R.drawable.zucchini_pizza, "Zucchini Pizza", "320",
                "Stuffed with vegetables, served in slices unlike traditional pizza"));


        MainAdapter mainAdapter = new MainAdapter(itemList, this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);

        mainBinding.recyclerViewMain.setAdapter(mainAdapter);
        mainBinding.recyclerViewMain.setLayoutManager(linearLayoutManager);

    }
}