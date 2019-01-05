/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.owary.faora.patterns.decorator.coffee_shop_example;

import com.owary.faora.patterns.decorator.coffee_shop_example.implementations.bevs.Coffee;
import com.owary.faora.patterns.decorator.coffee_shop_example.implementations.conds.Milk;
import com.owary.faora.patterns.decorator.coffee_shop_example.implementations.discs.BlackFridayDiscount;
import com.owary.faora.patterns.decorator.coffee_shop_example.interfaces.*;

/**
 *
 * @author Mensur Owary
 */
public class Driver {
    public static void main(String[] args) {
        Beverage coffee = new Coffee();
        Condiment milk = new Milk();
        Order o = new Order(coffee);
        
        o.addCondiment(milk);
        o.setDiscount(new BlackFridayDiscount());
        
        System.out.println(o.cost());
    }
}
