package com.badlogicgames.superjumper;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.Timer;
import java.util.TimerTask;

public class History extends Game_Screen {
    private static int time=0;
    public static Timer t;
    public static Timer proyavlenie;
    public static TimerTask pokaz;
    public static TimerTask diagonal;
    public static TimerTask circle;
    public static TimerTask square;
    public static TimerTask diamond;
    private static  int x=0, y=0;
    private static TextureRegion picture;


    public History (SuperJumper main, Texture fon, TextureRegion go){
        super(main);
        Assets.backgroundRegion.setTexture(fon);
        picture = go;
        load();
        t = new Timer();
        switch (game.level){
            case 1:
                t.scheduleAtFixedRate(diagonal,40,40);
                break;
            case 2:
                t.scheduleAtFixedRate(square,40,40);
                break;
        }
    }

    public void update (){
        Standard_button();
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
        game.batcher.draw(Assets.lamp, 1920-84, 1080-100, 84, 100);
        game.batcher.draw(Assets.setting, 1920-100-84, 1080-100, 100, 100);
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
                    game.next_level();
                }
            }
        };

        circle = new TimerTask() {
            @Override
            public void run() {}
        };

        square = new TimerTask() {
            @Override
            public void run() {
                time++;
                if (time<=50) ++y;
                else if (time<=100) x++;
                else if (time<=150) y--;
                else x--;
                if (time==200) {
                    x = y = time = 0;
                    t.cancel();
                    game.next_level();
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
}
