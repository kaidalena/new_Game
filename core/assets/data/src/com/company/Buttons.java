 package com.company;



import javax.swing.*;

import java.awt.*;

import java.awt.event.MouseEvent;

import java.awt.event.MouseListener;



public class Buttons extends JPanel{

    private static JButton set = new JButton("settings");
    //  private static Image rrr = new ImageIcon("setting.png").getImage();
    //private static Image icon = rrr.getScaledInstance(90,90, Image.SCALE_SMOOTH);
    private static ImageIcon ui = new ImageIcon(new ImageIcon("setting.png").getImage().getScaledInstance(90,90, Image.SCALE_SMOOTH));

    int width = 100, height = 100;



    public Buttons(){

        //this.setBackground(new Color(2,2,2,0));

        this.setBounds(1820,0,width,height);
        set.setPreferredSize(new Dimension(width-20,height-10));
        set.setBorderPainted(false);
        set.setIcon(ui);
        set.setBackground(new Color(3,3,4,0));
        set.setVisible(false);
        this.add( set, BorderLayout.CENTER );


        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }



            @Override
            public void mousePressed(MouseEvent e) {
            }



            @Override
            public void mouseReleased(MouseEvent e) {
            }



            @Override

            public void mouseEntered(MouseEvent e) {
                set.setVisible(true);

            }


            @Override

            public void mouseExited(MouseEvent e) {
                set.setVisible(false);
            }

        });

    }

}
