package com.badlogicgames.superjumper;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;

import java.util.Timer;
import java.util.TimerTask;

import static java.lang.Math.pow;

public class StartScreen extends GameScreen {

    private static int x=1650, y=360, y_ = 0,  i=0;
    private static int x_= 0 ;
    private static boolean line = false, parab = true;
    private static Timer t;
    private int h =0;

    public StartScreen(SuperGame main){

        super(main);
        TimerTask p = new TimerTask() {
            @Override
            public void run() {
                if (parab) {
                    x-=3;
                    y = (int) (-0.0005 * pow((x - 960), 2) + 1000);
                    if (i == 13) i=0; else i++;
                    if (x <= 270) {
                        parab = false;
                        line = true;
                        i=14;
                    }
                }
                else if (line) {
                    x_++;
                    if (x_%7==0) x++;
                    y = ((x - 270) * (-586 / 20) + 761);
                    if (y <= 175) {line = false; x_=0; i=0;}
                    if (i == 27) i=14; else i++;
                }
                else if (x_==45){
                    t.cancel();
                    game.level++;
                    game.nextHistory();
                }
                else {x_++; if (i==27) i = 14; else i++;}

            }
        };
        t = new Timer();
        t.scheduleAtFixedRate(p,5,15);
    }

    public void update (){
        standardButton();
        if (h == 9) h=0;
    }

    public void draw (){
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
        game.batcher.draw(Assets.buterfly[i], x , y, 70, 65);
        if (visibleLamp) game.batcher.draw(Assets.lamp, 1920-84, 1080-100, 84, 100);
        if (visibleSound) game.batcher.draw(Assets.setting, 1920-100-84, 1080-100, 100, 100);
        game.batcher.end();
    }

    @Override
    public void render (float delta){
        update();
        draw();
    }

    @Override
    public void next(){
        t.cancel();
        game.level++;
        game.nextHistory();
    }
}
