package com.company;
import javafx.animation.Transition;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class SpriteAnimation extends Transition {
    private final ImageView imageV;
    private final int count;
    private final int columns;
    private final int offSetX;
    private final int offSetY;
    private final int vidth;
    private final int height;

    public SpriteAnimation(ImageView image, Duration du, int count, int columns, int offSetX,
                           int offSetY, int vidth, int height){
        this.imageV = image;
        this.columns = columns;
        this.count = count;
        this.offSetX = offSetX;
        this.offSetY = offSetY;
        this.vidth = vidth;
        this.height = height;
        setCycleDuration(du);
    }

    protected void interpolate (double k){
        final int index = Math.min ((int) Math.floor(k*count), count-1);
        final int x = (index % columns)* vidth +offSetX;
        final int y = (index / columns)* height + offSetY;
        imageV.setViewport( new Rectangle2D(x,y,vidth,height));

    }
}
