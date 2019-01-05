/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.owary.faora.patterns.decorator.coffee_shop_example.implementations.bevs;

import com.owary.faora.patterns.decorator.coffee_shop_example.interfaces.Beverage;

/**
 *
 * @author Mensur Owary
 */
public class Coffee implements Beverage {

    @Override
    public double cost() {
        return 10.3;
    }
    
}
