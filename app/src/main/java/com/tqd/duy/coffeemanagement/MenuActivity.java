package com.tqd.duy.coffeemanagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.tqd.duy.adapter.FoodAdapter;
import com.tqd.duy.models.Food;

import java.util.ArrayList;

public class MenuActivity extends AppCompatActivity {
    private ListView lvMenu;
    private ArrayList<Food> listFood;
    private FoodAdapter adapterFood;
    private Button btnConfirm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        addControls();
        addEvents();
    }

    private void addEvents() {
        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moveResult();
            }
        });
    }

    private void moveResult() {
        Intent intent = getIntent();
        for (int i = 0;i<listFood.size();i++){
            if(listFood.get(i).getNumberFood() != 0)
            {
                intent.putExtra("food_"+i,listFood.get(i));
            }
        }
        setResult(2,intent);
        finish();
    }

    private void addControls() {
        lvMenu = findViewById(R.id.activity_menu_lv_menu);
        btnConfirm = findViewById(R.id.activity_menu_btn_confirm);
        Food food = new Food();
        listFood = food.getSampleFood(this);
        adapterFood = new FoodAdapter(this,R.layout.item_food,listFood);
        lvMenu.setAdapter(adapterFood);
    }

}
