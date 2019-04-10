package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Izmeneniya extends JPanel {

    private static int x_pozition_krater = 715,
                        y_pozition_krater = 680, level,
                        x_pozition_baob = 1330,
                        y_pozition_babob = 100;
    private static Image krater = new ImageIcon("krater2.png").getImage();
    private static Image baobab = new ImageIcon("baobab.png").getImage();
    private static JFrame big_game;

    public void paint(Graphics g)
    {
        if (level ==1) {
            g.drawImage(krater, x_pozition_krater, y_pozition_krater, 280, 243, null);
            g.drawImage(baobab, 0, 0, big_game.getWidth(), big_game.getHeight(), null);
        }
    }

    public Izmeneniya (JFrame f, int level){

        this.level = level;
        this.big_game = f;
        this.setBounds(0, 0,1910, 1070);

        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                big_game.setVisible(false);
                Mini_Game sudoku = new Mini_Game( big_game);
                sudoku.setVisible(true);

                if (e.getY()>y_pozition_krater && e.getY()<(y_pozition_krater+243))
                    if (e.getX()>x_pozition_krater && e.getX()<(x_pozition_krater+280))
                        krater = null;
                if (e.getY()>y_pozition_babob && e.getY()<(y_pozition_babob+380))
                    if (e.getX()>x_pozition_baob && e.getX()<(x_pozition_baob+310))
                        baobab = null;
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
