/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.owary.faora.patterns.observer;

/**
 *
 * @author Mensur Owary
 */
public class Driver {
    
    public static void main(String[] args) {
        Newspaper dailyMail = new Newspaper();
        
        Subscriber s1 = new Subscriber(dailyMail);
        Subscriber s2 = new Subscriber(dailyMail);
        Subscriber s3 = new Subscriber(dailyMail);
        Subscriber s4 = new Subscriber(dailyMail);
        
        dailyMail.register(s1, s2, s3, s4);
        
        dailyMail.addNews("This is the first news");
        
        s4.readLatestNews();
        
        dailyMail.addNews("News 2");
        
        s4.readLatestNews();
        
    }
    
}
