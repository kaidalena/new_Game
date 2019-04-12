package com.badlogicgames.superjumper;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class CharacterRenderer {
    private CharacterWorld myWorld;
    private SpriteBatch batcher;
    public static int level;

    public CharacterRenderer(CharacterWorld world, SpriteBatch bat) {
        myWorld = world;
        this.batcher = bat;
        level=0;
    }

    public void render(float runTime) {

        Character reb = myWorld.getRebbit();
        if (level>0){
            batcher.begin();
            if ( !reb.stop) batcher.draw((TextureRegion)Assets.character_animation.getKeyFrame(runTime), reb.getX(), reb.getY(), reb.getWidth(), reb.getHeight());
            else batcher.draw(Assets.character_stop, reb.getX(), reb.getY(), reb.getWidth(), reb.getHeight());
            batcher.end();
        }
    }
}
