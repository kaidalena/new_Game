package com.badlogicgames.superjumper;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

public class MyObject {

    public  Rectangle position;
    public  TextureRegion picture;
    public  int x, y, height, width;

    public MyObject(int x_, int y_, int width_, int height_, TextureRegion picture){
        this.picture = picture;
        x = x_; y = y_;
        width = width_; height = height_;
        position = new Rectangle(x, y, width, height);
    }
}
