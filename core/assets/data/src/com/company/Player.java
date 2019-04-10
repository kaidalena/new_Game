package com.company;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Player{

    public static int x_persanag, y_persanag, level;
    private static Image personag = new ImageIcon("man.png").getImage();

    public void paint(Graphics g) {

        System.out.println(level);
         g.drawImage(personag, x_persanag, y_persanag, 70, 80, null);
    }


    public Player(JFrame frame, int p) {
        this.level = p;
        this.y_persanag = 510;
        this.x_persanag = 960;

        frame.addKeyListener(new KeyAdapter() {

            public void keyPressed(KeyEvent e) {

                if (e.getKeyCode()== KeyEvent.VK_DOWN) y_persanag+=2;
                else if (e.getKeyCode()== KeyEvent.VK_RIGHT) x_persanag+=2;
                else if (e.getKeyCode()== KeyEvent.VK_LEFT) x_persanag-=2;
                else if (e.getKeyCode()== KeyEvent.VK_UP) y_persanag-=2;
            }

        });
    }
}
