package com.example.bookapp.object;

import android.widget.ArrayAdapter;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class TruyenNgang {
    private String tenTruyen, anhTruyenNgang;
    private ArrayList<Chap> noiDung;

    public TruyenNgang() {
    }

    public TruyenNgang(String tenTruyen, String anhTruyenNgang, ArrayList<Chap> noiDung) {
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

    public ArrayList<Chap> getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(ArrayList<Chap> noiDung) {
        this.noiDung = noiDung;
    }
}
