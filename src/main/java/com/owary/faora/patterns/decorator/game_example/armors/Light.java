/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.owary.faora.armors;

import com.owary.faora.model.Armor;
import com.owary.faora.model.Player;

/**
 *
 * @author Mensur Owary
 */
public class Light extends Player implements Armor{
    
    private final double protect = .15;
    private final Player player;

    public Light(Player player) {
        super("Light Armor");
        this.player = player;
        this.player.speed(.05);
    }

    @Override
    public double protect() {
        return player.protect()+this.protect;
    }

    @Override
    public double attack() {
        return player.attack();
    }

    @Override
    public double heal() {
        return this.player.heal();
    }
    
}
