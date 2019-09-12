package com.example.demo;

public class FishBerger implements Menu {

    private String name = "Fish Berger";
    private String type = "Berger";
    private String detail = "Berger with fried fish";
    private double calories = 282.5;
    private int price = 84;


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
