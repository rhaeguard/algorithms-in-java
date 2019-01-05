/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.owary.faora.tools;

import com.owary.faora.model.Player;
import com.owary.faora.model.Weapon;

/**
 *
 * @author Mensur Owary
 */
public class Sword extends Player implements Weapon{
    
    private Player player;
    private final double attack = 0.4;

    public Sword(Player player){
        super("Sword");
        this.player = player;
        this.player.speed(.03);
    }
    
    @Override
    public double attack() {
        return this.speed()*(player.attack()+this.attack);
    }

    @Override
    public double protect() {
        return player.protect();
    }
    
    @Override
    public double heal() {
        return this.player.heal();
    }
    
}
