package com.badlogicgames.superjumper;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

import java.util.Timer;
import java.util.TimerTask;

public class Planet_go extends Planets {

    private static Rectangle kraterBounds;
    private static Rectangle yes;
    private static Timer w;


    public Planet_go (SuperJumper main){
        super(main);
        text = Assets.text[number];
        if (game.level==1){
            kraterBounds = new Rectangle(720, 1080-687-243, 280, 243);
            yes = new Rectangle(1920/2-500/2, 1080/2-400/2, 500, 400);
        }
        s = false;
        world = new CharacterWorld(100);
        renderer = new CharacterRenderer(world, game.batcher);
        Gdx.input.setInputProcessor(new CharacterInput(world.getCharacter()));
    }

    public void update () {
        text = Assets.text[number];
        Standard_button();

        if (Gdx.input.justTouched()) {
            guiCam.unproject(touchPoint.set(Gdx.input.getX(), Gdx.input.getY(), 0));

//            установка для превой планеты
            if (game.level == 1) {
                if ( kraterBounds.contains(touchPoint.x, touchPoint.y) && s) {
                    game.setScreen(new Mini_jimper(game, this));
                    Assets.paus();
                }
                if (!s && yes.contains(touchPoint.x, touchPoint.y)){
                    if ((number>=0 && number<=4) ||
                            number == 6 || number == 8)
                        number++;
                    else s=true;
                }
            }

//            установка для третьей планеты
            if (game.level == 3) {
            }

//            установка для пятой планеты
            if (game.level == 5) {
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
        if (game.level == 1) {
            game.batcher.draw(Assets.baobab, 1282, 1080 - 71 - 378, 367, 378);
            game.batcher.draw(Assets.krater, 720, 1080 - 687 - 243, 280, 243);
        }
        game.batcher.draw(Assets.lamp, 1920 - 84, 1080 - 100, 84, 100);
        game.batcher.draw(Assets.setting, 1920 - 100 - 84, 1080 - 100, 100, 100);
        if (lamp) {
            game.batcher.draw(Assets.podskaz, 1920 - 693, 1080 - 540, 693, 538);
            game.batcher.draw(text, 1275, 1080 -247- 141, 600, 247);
        }
        if (!s) drow_text();
        game.batcher.end();
    }

        public void view() {
            number++;
            s = false;
//            Assets.holst.setTexture(Assets.atlas);
//            Assets.text = Assets.pozdrav;
//
//            TimerTask two = new TimerTask() {
//                @Override
//                public void run() {
//                    Assets.holst.setTexture(Assets.prozrachniy);
//                    Assets.text.setTexture(Assets.prozrachniy);
//                    s=true;
//                    w.cancel();
//                }
//            };
//            w = new Timer();
//            w.scheduleAtFixedRate(two,4000,4000);
        }


}
