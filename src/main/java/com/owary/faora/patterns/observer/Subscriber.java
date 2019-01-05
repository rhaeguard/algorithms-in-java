/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.owary.faora.patterns.observer;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mensur Owary
 */
public class Subscriber implements Observer{
    
    private Newspaper newspaper;
    private List<String> news;
    
    public Subscriber(Newspaper newspaper){
        this.newspaper = newspaper;
        this.news = new ArrayList<>();
    }
    
    public void readLatestNews(){
        System.out.println(news.get(news.size()-1));
    }

    @Override
    public void update() {
        news.add(newspaper.getNews());
    }
    
}
