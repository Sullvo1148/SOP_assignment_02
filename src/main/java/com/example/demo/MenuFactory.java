package com.example.demo;

public class MenuFactory {
    public static final Menu[] MENU = new Menu[]{
            new Bigmac(),
            new FishBerger(),
            new SamuraiBerger(),
            new SparklingWater(),
            new Donut()
    };

    public static Menu getMenu(int menu) {
        return MENU[menu];
    }

    public static Menu[] getMenuList() {
        return MENU;
    }
}
