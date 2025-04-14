package com.Bean;

import java.io.Serializable;

public class BookBean implements Serializable {
    private int bookNo; // Add this line
    private String bname;
    private String aname;
    private int price;
    private String pubname;

    public BookBean() {
        super();
    }

    public BookBean(int bookNo, String bname, String aname, int price, String pubname) {
        this.bookNo = bookNo; // Initialize bookNo
        this.bname = bname;
        this.aname = aname;
        this.price = price;
        this.pubname = pubname;
    }

    // Getter and setter for bookNo
    public int getBookNo() {
        return bookNo;
    }

    public void setBookNo(int bookNo) {
        this.bookNo = bookNo;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getPubname() {
        return pubname;
    }

    public void setPubname(String pubname) {
        this.pubname = pubname;
    }

    @Override
    public String toString() {
        return "BookBean [bookNo=" + bookNo + ", bname=" + bname + ", aname=" + aname + ", price=" + price + ", pubname=" + pubname + "]";
    }
}
