/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.owary.faora.patterns.decorator.coffee_shop_example;

import com.owary.faora.patterns.decorator.coffee_shop_example.implementations.conds.NoCondiment;
import com.owary.faora.patterns.decorator.coffee_shop_example.implementations.discs.NoDiscount;
import com.owary.faora.patterns.decorator.coffee_shop_example.interfaces.Beverage;
import com.owary.faora.patterns.decorator.coffee_shop_example.interfaces.Condiment;
import com.owary.faora.patterns.decorator.coffee_shop_example.interfaces.Discount;

/**
 *
 * @author Mensur Owary
 */
public class Order {
    
    private Beverage beverage;
    private Condiment condiment;
    private Discount discount;
    
    public Order(Beverage beverage){
        this.beverage = beverage;
        this.condiment = new NoCondiment();
        this.discount = new NoDiscount();
    }
    
    public void addCondiment(Condiment condiment){
        this.condiment = condiment;
    }
    
    public void setDiscount(Discount disc){
        this.discount = disc;
    }
    
    public double cost(){
        return this.discount.apply((beverage.cost()+condiment.cost()));
    }
}
