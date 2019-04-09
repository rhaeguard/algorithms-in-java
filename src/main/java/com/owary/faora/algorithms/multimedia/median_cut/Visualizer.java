package com.owary.faora.algorithms.multimedia.median_cut;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Visualizer {

    private JFrame jFrame;
    private java.util.List<Color> colorList = new ArrayList<>();

    public Visualizer(java.util.List<Color> colorList){
        this.colorList = colorList;
        init();
        jFrame.setVisible(true);
    }

    public void init() {
        jFrame = new JFrame();
        jFrame.setBounds(100, 100, 400, 400);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.getContentPane().setLayout(new GridLayout(4, 4));

        int s = 0;
        int size = (int) Math.sqrt(colorList.size());
        for (int i=0;i < size;i++) {
            for (int j = 0; j < size; j++) {
                JPanel jPanel = new JPanel();
                Color color = colorList.get(s);
                jPanel.setBackground(color);
                s++;
                jPanel.setBounds(j*100, i*100, 100, 100);
                jFrame.getContentPane().add(jPanel);
            }
        }
    }

}
