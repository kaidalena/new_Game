package com.badlogicgames.superjumper;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.Timer;
import java.util.TimerTask;

import static java.lang.Math.pow;

public class History extends GameScreen {
    private static int time=0;
    public static Timer t;
    public static TimerTask pokaz;
    public static TimerTask diagonal;
    public static TimerTask circle;
    public static TimerTask square;
    public static TimerTask diamond;
    private static  int x=0, y=0;
    private static TextureRegion picture;


    public History (SuperGame main, Texture fon, TextureRegion go){
        super(main);
        System.out.println();
        Assets.backgroundRegion.setTexture(fon);
        picture = go;
        load();
        t = new Timer();
        switch (game.level){
            case 1:
                x=100;
                y=10;
                t.scheduleAtFixedRate(diagonal,40,40);
                break;
            case 2:
                t.scheduleAtFixedRate(square,40,40);
                break;
            case 3:
                t.scheduleAtFixedRate(diagonal,40,40);
                break;
        }
    }

    public void update (){
        standardButton();
    }

    public void draw () {
        GL20 gl = Gdx.gl;
        gl.glClearColor(1, 0, 0, 1);
        gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        guiCam.update();
        game.batcher.setProjectionMatrix(guiCam.combined);

        game.batcher.disableBlending();
        game.batcher.begin();
        game.batcher.draw(Assets.backgroundRegion, 0, 0, 1920, 1080);

        game.batcher.end();

        game.batcher.enableBlending();
        game.batcher.begin();
        game.batcher.draw(picture, x , y, 1920, 1080);
        if (visibleLamp) game.batcher.draw(Assets.lamp, 1920-84, 1080-100, 84, 100);
        if (visibleSound) game.batcher.draw(Assets.setting, 1920-100-84, 1080-100, 100, 100);
        game.batcher.end();
    }

    @Override
    public void render (float delta){
        update();
        draw();
    }

    private static void load(){
        diagonal = new TimerTask() {
            @Override
            public void run() {
                time++;
                if (time<=65 || time>=130) x = ++y;
                else  x = --y;
                if (time==200) {
                    x = y = time = 0;
                    t.cancel();
                    game.nextLevel();
                }
            }
        };

        circle = new TimerTask() {
            @Override
            public void run() {
                time++;
                if (time<=20) x-=2;
                else if (time<=40) x+=2;
                else if (time<60) x-=2;
                else if (time == 60) {
                    x = y = time = 0;
                    t.cancel();
                    game.nextLevel();
                }
                y = (int) (pow((400 - (x - 100)*(x - 100)), 0.5) + 30);
                System.out.println(y);
            }
        };

        square = new TimerTask() {
            @Override
            public void run() {
                time++;
                if (time<=60) ++y;
                else if (time<=120) x++;
                else if (time<=180) y--;
                else x--;
                if (time==240) {
                    x = y = time = 0;
                    t.cancel();
                    game.nextLevel();
                }
            }
        };

        diamond = new TimerTask() {
            @Override
            public void run() {}
        };

        pokaz = new TimerTask() {
            @Override
            public void run() {}
        };
    }

    @Override
    public void next(){
        t.cancel();
        game.nextLevel();
    }
}
