package com.tqd.duy.coffeemanagement;

import android.content.Intent;
import android.content.SharedPreferences;
import android.print.PageRange;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import com.tqd.duy.adapter.BillAdapter;
import com.tqd.duy.models.Food;
import java.util.ArrayList;

public class ConfirmActivity extends AppCompatActivity {
    private static final int RESULT_CODE_FOR_MENU_ACTIVITY = 4 ;
    private ListView lvConfirm;
    private BillAdapter adapterBill;
    private ArrayList<Food> listFood;
    private Button btnOK, btnContinue;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm);
        addControls();
        addEvents();
    }

    private void addEvents() {
        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                continueInActivityMenu();
            }
        });
        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                confirmInActivityInformation();
            }
        });

    }

    private void confirmInActivityInformation() {
        //Xác nhận món ăn để trả kết quả cho menu Activity
        for (int i = 0;i < listFood.size();i++){
            if(listFood.get(i).getNumberFood() != 0)
            {
                intent.putExtra("food_confirm_" + i,listFood.get(i));
            }
        }
        setResult(RESULT_CODE_FOR_MENU_ACTIVITY,intent);
        finish();
    }

    private void continueInActivityMenu() {
        onBackPressed();
        //Quay trở lại menu activity để tiếp tục lựa món mà không mất dữ liệu đã chọn
    }

    private void addControls() {
        lvConfirm = findViewById(R.id.activity_confirm_lv_confirm);
        btnOK = findViewById(R.id.activity_confirm_btn_ok);
        btnContinue = findViewById(R.id.activity_confirm_btn_continue);
        listFood = new ArrayList<>();
        intent = getIntent();
        for (int i = 0; i < 10; i++) {
            if (intent.hasExtra("food_" + i)) {
                listFood.add((Food) intent.getSerializableExtra("food_" + i));
            }
        }
        adapterBill = new BillAdapter(this,R.layout.item_bill,listFood);
        lvConfirm.setAdapter(adapterBill);
    }
}
