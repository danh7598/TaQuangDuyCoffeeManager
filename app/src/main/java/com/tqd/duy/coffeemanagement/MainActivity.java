package com.tqd.duy.coffeemanagement;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;
import com.tqd.duy.adapter.TableAdapter;
import com.tqd.duy.models.Example;
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
        Example example1 = new Example(MainActivity.this,dsTable);
        example1.SetTableExample();
        adapterTable = new TableAdapter(MainActivity.this,R.layout.item_table,dsTable);
        gvTable.setAdapter(adapterTable);
        //viết hàm tạo dữ liệu giả ở models rồi gọi ra nhé, không viết ở đây
    }

    private void addEvents() {

    }
}
