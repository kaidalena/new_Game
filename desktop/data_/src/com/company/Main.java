package com.company;

import javax.swing.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Main {

    private static int level;
    private static Pole background;
    private static JFrame f;
    private static Player play;
    private static JButton settings;
    private static JLayeredPane lp = new JLayeredPane();

    public static void main(String[] args) {

        level =0;

        f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setExtendedState(JFrame.MAXIMIZED_BOTH);
        f.setUndecorated(true);

//
//        JPanel pole = new JPanel();
//
//        JProgressBar progressBar = new JProgressBar();
//        progressBar.setStringPainted(true);
//        progressBar.setMinimum(0);
//        progressBar.setMaximum(100);
//        pole.add(progressBar);
//        f.add(pole);
//        pole.setVisible(true);

        Buttons www = new Buttons();
        www.setBackground(new Color(1,1,0,0));


        background = new Pole(f,level, lp);
        //background.addMouseListener(new Listener( background));
        f.addKeyListener(new Listener( background));
        lp.add(background, new Integer(1));
        lp.add(www, new Integer(3));

        f.add(lp, BorderLayout.CENTER);

        f.setVisible(true);
    }
}