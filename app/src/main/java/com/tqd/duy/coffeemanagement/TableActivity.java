package com.tqd.duy.coffeemanagement;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridView;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;
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
        Toolbar toolbar = findViewById(R.id.activity_table_toolbar);
        setSupportActionBar(toolbar);
        addControls();
        addEvents();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_table, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.activity_table_mnLogout:
            confirmLogout();
        }
        return super.onOptionsItemSelected(item);
    }

    private void confirmLogout() {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
        builder.setMessage(R.string.Confirm_Logout);
        builder.setPositiveButton(R.string.OK, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent intent = new Intent(TableActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
        builder.setNegativeButton(R.string.Cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        android.app.AlertDialog alertDialog = builder.create();
        alertDialog.show();

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