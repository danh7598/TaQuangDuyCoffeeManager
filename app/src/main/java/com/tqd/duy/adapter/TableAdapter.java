package com.tqd.duy.adapter;

import android.app.Activity;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.tqd.duy.coffeemanagement.R;
import com.tqd.duy.models.Table;

import java.util.List;

/**
 * Created by Danh on 12/6/2017.
 */

//Hai cái adapter này gần giống nhau, để hai cái làm gì vậy? có một cái anh có thấy dùng đâu
public class TableAdapter extends ArrayAdapter<Table> {
    private Activity context;
    private int resource;
    private List<Table> objects;

    public TableAdapter(@NonNull Activity context, int resource, @NonNull List<Table> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.objects = objects;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = this.context.getLayoutInflater();
        View row = inflater.inflate(this.resource,null);
        TextView txtId = row.findViewById(R.id.item_table_txt_id);
        TextView txtStatus = row.findViewById(R.id.item_table_txt_status);
        final Table table = this.objects.get(position);
        txtId.setText(table.getId());
        txtStatus.setText(table.getStatus());
        if (txtStatus.getText().toString() == "Trống")
        {
            txtStatus.setTextColor(Color.parseColor("#FF00C611"));
        }
        else if (txtStatus.getText().toString() == "Đang dọn dẹp")
        {
            txtStatus.setTextColor(Color.parseColor("#FF004EB5"));
        }
        else if (txtStatus.getText().toString() == "Có khách")
        {
            txtStatus.setTextColor(Color.parseColor("#FFD50000"));
        }
        else if (txtStatus.getText().toString() == "Đã đặt trước")
        {
            txtStatus.setTextColor(Color.parseColor("#FF750624"));
        }
        return  row;

    }
}

