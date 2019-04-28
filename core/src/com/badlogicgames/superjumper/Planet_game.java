package com.badlogicgames.superjumper;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;

public class Planet_game extends Planets {

    public Planet_game (SuperJumper main){
        super(main);
    }

    public void update (){
        Standard_button();
    };

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
        if (game.level == 1){
            game.batcher.draw(Assets.baobab, 1347 , 1080-103-367, 309, 367);
            game.batcher.draw(Assets.krater, 720, 1080-687-243, 280, 243);
        }
        game.batcher.draw(Assets.lamp, 1920-84, 1080-100, 84, 100);
        game.batcher.draw(Assets.holst, 580, 0, 800, 280);
        game.batcher.draw(Assets.text, 705 , 1080-870-92, 600, 92);
        game.batcher.draw(Assets.setting, 1920-100-84, 1080-100, 100, 100);
        game.batcher.draw(Assets.next, 1765, 0, 155, 100);
        game.batcher.end();
    }
}