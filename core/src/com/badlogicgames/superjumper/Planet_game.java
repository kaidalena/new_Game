package com.badlogicgames.superjumper;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.math.Rectangle;

public class Planet_game extends Planets {

    private static Rectangle tronBounds;

    public Planet_game (SuperJumper main){
        super(main);
        tronBounds = new Rectangle(895, 1080-95-175, 135, 175);
    }

    public void update () {
        text = Assets.text2[number];
        Standard_button();
        if (game.level == 2) {
            if (Gdx.input.justTouched()) {
                guiCam.unproject(touchPoint.set(Gdx.input.getX(), Gdx.input.getY(), 0));
                if (tronBounds.contains(touchPoint.x, touchPoint.y)) {
                    game.setScreen(new Mini_jimper(game, this));
                    Assets.paus();
                }

                if (!s && yes.contains(touchPoint.x, touchPoint.y)){
                    if ((number>=0 && number<=3) ||
                            (number >= 5 && number < 8))
                        number++;
                    else s=true;
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
        Standard_drow();
        game.batcher.end();
    }
}