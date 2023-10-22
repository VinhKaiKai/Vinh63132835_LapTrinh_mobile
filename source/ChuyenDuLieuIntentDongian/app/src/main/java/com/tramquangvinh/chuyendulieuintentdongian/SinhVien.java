package com.tramquangvinh.chuyendulieuintentdongian;

import java.io.Serializable;

public class SinhVien implements Serializable {
    private String name;
    private int tuoi;
    private String diachi;

    public SinhVien(String name, int tuoi, String diachi) {
        this.name = name;
        this.tuoi = tuoi;
        this.diachi = diachi;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }
}
