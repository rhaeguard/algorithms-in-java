/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.owary.faora.patterns.decorator.game_example.model;

/**
 *
 * @author Mensur Owary
 */
public abstract class Player {
    
    private final String name;
    private final double life;
    protected final double attack;
    protected final double defence;
    protected final double heal;
    private double speed;
    
    public Player(String name){
        this.name = name;
        this.life = 1;
        this.attack = .09;
        this.defence = .02;
        this.heal = 0.01;
        this.speed = 1;
    }

    public String name() {
        return name;
    }

    public double life() {
        return life;
    }
    
    public abstract double attack();

    public abstract double protect();
    
    public abstract double heal();
    
    public void speed(double speed){
        this.speed-=speed;
    }
    
    public double speed(){
        return this.speed;
    }
  
}
