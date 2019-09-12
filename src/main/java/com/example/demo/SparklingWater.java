package com.example.demo;

public class SparklingWater implements Menu{

    private String name = "Sparkling Water";
    private String type = "Drink";
    private String detail = "Coca cola, Sprite, Root beer. you can order at counter.";
    private double calories = 197;
    private int price = 29;


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
