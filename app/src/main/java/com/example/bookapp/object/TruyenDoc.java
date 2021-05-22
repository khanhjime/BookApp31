package com.example.bookapp.object;

public class TruyenDoc {
    private String name1;
    private String name2;
    private String name3;
    private int anhSach;
    private String theLoai;

    public TruyenDoc(String name1, String name2, String name3, int anhSach, String theLoai) {
        this.name1 = name1;
        this.name2 = name2;
        this.name3 = name3;
        this.anhSach = anhSach;
        this.theLoai = theLoai;
    }

    public String getName1() {
        return name1;
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }

    public String getName2() {
        return name2;
    }

    public void setName2(String name2) {
        this.name2 = name2;
    }

    public String getName3() {
        return name3;
    }

    public void setName3(String name3) {
        this.name3 = name3;
    }

    public int getAnhSach() {
        return anhSach;
    }

    public void setAnhSach(int anhSach) {
        this.anhSach = anhSach;
    }

    public String getTheLoai() {
        return theLoai;
    }

    public void setTheLoai(String theLoai) {
        this.theLoai = theLoai;
    }
}
