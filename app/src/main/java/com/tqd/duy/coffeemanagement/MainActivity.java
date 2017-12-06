package com.tqd.duy.coffeemanagement;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;

import com.tqd.duy.adapter.TableAdapter;
import com.tqd.duy.adapter.TableAdapter2;
import com.tqd.duy.models.Table;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    GridView gvTable;
    ArrayList<Table> dsTable;
    TableAdapter2 adapterTable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addEvents();
    }

    private void addControls() {
        gvTable = findViewById(R.id.gvTable);
        dsTable = new ArrayList<>();
        dsTable.add(new Table("Bàn số 1","Trống"));
        dsTable.add(new Table("Bàn số 2","Đang dọn dẹp"));
        dsTable.add(new Table("Bàn số 3","Trống"));
        dsTable.add(new Table("Bàn số 4","Có khách"));
        dsTable.add(new Table("Bàn số 5","Có đặt trước"));
        dsTable.add(new Table("Bàn số 6","Trống"));
        adapterTable = new TableAdapter2(MainActivity.this,R.layout.itemtablegird,dsTable);
        gvTable.setAdapter(adapterTable);

    }

    private void addEvents() {

    }
}
