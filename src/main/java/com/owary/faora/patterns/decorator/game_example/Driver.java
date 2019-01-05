/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.owary.faora;

import com.owary.faora.armors.Light;
import com.owary.faora.model.Player;
import com.owary.faora.players.Medic;
import com.owary.faora.players.Warrior;
import com.owary.faora.tools.Medkit;
import com.owary.faora.tools.Sword;

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
