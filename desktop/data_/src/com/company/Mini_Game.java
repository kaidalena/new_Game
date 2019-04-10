package com.company;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Mini_Game extends JFrame {

    private static JFrame frame;
    private static JFrame big_game;


    public Mini_Game(JFrame s){
        frame = this;
        big_game = s;
        JButton klick = new JButton("Сlick me");
        klick.setBounds(250, 250, 100, 50);
        JPanel pen = new JPanel();
        this.setBounds(100,100,300,300);
        this.add(pen);
        pen.add(klick);
        pen.setVisible(true);

        klick.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                frame.setVisible(false);
                big_game.setVisible(true);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }

}
