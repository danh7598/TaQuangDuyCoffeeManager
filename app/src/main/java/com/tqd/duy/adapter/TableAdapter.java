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

import com.tqd.duy.coffeemanagement.MenuActivity;
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
    private static final int REQUEST_MENU_ACTIVITY = 0;
    public TableAdapter(@NonNull Activity context, int resource, @NonNull List<Table> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.objects = objects;
//xóa dòng trắng
    }
//xóa bớt dòng trắng

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
            btnCoffee.setImageResource(R.drawable.coffeegreen);
            txtStatus.setTextColor(context.getColor(R.color.colorGreen));//cái hàm get color chỉ chạy ở API 23, phải tránh dùng những hamgf này, hoặc phải bắt trường hợp
        }
        else if (txtStatus.getText().toString().equals(context.getString(R.string.CLEAN)))
        {
            btnCoffee.setImageResource(R.drawable.coffeeblue);
            txtStatus.setTextColor(context.getColor(R.color.colorBlue));
        }
        else if (txtStatus.getText().toString().equals(context.getString(R.string.BUSY)))
        {
            btnCoffee.setImageResource(R.drawable.coffeered);
            txtStatus.setTextColor(context.getColor(R.color.colorRed));
        }
        else if (txtStatus.getText().toString().equals(context.getString(R.string.BOOKED)))
        {
            btnCoffee.setImageResource(R.drawable.coffeebrown);
            txtStatus.setTextColor(context.getColor(R.color.colorBrown));
        }
        btnCoffee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(context, MenuActivity.class);
                intent.putExtra("table",table);
                context.startActivityForResult(intent,REQUEST_MENU_ACTIVITY);
            }
        });
        return  row;

    }


}

