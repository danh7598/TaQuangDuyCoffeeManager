package com.tqd.duy.coffeemanagement;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.tqd.duy.adapter.BillAdapter;
import com.tqd.duy.models.Food;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class PaymentActivity extends AppCompatActivity {

    private TextView txtTotal, txtRest;
    private EditText txtDiscount, txtPaid;
    private ListView lvFood;
    private BillAdapter adapterBill;
    private ArrayList<Food> listFood;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        Toolbar toolbar = findViewById(R.id.activity_payment_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Thanh toán");
        addControls();
        addEvents();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_payment, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.activity_payment_btn_reload:
                setTextView();
                break;
            case R.id.activity_payment_btn_tick:
                confirmPayment();
        }
        return super.onOptionsItemSelected(item);
    }

    private void confirmPayment() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(getString(R.string.Finish_Payment) + "?");
        builder.setPositiveButton(R.string.OK, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(PaymentActivity.this, "Hoàn tất", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton(R.string.Cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    private void addEvents() {

    }

    private void addControls() {
        txtTotal = findViewById(R.id.activity_payment_txt_total);
        txtRest = findViewById(R.id.activity_payment_txt_rest);
        txtDiscount = findViewById(R.id.activity_payment_txt_discount);
        txtPaid = findViewById(R.id.activity_payment_txt_paid);
        lvFood = findViewById(R.id.activity_payment_lv_food);
        listFood = new ArrayList<>();
        adapterBill = new BillAdapter(this,R.layout.item_bill,listFood);
        lvFood.setAdapter(adapterBill);
        getBillAdapter();
        setTextView();
    }

    private void setTextView() {
        DecimalFormat price = new DecimalFormat("##,###");
        double total = 0;
        for (Food food : listFood) {
            total += food.getNumberFood()*food.getPriceFood();
        }
        double discount;
        if (txtDiscount.getText().length() == 0) {
            discount = 0;
        }
        else {
            discount = Double.parseDouble(txtDiscount.getText().toString());
        }
        total = total - total*(discount/100);
        txtTotal.setText(getString(R.string.Total_money) + " " + price.format(total) + " VNĐ");
        int rest;
        if (txtPaid.getText().length() == 0) {
            rest = 0;
        }
        else {
            rest = Integer.parseInt(txtPaid.getText().toString());
        }
        if (rest - total <= 0) {
            txtRest.setText(getString(R.string.Rest) + " 0"  + " VNĐ");
        }
        else {
            txtRest.setText(getString(R.string.Rest) + " " + price.format(rest - total) + " VNĐ");
        }
    }

    private void getBillAdapter() {
        Intent intent = getIntent();
        for (int i = 0; i < 10; i++) {
            if (intent.hasExtra("payment_food_" + i)) {
                listFood.add((Food) intent.getSerializableExtra("payment_food_" + i));
            }
        }
        adapterBill.notifyDataSetChanged();
    }
}
