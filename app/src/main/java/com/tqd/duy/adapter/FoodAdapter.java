package com.tqd.duy.adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;//xóa
import android.widget.ImageButton;
import android.widget.ImageView;//xóa
import android.widget.TextView;

import com.tqd.duy.coffeemanagement.R;
import com.tqd.duy.models.Food;

import java.text.DecimalFormat;
import java.util.List;

/**
 * Created by Danh on 12/18/2017.
 */

public class FoodAdapter extends ArrayAdapter<Food> {
    private Activity context;
    private int resource;
    private List<Food> objects;
    TextView txtNameFood;
    TextView txtPriceFood;
    TextView txtNumberFood;
    ImageButton btnPlus;
    ImageButton btnMinus;

    public FoodAdapter(@NonNull Activity context, int resource, @NonNull List<Food> objects) {
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
        txtNameFood = row.findViewById(R.id.item_menu_txt_name_food);
        txtPriceFood = row.findViewById(R.id.item_menu_txt_price_food);
        txtNumberFood = row.findViewById(R.id.item_menu_txt_number_food);
        btnPlus = row.findViewById(R.id.item_food_btn_plus);
        btnMinus = row.findViewById(R.id.item_food_btn_minus);
        final Food food = objects.get(position);
        txtNameFood.setText(food.getNameFood());
        DecimalFormat price = new DecimalFormat("##,###");
        txtPriceFood.setText(context.getResources().getString(R.string.PRICE)+": "+price.format(food.getPriceFood()));
        txtNumberFood.setText(context.getResources().getString(R.string.NUMBER)+" "+food.getNumberFood());
        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                food.setNumberFood(food.getNumberFood()+1);
                txtNumberFood.setText(context.getResources().getString(R.string.NUMBER)+" "+(food.getNumberFood()));
                notifyDataSetChanged();
            }
        });
        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (food.getNumberFood()>0) {
                    food.setNumberFood(food.getNumberFood()-1);
                    txtNumberFood.setText(context.getResources().getString(R.string.NUMBER)+" "+(food.getNumberFood()));
                    notifyDataSetChanged();
                }
            }
        });
        row.setBackground(context.getResources().getDrawable(R.drawable.border_table));
        return  row;
    }
}


