package com.tqd.duy.coffeemanagement;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.Toast;

import com.tqd.duy.adapter.TableAdapter;
import com.tqd.duy.models.Table;
import java.util.ArrayList;

public class TableActivity extends AppCompatActivity {
    private GridView gvTable;
    private ArrayList<Table> listTable;
    private TableAdapter adapterTable;
    private FloatingActionButton floatBtnSetting;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table);
        addControls();
        addEvents();
    }
    private void addControls() {
        gvTable = findViewById(R.id.activity_table_gv_table);
        floatBtnSetting = findViewById(R.id.activity_table_float_btn_setting);
        listTable = new ArrayList<>();
        Table table = new Table();
        listTable = table.getSampleTable(this);
        adapterTable = new TableAdapter(TableActivity.this, R.layout.item_table,listTable);
        gvTable.setAdapter(adapterTable);
    }
    private void addEvents() {
        floatBtnSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                processSettingActivity();
            }
        });
    }
    private void processSettingActivity() {
        Toast.makeText(this, getResources().getString(R.string.Setting), Toast.LENGTH_SHORT).show();
    }
}