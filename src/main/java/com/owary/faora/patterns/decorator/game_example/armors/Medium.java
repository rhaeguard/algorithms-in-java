/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.owary.faora.patterns.decorator.game_example.armors;

import com.owary.faora.patterns.decorator.game_example.model.Armor;
import com.owary.faora.patterns.decorator.game_example.model.Player;

/**
 *
 * @author Mensur Owary
 */
public class Medium extends Player implements Armor {
    
    private final double protect = .25;
    private final Player player;

    public Medium(Player player) {
        super("Medium Armor");
        this.player = player;
        this.player.speed(.11);
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
