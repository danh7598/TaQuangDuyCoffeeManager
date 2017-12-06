package com.tqd.duy.adapter;

import android.app.Activity;
import android.content.Context;
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

public class TableAdapter2 extends ArrayAdapter<Table> {
    Activity context;
    int resource;
    List<Table> objects;

    public TableAdapter2(@NonNull Activity context, int resource, @NonNull List<Table> objects) {
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
        TextView txtTenBan = row.findViewById(R.id.txtTenBan);
        TextView txtTrangThaiBan = row.findViewById(R.id.txtTrangThaiBan);
        final Table table = this.objects.get(position);
        txtTenBan.setText(table.getSoThuTu());
        txtTrangThaiBan.setText(table.getTrangThai());
        if (txtTrangThaiBan.getText().toString() == "Trống")
        {
            txtTrangThaiBan.setTextColor(Color.parseColor("#FF00C611"));
        }
        else if (txtTrangThaiBan.getText().toString() == "Đang dọn dẹp")
        {
            txtTrangThaiBan.setTextColor(Color.parseColor("#FF004EB5"));
        }
        else if (txtTrangThaiBan.getText().toString() == "Có khách")
        {
            txtTrangThaiBan.setTextColor(Color.parseColor("#FFD50000"));
        }
        else if (txtTrangThaiBan.getText().toString() == "Đã đặt trước")
        {
            txtTrangThaiBan.setTextColor(Color.parseColor("#FF750624"));
        }
        return  row;

    }
}

