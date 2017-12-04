package com.tqd.duy.models;

import java.io.Serializable;

/**
 * Created by Danh on 12/4/2017.
 */

public class Table implements Serializable {
    private String soThuTu;
    private String trangThai;

    @Override
    public String toString() {
        return "Trạng thái: " + trangThai;
    }

    public Table() {
    }

    public Table(String soThuTu, String trangThai) {
        this.soThuTu = soThuTu;
        this.trangThai = trangThai;
    }

    public String getSoThuTu() {
        return soThuTu;
    }

    public void setSoThuTu(String soThuTu) {
        this.soThuTu = soThuTu;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
}
