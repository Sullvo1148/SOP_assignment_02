package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
    @Autowired
    public SingletonCart cart = SingletonCart.getInstance();
    String direction = "******************************************************************************<br>" +
            "***********************************hello guys***********************************<br>" +
            "******************************************************************************<br>" +
            "  this is first page and show you how to use.<br>" +
            "1. You can check the menu by type  /menu  after URL.<br>" +
            "2. See menu detail by type  /menu/{id}  .<br>" +
            "3. If you want to order it just type  /menu/{id}/add  to send to cart.<br>" +
            "4. You can check your cart by type  /cart  .<br>" +
            "5. You can order item(s) in cart by type  /cart/checkout  .<br>" +
            "6. Clear cart by type  /cart/clear<br>" +
            "******************************************************************************<br>";

    @RequestMapping("/")
    String home() {
        return direction;
    }

    @RequestMapping("/menu")
    String getMenuList() {
        String show1 = "";
        for(Menu menus :MenuFactory.getMenuList()){
            show1 += "Name : " + menus.getname() + "<br>" +
                    "Type : " + menus.gettype() + "<br>" +
                    "Detail : " + menus.getdetail() + "<br>" +
                    "calories : " + menus.getcalories() + "<br>" +
                    "price : " + menus.getprice() + "<br><br>";
        }
        return direction + show1;
    }

    @RequestMapping("/menu/{id}")
    String getMenu(@PathVariable int id) {
        return direction + "Name : " + MenuFactory.getMenu(id).getname() + "<br>" +
                "Type : " + MenuFactory.getMenu(id).gettype() + "<br>" +
                "Detail : " + MenuFactory.getMenu(id).getdetail() + "<br>" +
                "calories : " + MenuFactory.getMenu(id).getcalories() + "<br>" +
                "price : " + MenuFactory.getMenu(id).getprice() + "<br>";
    }


    @RequestMapping("/menu/{id}/add")
    String addToCart(@PathVariable int id) {
        if (cart.add(id)) {
            return direction + MenuFactory.getMenu(id).getname() + " is added successfully.";
        } else {
            return direction + "menu is unavailable";
        }
    }

    @GetMapping("/cart")
    Object cart(){
        String show2 = "";
        return cart.getCart();
    }

    @PostMapping("/cart")
    Object addCart(@RequestBody @Valid Cart item) {
        cart.addCart(item);
        return cart.getCart();
    }

    @RequestMapping("/cart/clear")
    String clear() {
        cart.clear();
        return direction + "Cart is cleared";
    }

    @RequestMapping("/cart/checkout")
    String checkout() {
        int total = cart.checkout();
        return direction + "Total: " + total + " baht. File have saved.<br>";
    }

    @PutMapping("/")

}
