package com.badlogicgames.superjumper;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class CharacterRenderer {
    private CharacterWorld myWorld;
    private SpriteBatch batcher;
    public boolean visible;

    public CharacterRenderer(CharacterWorld world, SpriteBatch bat) {
        myWorld = world;
        this.batcher = bat;
        visible = false;
    }

    public void render(float runTime) {
        Character reb = myWorld.getCharacter();
            batcher.begin();
            if ( !reb.stop && visible) {
                batcher.draw((TextureRegion) Assets.character_animation.getKeyFrame(runTime), reb.getX(), reb.getY(), reb.getWidth(), reb.getHeight());
            }
            else if (PlanetGo.s && visible){
                batcher.draw(Assets.character_stop, reb.getX(), reb.getY(), reb.getWidth(), reb.getHeight());
            }
            batcher.end();
        }

}
