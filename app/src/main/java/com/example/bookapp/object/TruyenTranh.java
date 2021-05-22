package com.example.bookapp.object;

public class TruyenTranh {
    private String tenTruyen,tenChap;
    private int linhAnh;

    public TruyenTranh(){

    }

    public TruyenTranh(String tenTruyen, String tenChap, int linhAnh) {
        this.tenTruyen = tenTruyen;
        this.tenChap = tenChap;
        this.linhAnh = linhAnh;
    }

    public String getTenTruyen() {
        return tenTruyen;
    }

    public void setTenTruyen(String tenTruyen) {
        this.tenTruyen = tenTruyen;
    }

    public String getTenChap() {
        return tenChap;
    }

    public void setTenChap(String tenChap) {
        this.tenChap = tenChap;
    }

    public int getLinhAnh() {
        return linhAnh;
    }

    public void setLinhAnh(int linhAnh) {
        this.linhAnh = linhAnh;
    }
}
