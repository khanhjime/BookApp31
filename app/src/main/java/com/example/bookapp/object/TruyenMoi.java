package com.example.bookapp.object;

import android.widget.Button;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class TruyenMoi {
    private String tenTruyen, anhTruyenMoi;
    private ArrayList<Chap> noiDung;
    private Button doc;

    public TruyenMoi() {
    }


    public TruyenMoi(String tenTruyen, String anhTruyenMoi, Button doc, ArrayList<Chap> noiDung) {
        this.tenTruyen = tenTruyen;
        this.anhTruyenMoi = anhTruyenMoi;
        this.doc = doc;
        this.noiDung = noiDung;
    }

    public String getTenTruyen() {
        return tenTruyen;
    }

    public void setTenTruyen(String tenTruyen) {
        this.tenTruyen = tenTruyen;
    }

    public String getAnhTruyenMoi() {
        return anhTruyenMoi;
    }

    public void setAnhTruyenMoi(String anhTruyenMoi) {
        this.anhTruyenMoi = anhTruyenMoi;
    }

    public Button getDoc() {
        return doc;
    }

    public void setDoc(Button doc) {
        this.doc = doc;
    }

    public ArrayList<Chap> getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(ArrayList<Chap> noiDung) {
        this.noiDung = noiDung;
    }
}
