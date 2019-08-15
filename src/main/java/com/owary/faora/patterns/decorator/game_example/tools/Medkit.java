/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.owary.faora.patterns.decorator.game_example.tools;

import com.owary.faora.patterns.decorator.game_example.model.MedicalTool;
import com.owary.faora.patterns.decorator.game_example.model.Player;

/**
 *
 * @author Mensur Owary
 */
public class Medkit extends Player implements MedicalTool {

    private final Player player;
    
    public Medkit(Player player) {
        super("Medkit");
        this.player = player;
    }

    @Override
    public double attack() {
        return this.player.attack();
    }

    @Override
    public double protect() {
        return this.player.attack();
    }

    @Override
    public double heal() {
        return player.heal()+.25;
    }
    
}
