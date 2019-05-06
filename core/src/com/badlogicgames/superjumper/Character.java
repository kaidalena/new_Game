package com.badlogicgames.superjumper;

import com.badlogic.gdx.math.Vector2;

public class Character {
    private Vector2 position;
    private Vector2 velocity;
    private Vector2 acceleration;
    private float rotation; // For handling bird rotation
    private int width;
    private int height;
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
            if (up) position.y++;
            else if (down) position.y--;
            else if (left) position.x--;
            else if (right) position.x++;
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
}

