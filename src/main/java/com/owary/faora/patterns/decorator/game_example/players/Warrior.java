/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.owary.faora.patterns.decorator.game_example.players;

import com.owary.faora.patterns.decorator.game_example.model.Player;

/**
 *
 * @author Mensur Owary
 */
public class Warrior extends Player {
    
    private final double attack = .12;
    
    public Warrior(String name) {
        super(name);
    }

    @Override
    public double attack() {
        return this.attack;
    }

    @Override
    public double protect() {
        return .10;
    }

    @Override
    public double heal() {
        return this.heal;
    }
    
}
