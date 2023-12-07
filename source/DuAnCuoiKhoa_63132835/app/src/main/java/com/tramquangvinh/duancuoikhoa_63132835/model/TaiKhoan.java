package com.tramquangvinh.duancuoikhoa_63132835.model;

public class TaiKhoan {

    private int id;
    private String TenTaiKhoan;
    private String MatKhau;
    private String Email;
    private int PhanQuyen;

    public TaiKhoan(int id, String tenTaiKhoan, String matKhau, String email, int phanQuyen) {
        this.id = id;
        TenTaiKhoan = tenTaiKhoan;
        MatKhau = matKhau;
        Email = email;
        PhanQuyen = phanQuyen;
    }

    public TaiKhoan(String tenTaiKhoan, String matKhau, String email, int phanQuyen) {
        TenTaiKhoan = tenTaiKhoan;
        MatKhau = matKhau;
        Email = email;
        PhanQuyen = phanQuyen;
    }

    public TaiKhoan(String tenTaiKhoan, String email) {
        TenTaiKhoan = tenTaiKhoan;
        Email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenTaiKhoan() {
        return TenTaiKhoan;
    }

    public void setTenTaiKhoan(String tenTaiKhoan) {
        TenTaiKhoan = tenTaiKhoan;
    }

    public String getMatKhau() {
        return MatKhau;
    }

    public void setMatKhau(String matKhau) {
        MatKhau = matKhau;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public int getPhanQuyen() {
        return PhanQuyen;
    }

    public void setPhanQuyen(int phanQuyen) {
        PhanQuyen = phanQuyen;
    }
}
