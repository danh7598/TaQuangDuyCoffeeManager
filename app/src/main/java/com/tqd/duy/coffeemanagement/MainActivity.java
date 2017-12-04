package com.tqd.duy.coffeemanagement;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.tqd.duy.adapter.TableAdapter;
import com.tqd.duy.models.Table;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lvTable;
    ArrayList<Table> dsTable;
    ArrayAdapter<Table> adapterTable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addEvents();
    }

    private void addControls() {
        lvTable = findViewById(R.id.lvTable);
        dsTable = new ArrayList<>();
        dsTable.add(new Table("Bàn số 1","Trống"));
        dsTable.add(new Table("Bàn số 2","Đang dọn dẹp"));
        dsTable.add(new Table("Bàn số 3","Trống"));
        dsTable.add(new Table("Bàn số 4","Có khách"));
        dsTable.add(new Table("Bàn số 5","Trống"));
        adapterTable = new TableAdapter(MainActivity.this,R.layout.itemtable,dsTable);
        lvTable.setAdapter(adapterTable);

    }

    private void addEvents() {

    }
}
