package com.example.demo;

public interface Menu {
    String getname();
    void  setname(String name);

    String gettype();
    void settype(String type);

    String getdetail();
    void setdetail(String detail);

    double getcalories();
    void  setcalories(double calories);

    int getprice();
    void setprice(int price);

    void draw();
}
