package com.example.demo;

import java.io.*;
import java.util.ArrayList;

public class SingletonCart {
    private static SingletonCart instance;
    private static ArrayList<String> MenuId;
    private static ArrayList<Menu> Menus;
    private static String line;


    private SingletonCart() {
        Menus = new ArrayList<Menu>();
    }

    public static SingletonCart getInstance() {
        if (instance == null) {
            instance = new SingletonCart();
        }
        try {
            FileReader fileReader = new FileReader("cart.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while((line = bufferedReader.readLine()) != null) {
                if (Integer.parseInt(line) >= 0 && Integer.parseInt(line) < MenuFactory.getMenuList().length) {
                    Menus.add(MenuFactory.getMenu(Integer.parseInt(line)));
                }
            }
        }
        catch (FileNotFoundException e) {
            try {
                PrintWriter writer = new PrintWriter("cart.txt", "UTF-8");
                writer.close();
            }
            catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
            catch (UnsupportedEncodingException ex) {
                ex.printStackTrace();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return instance;
    }

    public boolean add(int id) {
        if (id > MenuFactory.getMenuList().length) {
            return false;
        } else {
//            FileWriter writer = null;
//            try {
//                writer = new FileWriter("cart.txt");
//                for(String str: MenuId) {
//                    writer.write(str + System.lineSeparator());
//                }
//                writer.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
            Menus.add(MenuFactory.getMenu(id));
//            MenuId.add(Integer.toString(id));
            return true;
        }

    }

    public void clear() {
        Menus.clear();
        PrintWriter writer = null;
        try {
            writer = new PrintWriter("cart.txt");
            writer.print("");
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public int checkout(){
        int total = 0;
        for (Menu menu : Menus) {
            total += menu.getprice();
        }
        Menus.clear();
        return total;
    }

    public ArrayList<Menu> getCart() {
        return Menus;
    }

}
