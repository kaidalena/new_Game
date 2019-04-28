package com.badlogicgames.superjumper;

import com.badlogic.gdx.InputProcessor;

public class CharacterInput implements InputProcessor {

    private Character myCharacter;

    public CharacterInput(Character rebbit) {
        myCharacter = rebbit;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return true;
    }

    @Override
    public boolean keyDown(int keycode) {
        if ( keycode == 19)
        {
            Assets.character_animation = Assets.character_up_animation;
            myCharacter.press_up();
        }
        else if (keycode == 21)
        {
            Assets.character_animation = Assets.character_left_animation;
            myCharacter.press_left();
        }
        else if (keycode == 22)
        {
            Assets.character_animation = Assets.character_right_animation;
            myCharacter.press_right();
        }
        else if (keycode == 20)
        {
            Assets.character_animation = Assets.character_down_animation;
            myCharacter.press_down();
        }
        else if (keycode == 62)
        {
            myCharacter.press_stop();
        }
//        System.out.println(keycode);
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}