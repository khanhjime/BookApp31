package com.example.bookapp.object;

import org.json.JSONException;
import org.json.JSONObject;

public class TruyenNgang {
    private String anhTruyenNgang, noiDung;

    public TruyenNgang() {
    }

    public TruyenNgang(JSONObject o)throws JSONException {
        anhTruyenNgang= o.getString("linhAnh");
        noiDung= o.getString("noiDung");
    }

    public TruyenNgang(String anhTruyenNgang, String noiDung) {
        this.anhTruyenNgang = anhTruyenNgang;
        this.noiDung = noiDung;
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
