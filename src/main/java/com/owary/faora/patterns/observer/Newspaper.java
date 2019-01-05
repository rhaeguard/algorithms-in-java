/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.owary.faora.patterns.observer;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Mensur Owary
 */
public class Newspaper implements Observable{
    
    private Set<Observer> subscribers;
    
    private String news;
    
    public Newspaper(){
        this.subscribers = new HashSet<>();
        this.news = "";
    }

    @Override
    public void register(Observer...o) {
        for(Observer obs : o){
           subscribers.add(obs);
        }
    }

    @Override
    public void remove(Observer o) {
        subscribers.remove(o);
    }

    @Override
    public void inform() {
        subscribers.forEach(s->{
            s.update();
        });
    }
    
    public void addNews(String news){
        this.news = news;
        this.inform();
    }
    
    public String getNews(){
        return this.news;
    }
}
