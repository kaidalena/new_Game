package com.badlogicgames.superjumper;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.awt.*;

public class Mini_jimper extends ScreenAdapter {

    public static SuperJumper game;
    MenuScreen_jump one;
    public static Planet_game temp;

    public Mini_jimper (SuperJumper game, Planet_game p){
        this.game=game;
        this.temp = p;
        Settings.load();
        Sets.load();
        one = new MenuScreen_jump(game);
        game.setScreen(one);
    }

    @Override
    public void render (float delta) {
        one.update();
        one.draw();
    }

    public static void ret(){
        Sets.close();
        Assets.run();
        Assets.krater =new TextureRegion(Assets.prozrachniy, 335, 224, 280, 243);
        temp.view();
        game.setScreen(temp);
    }


}
