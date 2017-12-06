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
 * Created by Danh on 12/4/2017.
 */

public class TableAdapter extends ArrayAdapter<Table> {
    Activity context;
    int resource;
    List<Table> objects;

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
        TextView txtSoBan = row.findViewById(R.id.txtSoBan);
        TextView txtTrangThai = row.findViewById(R.id.txtTrangThai);
        final Table table = this.objects.get(position);
        txtSoBan.setText(table.getSoThuTu());
        txtTrangThai.setText(table.getTrangThai());
        if (txtTrangThai.getText().toString() == "Trống")
        {
            txtTrangThai.setTextColor(Color.parseColor("#FF00C611"));
        }
        else if (txtTrangThai.getText().toString() == "Đang dọn dẹp")
        {
            txtTrangThai.setTextColor(Color.parseColor("#FF004EB5"));
        }
        else if (txtTrangThai.getText().toString() == "Có khách")
        {
            txtTrangThai.setTextColor(Color.parseColor("#FFD50000"));
        }
        return  row;

    }
}

