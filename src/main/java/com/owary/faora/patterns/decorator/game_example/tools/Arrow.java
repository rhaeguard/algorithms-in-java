/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.owary.faora.patterns.decorator.game_example.tools;

import com.owary.faora.patterns.decorator.game_example.model.*;

/**
 *
 * @author Mensur Owary
 */
public class Arrow extends Player implements Weapon{

    private final double attack = .12;
    private final Player player;
    
    public Arrow(Player player) {
        super("Arrow");
        this.player = player;
    }

    @Override
    public double attack() {
        return this.player.attack()+this.attack;
    }

    @Override
    public double protect() {
        return this.player.attack();
    }

    @Override
    public double heal() {
        return player.heal();
    }
    
}
