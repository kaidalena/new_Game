package com.badlogicgames.superjumper;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;

public class CharacterWorld {
    private Character rebbit;
    private Character girl;

    public CharacterWorld (int midPointY) {
//        rebbit = new Character(1920/2-180/2, 1080/2 - 200/2, 180, 200);
        girl = new Character(980, 570, 70, 100);
    }

    public void update(float delta) {
//        rebbit.update(delta);
        girl.update(delta);
    }

    public Character getCharacter() {
//        return rebbit;
        return girl;
    }
}
