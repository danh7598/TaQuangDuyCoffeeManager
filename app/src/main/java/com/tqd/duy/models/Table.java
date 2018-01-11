package com.tqd.duy.models;

import android.app.Activity;
import com.tqd.duy.coffeemanagement.R;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Danh on 12/4/2017.
 */

public class Table implements Serializable {
    private String id;
    private String status;

    public Table() {
    }

    public Table(String id, String status) {
        this.id = id;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ArrayList<Table> getSampleTable(Activity context){
        ArrayList<Table> listTable = new ArrayList<>();
        listTable.add(new Table(context.getString(R.string.TABLE_NUM) +" "+(listTable.size()+1),
                context.getString(R.string.AVAILABLE)));
        listTable.add(new Table(context.getString(R.string.TABLE_NUM) +" "+(listTable.size()+1),
                context.getString(R.string.CLEAN)));
        listTable.add(new Table(context.getString(R.string.TABLE_NUM) +" "+(listTable.size()+1),
                context.getString(R.string.BUSY)));
        listTable.add(new Table(context.getString(R.string.TABLE_NUM) +" "+(listTable.size()+1),
                context.getString(R.string.BOOKED)));
        listTable.add(new Table(context.getString(R.string.TABLE_NUM) +" "+(listTable.size()+1),
                context.getString(R.string.AVAILABLE)));
        listTable.add(new Table(context.getString(R.string.TABLE_NUM) +" "+(listTable.size()+1),
                context.getString(R.string.BOOKED)));
        listTable.add(new Table(context.getString(R.string.TABLE_NUM) +" "+(listTable.size()+1),
                context.getString(R.string.AVAILABLE)));
        listTable.add(new Table(context.getString(R.string.TABLE_NUM) +" "+(listTable.size()+1),
                context.getString(R.string.BUSY)));
        listTable.add(new Table(context.getString(R.string.TABLE_NUM) +" "+(listTable.size()+1),
                context.getString(R.string.AVAILABLE)));
        listTable.add(new Table(context.getString(R.string.TABLE_NUM) +" "+(listTable.size()+1),
                context.getString(R.string.BUSY)));
        listTable.add(new Table(context.getString(R.string.TABLE_NUM) +" "+(listTable.size()+1),
                context.getString(R.string.CLEAN)));
        listTable.add(new Table(context.getString(R.string.TABLE_NUM) +" "+(listTable.size()+1),
                context.getString(R.string.BOOKED)));
        listTable.add(new Table(context.getString(R.string.TABLE_NUM) +" "+(listTable.size()+1),
                context.getString(R.string.AVAILABLE)));
        listTable.add(new Table(context.getString(R.string.TABLE_NUM) +" "+(listTable.size()+1),
                context.getString(R.string.CLEAN)));
        listTable.add(new Table(context.getString(R.string.TABLE_NUM) +" "+(listTable.size()+1),
                context.getString(R.string.CLEAN)));
        return listTable;
    }
}
