/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.owary.faora.patterns.decorator.coffee_shop_example.implementations.discs;

import com.owary.faora.patterns.decorator.coffee_shop_example.interfaces.Discount;

/**
 *
 * @author Mensur Owary
 */
public class BlackFridayDiscount implements Discount {

    @Override
    public double apply(double d) {
        return 0.5*d;
    }
    
}
