package com.tqd.duy.coffeemanagement;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;
import com.tqd.duy.adapter.TableAdapter;
import com.tqd.duy.models.TableExample;
import com.tqd.duy.models.Table;
import java.util.ArrayList;
//cái import nào không dùng thì xóa đi
public class MainActivity extends AppCompatActivity {

    private GridView gvTable;
    private ArrayList<Table> dsTable;
    private TableAdapter adapterTable;
//chuyển về private
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addEvents();
    }

    private void addControls() {
        gvTable = findViewById(R.id.activity_main_gv_table);
        dsTable = new ArrayList<>();
        TableExample tableExample1 = new TableExample(MainActivity.this,dsTable);
        tableExample1.SetTableExample();
        adapterTable = new TableAdapter(MainActivity.this,R.layout.item_table,dsTable);
        gvTable.setAdapter(adapterTable);

    }

    private void addEvents() {

    }
}
