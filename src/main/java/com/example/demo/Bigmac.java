package com.example.demo;

public class Bigmac implements Menu {

    private String name = "Big Mac";
    private String type = "Berger";
    private String detail = "Grill ground beef berger";
    private double calories = 540.0;
    private int price = 129;


    @Override
    public String getname() { return this.name;}

    @Override
    public void setname(String name) {this.name = name;}

    @Override
    public String gettype() {return this.type;}

    @Override
    public void settype(String type) {this.type = type;}

    @Override
    public String getdetail() {return this.detail;}

    @Override
    public void setdetail(String detail) {this.detail = detail;}

    @Override
    public double getcalories() {return this.calories;}

    @Override
    public void setcalories(double calories) {this.calories = calories;}

    @Override
    public int getprice() {return this.price;}

    @Override
    public void setprice(int price) {this.price = price;}

    @Override
    public void draw() {

    }
}
