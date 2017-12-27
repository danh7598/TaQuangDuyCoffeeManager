package com.tqd.duy.coffeemanagement;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.tqd.duy.adapter.BillAdapter;
import com.tqd.duy.models.Food;
import com.tqd.duy.models.Table;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class InformationActivity extends AppCompatActivity {
    private TextView txtTableNumber;
    private TextView txtTableState;
    private TextView txtTime;
    private TextView txtListFood;
    private ListView lvBill;
    private BillAdapter adapterBill;
    private ArrayList<Food> listFood;
    private Button btnOrder;
    private LinearLayout llTitle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);
        addControls();
        addEvents();
    }

    private void addEvents() {
        btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moveOnMenuActivity();
            }
        });
    }

    private void moveOnMenuActivity() {
        Intent intent = new Intent(this,MenuActivity.class);
        startActivityForResult(intent,1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == 2) {
            for (int i = 0; i < 10; i++) {
                if (data.hasExtra("food_" + i)) {
                    listFood.add((Food) data.getSerializableExtra("food_" + i));
                }
            }
            Calendar calendar = Calendar.getInstance();
            Date time = calendar.getTime();
            SimpleDateFormat showDay = new SimpleDateFormat("dd/MM/yyyy");
            SimpleDateFormat showTime = new SimpleDateFormat("H:mm:ss a");
            txtTime.setText("Thời gian: " + showTime.format(time) + " " + showDay.format(time));
            txtListFood.setVisibility(View.VISIBLE);
            txtTime.setVisibility(View.VISIBLE);
            llTitle.setVisibility(View.VISIBLE);
            adapterBill = new BillAdapter(this, R.layout.item_bill, listFood);
            lvBill.setAdapter(adapterBill);
        }
    }

    private void addControls() {
        txtTableNumber = findViewById(R.id.activity_information_txt_number_table);
        txtTableState = findViewById(R.id.activity_information_txt_state_table);
        txtTime = findViewById(R.id.activity_information_txt_time_table);
        txtListFood = findViewById(R.id.activity_information_txt_list_food);
        btnOrder = findViewById(R.id.activity_information_btn_order);
        lvBill = findViewById(R.id.activity_information_lv_bill);
        llTitle = findViewById(R.id.activity_information_ll_title);
        txtListFood.setVisibility(View.INVISIBLE);
        llTitle.setVisibility(View.INVISIBLE);
        txtTime.setVisibility(View.INVISIBLE);
        listFood = new ArrayList<>();
        getTableInformation();
    }

    private void getTableInformation() {
        Table table = (Table) getIntent().getSerializableExtra("table");
        txtTableNumber.setText(table.getId());
        txtTableState.setText(table.getStatus());
    }
}
