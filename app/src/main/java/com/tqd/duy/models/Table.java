package com.tqd.duy.models;

import java.io.Serializable;

/**
 * Created by Danh on 12/4/2017.
 */

public class Table implements Serializable {
    private String id;//đổi lại thàn id nhé
    private String status;//đặt tên lại theo chuẩn tiếng anh đi em, đừng đặt tiếng việt

    @Override
    public String toString() {
        return "Trạng thái: " + status;
    }

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
}
