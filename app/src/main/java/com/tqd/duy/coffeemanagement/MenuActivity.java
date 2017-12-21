package com.tqd.duy.coffeemanagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.tqd.duy.adapter.FoodAdapter;
import com.tqd.duy.models.Food;
import com.tqd.duy.models.Table;
import java.util.ArrayList;

public class MenuActivity extends AppCompatActivity {
    private TextView txtTableNumber;
    private TextView txtTableState;
    private ListView lvFood;
    private Button btnOrder;
    private ArrayList<Food> listFood;
    private FoodAdapter adapterFood;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        addControls();
        addEvents();
    }
    private void addEvents() {
    }
    private void addControls() {
        txtTableNumber = findViewById(R.id.activity_menu_txt_number_table);
        txtTableState = findViewById(R.id.activity_menu_txt_state_table);
        lvFood = findViewById(R.id.activity_menu_lv_food);
        btnOrder = findViewById(R.id.activity_menu_btn_order);
        listFood = new ArrayList<>();
        Food food = new Food();
        listFood = food.getSampleFood(this);
        adapterFood = new FoodAdapter(MenuActivity.this,R.layout.item_food,listFood);
        lvFood.setAdapter(adapterFood);
        getTableInformation();
    }
    private void getTableInformation() {
        Intent intent = getIntent();
        Table table = (Table) intent.getSerializableExtra("table");
        txtTableNumber.setText(table.getId());
        txtTableState.setText(table.getStatus());
    }
}
