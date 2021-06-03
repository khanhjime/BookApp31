package com.example.bookapp.object;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class TruyenTranh {
    private String tenTruyen, linkAnh;
    private ArrayList<Chap> noiDung;

    public TruyenTranh(String tenTruyen, String linkAnh, ArrayList<Chap> noiDung) {
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

    public ArrayList<Chap> getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(ArrayList<Chap> noiDung) {
        this.noiDung = noiDung;
    }
}

