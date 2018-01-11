package com.tqd.duy.adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import com.tqd.duy.coffeemanagement.InformationActivity;
import com.tqd.duy.coffeemanagement.R;
import com.tqd.duy.models.Table;
import java.util.List;

/**
 * Created by Danh on 12/6/2017.
 */

public class TableAdapter extends ArrayAdapter<Table> {
    private Activity context;
    private int resource;
    private List<Table> objects;
    private Intent intent;
    public TableAdapter(@NonNull Activity context, int resource, @NonNull List<Table> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.objects = objects;
    }
    @SuppressLint("NewApi")
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        final LayoutInflater inflater = this.context.getLayoutInflater();
        View row = inflater.inflate(this.resource,null);
        TextView txtId = row.findViewById(R.id.item_table_txt_id);
        TextView txtStatus = row.findViewById(R.id.item_table_txt_status);
        ImageButton btnCoffee = row.findViewById(R.id.item_table_btn_coffee);
        final Table table = this.objects.get(position);
        txtId.setText(table.getId());
        txtStatus.setText(table.getStatus());
        if (txtStatus.getText().toString().equals(context.getString(R.string.AVAILABLE)))
        {
            btnCoffee.setImageResource(R.drawable.coffee_cup_green);
            txtStatus.setTextColor(context.getResources().getColor(R.color.colorGreen));
        }
        else if (txtStatus.getText().toString().equals(context.getString(R.string.CLEAN)))
        {
            btnCoffee.setImageResource(R.drawable.coffee_cup_brown);
            txtStatus.setTextColor(context.getResources().getColor(R.color.colorBrown));
        }
        else if (txtStatus.getText().toString().equals(context.getString(R.string.BUSY)))
        {
            btnCoffee.setImageResource(R.drawable.coffee_cup_red);
            txtStatus.setTextColor(context.getResources().getColor(R.color.colorRed));
        }
        else if (txtStatus.getText().toString().equals(context.getString(R.string.BOOKED)))
        {
            btnCoffee.setImageResource(R.drawable.coffee_cup_purple);
            txtStatus.setTextColor(context.getResources().getColor(R.color.colorPurple));
        }
        btnCoffee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(context, InformationActivity.class);
                intent.putExtra("table",table);
                context.startActivity(intent);
            }
        });
        row.setBackground(context.getResources().getDrawable(R.drawable.border_table));
        return  row;
    }

}

