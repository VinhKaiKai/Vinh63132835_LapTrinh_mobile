package com.tramquangvinh.ungdungdoctruyen.model;

public class chuyenmuc {
    private String tenchuyenmuc;
    private int hinhanhchuyenmuc;

    public String getTenchuyenmuc() {
        return tenchuyenmuc;
    }

    public chuyenmuc(String tenchuyenmuc, int hinhanhchuyenmuc) {
        this.tenchuyenmuc = tenchuyenmuc;
        this.hinhanhchuyenmuc = hinhanhchuyenmuc;
    }

    public void setTenchuyenmuc(String tenchuyenmuc) {
        this.tenchuyenmuc = tenchuyenmuc;
    }

    public int getHinhanhchuyenmuc() {
        return hinhanhchuyenmuc;
    }

    public void setHinhanhchuyenmuc(int hinhanhchuyenmuc) {
        this.hinhanhchuyenmuc = hinhanhchuyenmuc;
    }
}
