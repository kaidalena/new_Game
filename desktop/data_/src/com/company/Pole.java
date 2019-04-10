package com.company;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.*;


public class Pole extends JPanel implements  ActionListener {
    int level;
    Image background;
    Timer timer = new Timer(20, this);
    JFrame frame;
    JLayeredPane sloi = new JLayeredPane();
    Player man;

    String[] file_planet = new String[7];


    public void paint(Graphics g) {
        g.drawImage(background, 0, 0,frame.getWidth(), frame.getHeight(), null);
        if (level>0) man.paint(g);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }

    public Pole(JFrame frame, int p, JLayeredPane sloi) {

        timer.start();
        this.frame = frame;
        this.sloi = sloi;
        this.background = new ImageIcon("4.png").getImage();
        this.setBounds(0,0,1920, 1080);

        man = new Player(frame, p);
        level=p;
    }

    public void Next_planeta ()
    {
        level++;
        if (level==1)
        {
            this.background = new ImageIcon("Planeta_1PNG.png").getImage();
            Izmeneniya krater_baob = new Izmeneniya(this.frame, level);
            sloi.add(krater_baob, new Integer(2));
        }
        else  this.background = new ImageIcon("zemlya.png").getImage();
    }

}
