package com.badlogicgames.superjumper;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;

public class PlanetGame extends Planets {

    public PlanetGame(SuperGame main, int mainObject, MyObject ... ob){
        super(main,mainObject,ob);
    }

    public void update () {
        text = Assets.text2[number];
        standardButton();
        if (game.level == 2) {
            if (Gdx.input.justTouched()) {
                guiCam.unproject(touchPoint.set(Gdx.input.getX(), Gdx.input.getY(), 0));
                if (object[0].position.contains(touchPoint.x, touchPoint.y) && !s) {
                    game.setScreen(new MiniJimper(game, this));
                    Assets.paus();
                }

                if (!s && yes.contains(touchPoint.x, touchPoint.y)){
                    if ((number>=0 && number<=3) ||
                            (number >= 5 && number < 8))
                        number++;
                    else if (number == 8){
                        game.level++;
                        game.nextHistory();
                    }
                    else {
                        s=true;
                        renderer.visible = true;
                    }
                }
            }
        }
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
        standardDrow();
        game.batcher.end();
    }

    @Override
    public void next(){
        game.level++;
        game.nextHistory();
    }
}