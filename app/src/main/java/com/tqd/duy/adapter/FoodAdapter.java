package com.tqd.duy.adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageButton;
import android.widget.TextView;
import com.tqd.duy.coffeemanagement.R;
import com.tqd.duy.models.Food;
import java.text.DecimalFormat;
import java.util.ArrayList;
/**
 * Created by Danh on 12/18/2017.
 */

public class FoodAdapter extends ArrayAdapter<Food> implements Filterable {
    private Activity context;
    private int resource;
    private ArrayList<Food> objects;
    private TextView txtNameFood;
    private TextView txtPriceFood;
    private TextView txtNumberFood;
    private ImageButton btnPlus;
    private ImageButton btnMinus;
    private CustomFilter filter;
    private ArrayList<Food> filterList;


    public FoodAdapter(@NonNull Activity context, int resource, @NonNull ArrayList<Food> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.objects = objects;
        this.filterList = objects;
    }

    @NonNull
    @Override
    public Filter getFilter() {
        if (filter == null) {
            filter = new CustomFilter();
        }
        return filter;
    }

    @Override
    public int getCount() {
        return objects.size();
    }

    @Nullable
    @Override
    public Food getItem(int position) {
        return objects.get(position);
    }

    @Override
    public long getItemId(int position) {
        return objects.indexOf(getItem(position));
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = this.context.getLayoutInflater();
        View row = inflater.inflate(this.resource,null);
        txtNameFood = row.findViewById(R.id.item_menu_txt_name_food);
        txtPriceFood = row.findViewById(R.id.item_menu_txt_price_food);
        txtNumberFood = row.findViewById(R.id.item_menu_txt_number_food);
        btnPlus = row.findViewById(R.id.item_food_btn_plus);
        btnMinus = row.findViewById(R.id.item_food_btn_minus);
        txtNameFood.setText(objects.get(position).getNameFood());
        DecimalFormat price = new DecimalFormat("##,###");
        txtPriceFood.setText(context.getResources().getString(R.string.PRICE)+": "+price.format(objects.get(position).getPriceFood()));
        txtNumberFood.setText(context.getResources().getString(R.string.NUMBER)+" "+objects.get(position).getNumberFood());
        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                objects.get(position).setNumberFood(objects.get(position).getNumberFood()+1);
                txtNumberFood.setText(context.getResources().getString(R.string.NUMBER)+" "+(objects.get(position).getNumberFood()));
                notifyDataSetChanged();
            }
        });
        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (objects.get(position).getNumberFood()>0) {
                    objects.get(position).setNumberFood(objects.get(position).getNumberFood()-1);
                    txtNumberFood.setText(context.getResources().getString(R.string.NUMBER)+" "+(objects.get(position).getNumberFood()));
                    notifyDataSetChanged();
                }
            }
        });
        row.setBackground(context.getResources().getDrawable(R.drawable.border_table));
        return  row;
    }
    class CustomFilter extends Filter{

        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {
            FilterResults results = new FilterResults();
            if (charSequence != null && charSequence.length()>0){
                charSequence = charSequence.toString().toLowerCase();
                ArrayList<Food> filter = new ArrayList<>();
                for (int i = 0;i<filterList.size();i++){
                    String nameFood = filterList.get(i).getNameFood().toLowerCase();
                    if(nameFood.contains(charSequence)){
                        filter.add(new Food(filterList.get(i).getNameFood(),filterList.get(i).getPriceFood(),
                                filterList.get(i).getNumberFood()));
                    }
                }
                results.count = filter.size();
                results.values = filter;
            }
            else {
                results.count = filterList.size();
                results.values = filterList;
            }
            return results;
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            objects = (ArrayList<Food>) filterResults.values;
            notifyDataSetChanged();

        }
    }
}


