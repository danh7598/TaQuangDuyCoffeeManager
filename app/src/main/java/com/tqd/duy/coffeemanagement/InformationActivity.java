package com.tqd.duy.coffeemanagement;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
//không dùng thì xóa
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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
    private static final int REQUEST_CODE_FOR_MENU_ACTIVITY = 5;
    private TextView txtTableNumber;
    private TextView txtTableState;
    private TextView txtTime;
    private TextView txtListFood;
    private ListView lvBill;
    private BillAdapter adapterBill;
    private ArrayList<Food> listFood;
    private Button btnOrder;
    private Button btnPay;
    private LinearLayout llTitle;
    private Button btnClean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);
        Toolbar toolbar = findViewById(R.id.activity_information_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
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
        btnClean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeCleanTableState();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

    private void changeCleanTableState() {

    }

    private void moveOnMenuActivity() {
        Intent intent = new Intent(this, MenuActivity.class);
        startActivityForResult(intent, REQUEST_CODE_FOR_MENU_ACTIVITY);
        //Dùng intent trả kết quả cho Menu Activity
        //Lấy kết quả trả về gán cho list view
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //lấy kết quả đã xác nhận từ menu activity
        if (requestCode == REQUEST_CODE_FOR_MENU_ACTIVITY && resultCode == 15) {
            for (int i = 0; i < 10; i++) {
                if (data.hasExtra("food_confirmed_" + i)) {
                    Food intentFood = (Food) data.getSerializableExtra("food_confirmed_" + i);
                    if (listFood.size() != 0) {
                        boolean loop = true;// biến để xác nhận có trùng hay không
                        //nếu true: k bị trùng, thêm vào listFood
                        for (int j = 0; loop == true && listFood.size() > j; j++) {
                            //đk lặp là kiểm tra có trùng hay k và số lần lặp nhỏ hơn size listFood
                            //nếu không bị trùng (true) thì kiểm tra tiếp cho đến khi hết list
    //So sánh nếu lần order tiếp theo có món đã trùng với lần order ban đầu
    //tăng số lượng món nếu trùng
                            if (listFood.get(j).getNameFood().equals((intentFood.getNameFood()))) {
                                listFood.get(j).setNumberFood(listFood.get(j).getNumberFood() +
                                        ((Food) data.getSerializableExtra("food_confirmed_" + i)).getNumberFood());
                                loop = false;
                                //chuyển thành false: bị trùng, không thêm vào listFood nữa
                            }
                        }
                        if (loop == true) {
                            //trùng thì thêm vô listFood
                            listFood.add(intentFood);
                        }
                    }
                    else {
                        //nếu list chưa có chi (size = 0) thì thêm vào mà k xét trùng
                        listFood.add(intentFood);
                    }
                }
            }
        }
        Calendar calendar = Calendar.getInstance(); //lấy thời gian hiện tại
        Date time = calendar.getTime();
        SimpleDateFormat showDay = new SimpleDateFormat("dd/MM/yyyy");//format dạng thời gian
        SimpleDateFormat showTime = new SimpleDateFormat("H:mm:ss a");//-------------------
        txtTime.setText("Thời gian: " + showTime.format(time) + " " + showDay.format(time));
        txtListFood.setVisibility(View.VISIBLE);
        txtTime.setVisibility(View.VISIBLE);
        llTitle.setVisibility(View.VISIBLE);
        adapterBill = new BillAdapter(this, R.layout.item_bill, listFood);
        lvBill.setAdapter(adapterBill);
    }

    private void addControls() {
        txtTableNumber = findViewById(R.id.activity_information_txt_number_table);
        txtTableState = findViewById(R.id.activity_information_txt_state_table);
        txtTime = findViewById(R.id.activity_information_txt_time_table);
        txtListFood = findViewById(R.id.activity_information_txt_list_food);
        btnOrder = findViewById(R.id.activity_information_btn_order);
        btnClean = findViewById(R.id.activity_information_btn_clean);
        lvBill = findViewById(R.id.activity_information_lv_bill);
        llTitle = findViewById(R.id.activity_information_ll_title);
        btnPay = findViewById(R.id.activity_information_btn_pay);
        txtListFood.setVisibility(View.INVISIBLE);
        llTitle.setVisibility(View.INVISIBLE);
        listFood = new ArrayList<>();
        getTableInformation();

    }

    private void getTableInformation() {
        Table table = (Table) getIntent().getSerializableExtra("table");
        txtTableNumber.setText(table.getId());
        txtTableState.setText(table.getStatus());
        setTitle(getString(R.string.Detail) + ": " + table.getId() );
        if (txtTableState.getText().toString().equals(getResources().
                getString(R.string.AVAILABLE))) {
            btnPay.setEnabled(false);
        }
        else if (txtTableState.getText().toString().equals(getResources().getString(R.string.CLEAN))) {
            btnOrder.setVisibility(View.INVISIBLE);
            btnPay.setVisibility(View.INVISIBLE);
            btnClean.setVisibility(View.VISIBLE);
        }
        if (txtTableState.getText().toString().equals(getString(R.string.AVAILABLE)))
        {
            txtTableState.setTextColor(getResources().getColor(R.color.colorGreen));
        }
        else if (txtTableState.getText().toString().equals(getString(R.string.CLEAN)))
        {
            txtTableState.setTextColor(getResources().getColor(R.color.colorBrown));
        }
        else if (txtTableState.getText().toString().equals(getString(R.string.BUSY)))
        {
            txtTableState.setTextColor(getResources().getColor(R.color.colorRed));
        }
        else if (txtTableState.getText().toString().equals(getString(R.string.BOOKED)))
        {
            txtTableState.setTextColor(getResources().getColor(R.color.colorPurple));
        }
    }
}
