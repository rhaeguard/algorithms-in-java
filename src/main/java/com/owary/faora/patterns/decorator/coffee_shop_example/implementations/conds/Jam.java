/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.owary.faora.patterns.decorator.coffee_shop_example.implementations.conds;

import com.azercell.pattern.interfaces.Condiment;

/**
 *
 * @author Mensur Owary
 */
public class Jam implements Condiment{

    @Override
    public double cost() {
        return 7.15;
    }
    
}
