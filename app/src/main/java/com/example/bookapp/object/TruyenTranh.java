package com.example.bookapp.object;

import org.json.JSONException;
import org.json.JSONObject;

public class TruyenTranh {
    private String tenTruyen, linkAnh, noiDung;



    public TruyenTranh(){

    }
    public TruyenTranh(JSONObject o)throws JSONException {
       tenTruyen= o.getString("tenTruyen");
       linkAnh= o.getString("linhAnh");
        noiDung= o.getString("noiDung");



    }

    public TruyenTranh(String tenTruyen, String linkAnh, String noiDung) {
        this.tenTruyen = tenTruyen;
        this.linkAnh = linkAnh;
        this.noiDung = noiDung;
    }

    public String getTenTruyen() {
        return tenTruyen;
    }

    public void setTenTruyen(String tenTruyen) {
        this.tenTruyen = tenTruyen;
    }

    public String getLinkAnh() {
        return linkAnh;
    }

    public void setLinkAnh(String linkAnh) {
        this.linkAnh = linkAnh;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }
}

