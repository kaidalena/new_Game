package com.badlogicgames.superjumper;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class MiniJimper extends ScreenAdapter {

    public static SuperJumper game;
    MenuScreenJump one;
    public static PlanetGame temp;

    public MiniJimper(SuperJumper game, PlanetGame p){
        this.game=game;
        this.temp = p;
        Settings.load();
        Sets.load();
        one = new MenuScreenJump(game);
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
