package com.tqd.duy.models;

import android.app.Activity;

import com.tqd.duy.adapter.TableAdapter;
import com.tqd.duy.coffeemanagement.MainActivity;
import com.tqd.duy.coffeemanagement.R;

import java.util.ArrayList;

/**
 * Created by Danh on 12/9/2017.
 */

public class Example {
    private Activity context;
    private ArrayList<Table> dsTable;
    public Example(Activity context, ArrayList<Table> dsTable) {
        this.context = context;
        this.dsTable = dsTable;
    }

    public void SetTableExample(){
        dsTable.add(new Table(context.getString(R.string.TABLE_NUM) +" "+(dsTable.size()+1),
                context.getString(R.string.AVAILABLE)));
        dsTable.add(new Table(context.getString(R.string.TABLE_NUM) +" "+(dsTable.size()+1),
                context.getString(R.string.BOOKED)));
        dsTable.add(new Table(context.getString(R.string.TABLE_NUM) +" "+(dsTable.size()+1),
                context.getString(R.string.BUSY)));
        dsTable.add(new Table(context.getString(R.string.TABLE_NUM) +" "+(dsTable.size()+1),
                context.getString(R.string.CLEAN)));
        dsTable.add(new Table(context.getString(R.string.TABLE_NUM) +" "+(dsTable.size()+1),
                context.getString(R.string.AVAILABLE)));
        dsTable.add(new Table(context.getString(R.string.TABLE_NUM) +" "+(dsTable.size()+1),
                context.getString(R.string.BUSY)));
        dsTable.add(new Table(context.getString(R.string.TABLE_NUM) +" "+(dsTable.size()+1),
                context.getString(R.string.BOOKED)));
        dsTable.add(new Table(context.getString(R.string.TABLE_NUM) +" "+(dsTable.size()+1),
                context.getString(R.string.AVAILABLE)));
        dsTable.add(new Table(context.getString(R.string.TABLE_NUM) +" "+(dsTable.size()+1),
                context.getString(R.string.CLEAN)));
        dsTable.add(new Table(context.getString(R.string.TABLE_NUM) +" "+(dsTable.size()+1),
                context.getString(R.string.AVAILABLE)));
        dsTable.add(new Table(context.getString(R.string.TABLE_NUM) +" "+(dsTable.size()+1),
                context.getString(R.string.BOOKED)));
        dsTable.add(new Table(context.getString(R.string.TABLE_NUM) +" "+(dsTable.size()+1),
                context.getString(R.string.CLEAN)));
        dsTable.add(new Table(context.getString(R.string.TABLE_NUM) +" "+(dsTable.size()+1),
                context.getString(R.string.AVAILABLE)));



    }
}
