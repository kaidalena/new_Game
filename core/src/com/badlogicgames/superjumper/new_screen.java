package com.badlogicgames.superjumper;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

public class new_screen extends ScreenAdapter {

    SuperJumper game;
    MainMenuScreen big;
    OrthographicCamera guiCam;
    Rectangle backBounds;
    Vector3 touchPoint;

    public new_screen(SuperJumper game, MainMenuScreen main){

        this.game = game;
        big = main;
        touchPoint = new Vector3();
        guiCam = new OrthographicCamera(1920, 1080);
        guiCam.position.set(1920 / 2, 1080 / 2, 0);
        backBounds = new Rectangle(1920/2-348/2, 1080/2-345, 348, 345);
    }

    public void update () {
        guiCam.unproject(touchPoint.set(Gdx.input.getX(), Gdx.input.getY(), 0));
        if (Gdx.input.justTouched()) {
            guiCam.unproject(touchPoint.set(Gdx.input.getX(), Gdx.input.getY(), 0));

            if (backBounds.contains(touchPoint.x, touchPoint.y)) {
                game.setScreen(big);
                return;
            }
        }
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
        game.batcher.draw(Assets.back, 1920/2-348/2, 1080/2-345/2, 348, 345);
        game.batcher.end();
    }

    @Override
    public void render (float delta) {
        update();
        draw();
    }

    @Override
    public void pause () {
        Settings.save();

    }

}