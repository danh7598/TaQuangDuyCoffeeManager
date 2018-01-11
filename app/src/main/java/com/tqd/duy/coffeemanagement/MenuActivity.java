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
    private static final int REQUEST_CODE_FOR_CONFIRM_ACTIVITY = 10;
    private static final int RESULT_CODE_FOR_INFORMATION_ACTIVITY = 15;
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
        Intent intent = new Intent(this,ConfirmActivity.class);
        //Truyền kết quả khi lựa món cho confirm Activity
        //Khi xác nhận xong sẽ chuyển về lại Information Activity
        for (int i = 0;i < listFood.size();i++){
            if(listFood.get(i).getNumberFood() != 0)
            {
                intent.putExtra("food_" + i,listFood.get(i));
            }
        }
        startActivityForResult(intent,REQUEST_CODE_FOR_CONFIRM_ACTIVITY);
    }

    private void addControls() {
        lvMenu = findViewById(R.id.activity_menu_lv_menu);
        btnConfirm = findViewById(R.id.activity_menu_btn_confirm);
        Food food = new Food();
        listFood = food.getSampleFood(this);
        adapterFood = new FoodAdapter(this,R.layout.item_food,listFood);
        lvMenu.setAdapter(adapterFood);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //lấy kết quả từ Confirm activity
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_FOR_CONFIRM_ACTIVITY && resultCode == 4) {
            ArrayList<Food> listConfirmFood = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                if (data.hasExtra("food_confirm_" + i)) {
                    listConfirmFood.add((Food) data.getSerializableExtra("food_confirm_" + i));
                }
        //Lấy kết quả từ confirm Activity, loại bỏ kết quả có số lượng bằng 0
            }
            Intent intent = getIntent();
            for (int i = 0; i < listConfirmFood.size(); i++) {
                intent.putExtra("food_confirmed_" + i,listConfirmFood.get(i));
            }
        //trả kết quả cho information activity
            setResult(RESULT_CODE_FOR_INFORMATION_ACTIVITY,intent);
            finish();
        }
    }
}
