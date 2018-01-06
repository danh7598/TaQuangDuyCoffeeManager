package com.tqd.duy.adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
//không dùng thì xóa
import android.widget.TextView;

import com.tqd.duy.coffeemanagement.R;
import com.tqd.duy.models.Food;

import java.util.List;

/**
 * Created by Danh on 12/24/2017.
 */

public class BillAdapter extends ArrayAdapter<Food> {
    private Activity context;
    private int resource;
    private List<Food> objects;
    TextView txtId;
    TextView txtNameFood;
    TextView txtPriceFood;
    TextView txtNumberFood;
    TextView txtTotal;

    public BillAdapter(@NonNull Activity context, int resource, @NonNull List<Food> objects) {
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
        txtId = row.findViewById(R.id.item_bill_txt_id);
        txtNameFood = row.findViewById(R.id.item_bill_txt_name);
        txtPriceFood = row.findViewById(R.id.item_bill_txt_price);
        txtNumberFood = row.findViewById(R.id.item_bill_txt_number);
        txtTotal = row.findViewById(R.id.item_bill_txt_total);
        final Food food = objects.get(position);
        txtId.setText(position + 1 + "");
        txtNameFood.setText(food.getNameFood());
        txtPriceFood.setText(food.getPriceFood()+"");
        txtNumberFood.setText(food.getNumberFood()+ "");
        double total = food.getNumberFood()*food.getPriceFood();
        txtTotal.setText(total + "");
        row.setBackground(context.getResources().getDrawable(R.drawable.border_table));
        return  row;
    }
}
