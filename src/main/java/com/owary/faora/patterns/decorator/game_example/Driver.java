/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.owary.faora.patterns.decorator.game_example;

import com.owary.faora.patterns.decorator.game_example.armors.Light;
import com.owary.faora.patterns.decorator.game_example.model.Player;
import com.owary.faora.patterns.decorator.game_example.players.Medic;
import com.owary.faora.patterns.decorator.game_example.players.Warrior;
import com.owary.faora.patterns.decorator.game_example.tools.Medkit;
import com.owary.faora.patterns.decorator.game_example.tools.Sword;

/**
 *
 * @author Mensur Owary
 */
public class Driver {
    public static void main(String[] args) {
        Player swordsman = new Warrior("Hattori Hanzo");
        swordsman = new Sword(swordsman);
        swordsman = new Light(swordsman);
        System.out.println(swordsman.attack());
        
        Player medic = new Medic("A Medic");
        medic = new Light(medic);
        medic = new Medkit(medic);
        System.out.println(medic.heal());
    }
}
