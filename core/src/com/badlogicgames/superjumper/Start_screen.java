package com.badlogicgames.superjumper;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;

import java.util.Timer;
import java.util.TimerTask;

public class Start_screen extends Game_Screen {

    private static int x=270, y=310;
    private static Timer t;

    public Start_screen(SuperJumper main){

        super(main);
        TimerTask p = new TimerTask() {
            @Override
            public void run() {
                x+=2;
                if (x>=960) y--;
                else  y++;
                if (x>=1760) {
                    t.cancel();
                    game.level++;
                    game.next();
                }
            }
        };
        t = new Timer();
        t.scheduleAtFixedRate(p,5,5);
    }

    public void update (){
        Standard_button();
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
        game.batcher.draw(Assets.zvezda, x , 765-471+y, 50, 50);
        game.batcher.draw(Assets.lamp, 1920-84, 1080-100, 84, 100);
        game.batcher.draw(Assets.setting, 1920-100-84, 1080-100, 100, 100);
        game.batcher.draw(Assets.next, 1765, 0, 155, 100);
        game.batcher.end();
    }

    @Override
    public void render (float delta){
        update();
        draw();
    }

    @Override
    public void pause () {
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void show() {
        Gdx.app.log("GameScreen_jump", "show called");
    }

    @Override
    public void hide() {
        Gdx.app.log("GameScreen_jump", "hide called");
    }

    @Override
    public void resume() {
        Gdx.app.log("GameScreen_jump", "resume called");
    }

    @Override
    public void dispose() {
    }
}
