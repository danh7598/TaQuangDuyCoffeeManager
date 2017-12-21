package com.tqd.duy.coffeemanagement;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;
import com.tqd.duy.adapter.TableAdapter;
import com.tqd.duy.models.Table;
import java.util.ArrayList;

public class TableActivity extends AppCompatActivity {
    private GridView gvTable;
    private ArrayList<Table> listTable;
    private TableAdapter adapterTable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table);
        addControls();
        addEvents();
    }
    private void addControls() {
        gvTable = findViewById(R.id.activity_main_gv_table);
        listTable = new ArrayList<>();
        Table table = new Table();
        listTable = table.getSampleTable(this);
        adapterTable = new TableAdapter(TableActivity.this, R.layout.item_table,listTable);
        gvTable.setAdapter(adapterTable);
    }
    private void addEvents() {
    }
}