package com.example.bookapp.object;

import org.json.JSONException;
import org.json.JSONObject;

public class TruyenNgang {
    private String tenTruyen, anhTruyenNgang, noiDung;

    public TruyenNgang() {
    }

    public TruyenNgang(JSONObject o)throws JSONException {
        tenTruyen= o.getString("tenTruyen");
        anhTruyenNgang= o.getString("linhAnh");
        noiDung= o.getString("noiDung");
    }

    public TruyenNgang(String tenTruyen, String anhTruyenNgang, String noiDung) {
        this.tenTruyen = tenTruyen;
        this.anhTruyenNgang = anhTruyenNgang;
        this.noiDung = noiDung;
    }

    public String getTenTruyen() {
        return tenTruyen;
    }

    public void setTenTruyen(String tenTruyen) {
        this.tenTruyen = tenTruyen;
    }

    public String getAnhTruyenNgang() {
        return anhTruyenNgang;
    }

    public void setAnhTruyenNgang(String anhTruyenNgang) {
        this.anhTruyenNgang = anhTruyenNgang;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }
}
