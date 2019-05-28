package com.badlogicgames.superjumper;

import com.badlogic.gdx.math.Vector2;

import static java.lang.Math.pow;

public class Character {
    private Vector2 position;
    private Vector2 velocity;
    private Vector2 acceleration;
    private float rotation; // For handling bird rotation
    private int width;
    private int height;
    private int radius = 415, centreX = 930, centreY = 500;

    public boolean up = false;
    public boolean down = false;
    public boolean left = false;
    public boolean right = false;
    public boolean stop = true;


    public Character(float x, float y, int width, int height) {
        this.width = width;
        this.height = height;
        position = new Vector2(x, y);
        velocity = new Vector2(0, 0);
        acceleration = new Vector2(0, 460);
    }

    public void update(float delta) {
            if (up && (position.y <= calculationCircle(position.x, centreX, centreY, 1 ))) position.y+=2;
            else if (down && (position.y >= calculationCircle(position.x, centreX, centreY, -1 ))) position.y-=2;
            else if (left && (position.x >= calculationCircle(position.y, centreY, centreX, -1 ))) position.x-=2;
            else if (right && (position.x <= calculationCircle(position.y, centreY, centreX, 1 ))) position.x+=2;
    }

    public void press_stop() {
        stop = true;
        up=down=right=left=false;
    }

    public void press_up(){
        up = true;
        stop=down=right=left = false;
    }

    public void press_down(){
        down = true;
        stop=up=right=left = false;
    }

    public void press_left(){
        left = true;
        stop=up=down=right = false;
    }

    public void press_right(){
        right = true;
        stop=up=down=left= false;
    }

    public float getX() {
        return position.x;
    }

    public float getY() {
        return position.y;
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }

    public float getRotation() {
        return rotation;
    }

    public double calculationCircle(float one, int a, int b, int c){
        return pow((radius*radius - (one - a)*(one-a)), 0.5)*c+b;
    }
}

