package com.company;

import javax.swing.*;
import java.awt.event.*;

//public class Listener implements MouseListener  {
//
//
//    public Pole start;
//    public void mouseClicked(MouseEvent e){
//
//        start.Next_planeta();
//    }
//
//    public void mouseEntered(MouseEvent e) {
//    }
//
//    public void mouseExited(MouseEvent e) {
//    }
//
//    public void mousePressed(MouseEvent e) {
//    }
//
//    public void mouseReleased(MouseEvent e) {
//    }

public class Listener implements KeyListener {

    public Pole start;

    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent e) {

        if (e.getKeyCode()== KeyEvent.VK_DELETE)  start.Next_planeta() ;
        }

    public void keyReleased(KeyEvent e) {

    }

    public Listener (Pole p){
            start = p;
    }
}
