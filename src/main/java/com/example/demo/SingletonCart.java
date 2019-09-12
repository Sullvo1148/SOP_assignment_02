package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class SingletonCart {
    private static SingletonCart instance;
    private static ArrayList<Menu> Menus;
    private static String line;


    private SingletonCart() {
        Menus = new ArrayList<Menu>();
    }

    @Autowired
    private CartRepository cartRepository;

    public static SingletonCart getInstance() {
        if (instance == null) {
            instance = new SingletonCart();
        }

        return instance;
    }

    public boolean add(int id) {
        if (id > MenuFactory.getMenuList().length) {
            return false;
        } else {
            Menus.add(MenuFactory.getMenu(id));
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

    public List<Cart> getCart() {
        return cartRepository.findAll();
    }

    public void addCart(Cart cart) {
        cart.setId(((int) cartRepository.count()) + 1);
        cartRepository.save(cart);
    }

}
