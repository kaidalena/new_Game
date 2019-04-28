package com.badlogicgames.superjumper;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

public abstract class Game_Screen extends ScreenAdapter {
    public static SuperJumper game;
    public static OrthographicCamera guiCam;
    public static Rectangle settingBounds;
    public static Rectangle lampBounds;
    public static Vector3 touchPoint;

    public Game_Screen(SuperJumper main){
        this.game = main;
        Assets.backgroundRegion.setTexture(Assets.background[game.level]);
        guiCam = new OrthographicCamera(1920, 1080);
        guiCam.position.set(1920/2, 1080/2, 0);
        settingBounds = new Rectangle(1920-100-84, 1080-100, 100, 100);
        lampBounds = new Rectangle(1920-84, 1080-100, 84, 100);
        touchPoint = new Vector3();
    }

    public abstract void update ();
    public abstract void draw ();

    @Override
    public void render (float delta){
        update();
        draw();
    }

    public void Standard_button() {
        guiCam.unproject(touchPoint.set(Gdx.input.getX(), Gdx.input.getY(), 0));

        if (settingBounds.contains(touchPoint.x, touchPoint.y)) Assets.setting.setTexture(Assets.atlas);
        else Assets.setting.setTexture(Assets.prozrachniy);

        if (lampBounds.contains(touchPoint.x, touchPoint.y)) Assets.lamp.setTexture(Assets.atlas);
        else Assets.lamp.setTexture(Assets.prozrachniy);

        if (Gdx.input.justTouched()) {
            guiCam.unproject(touchPoint.set(Gdx.input.getX(), Gdx.input.getY(), 0));

            if (settingBounds.contains(touchPoint.x, touchPoint.y)) {
                if (Assets.music.isPlaying()) Assets.music.pause();
                else Assets.music.play();
            }
        }
    }
}
