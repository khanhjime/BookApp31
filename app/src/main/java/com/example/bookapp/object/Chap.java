package com.example.bookapp.object;

import java.io.Serializable;

public class Chap implements Serializable {
    private int pageNumber;
    private String data;

    public Chap(int pageNumber, String data) {
        this.pageNumber = pageNumber;
        this.data = data;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
