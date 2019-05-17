package com.badlogicgames.superjumper;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.math.Rectangle;

public class PlanetGo extends Planets {

    private static Rectangle kraterBounds;
    private static Rectangle schetkaBounds;
    private static Rectangle vedroBounds;
    private static Rectangle gubkaBounds;
    private static Rectangle nogniciBounds;
    private static Rectangle baobabBounds;


    public PlanetGo(SuperJumper main){
        super(main);
        text = Assets.text1[number];
        if (game.level==1){
            kraterBounds = new Rectangle(720, 1080-687-243, 280, 243);
            baobabBounds = new Rectangle(1282, 1080 - 71 - 378, 367, 378);
            schetkaBounds = new Rectangle( 641, 1080 - 393 - 70, 96, 70);
            vedroBounds = new Rectangle( 1248, 1080 - 516 - 99, 76, 99);
            nogniciBounds = new Rectangle( 1193, 1080 - 711 - 54, 99, 54);
            gubkaBounds = new Rectangle( 968, 1080 - 240 - 65, 69, 65);
        }
    }

    public void update () {

        zadanie_krater();
        text = Assets.text1[number];
        Standard_button();

        if (Gdx.input.justTouched()) {
            guiCam.unproject(touchPoint.set(Gdx.input.getX(), Gdx.input.getY(), 0));

            if (game.level == 1) {
                if ( kraterBounds.contains(touchPoint.x, touchPoint.y) && Assets.schetka.getTexture() == Assets.prozrachniy &&
                        Assets.gubka.getTexture() == Assets.prozrachniy && Assets.vedro.getTexture() == Assets.prozrachniy) {
                    Assets.krater.setTexture(Assets.prozrachniy);
                    view();
                }

                if ( baobabBounds.contains(touchPoint.x, touchPoint.y) && Assets.nognici.getTexture() == Assets.prozrachniy
                && Assets.krater.getTexture() == Assets.prozrachniy) {
                    Assets.baobab.setTexture(Assets.prozrachniy);
                    view();
                }

                if (!s && yes.contains(touchPoint.x, touchPoint.y)){
                    if ((number>=0 && number<=4) || number == 6 || number == 8)
                        number++;
                    else if (number == (Assets.text1.length -1)){
                        game.level++;
                        game.next_history();
                    }
                    else {
                        s=true;
                        renderer.visible = true;
                    }
                }
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
            game.batcher.draw(Assets.schetka, 641, 1080 - 393 - 70, 56, 43);
            game.batcher.draw(Assets.vedro, 1248, 1080 - 516 - 99, 76, 99);
            game.batcher.draw(Assets.nognici, 1193, 1080 - 711 - 54, 99, 54);
            game.batcher.draw(Assets.gubka, 968, 1080 - 240 - 67, 71, 67);
        }
        Standard_drow();
        game.batcher.end();
    }

        public void zadanie_krater (){
            if (schetkaBounds.contains(world.getCharacter().getX(), world.getCharacter().getY())){
                Assets.schetka.setTexture(Assets.prozrachniy);
            }
            if (vedroBounds.contains(world.getCharacter().getX(), world.getCharacter().getY())){
                Assets.vedro.setTexture(Assets.prozrachniy);
            }
            if (nogniciBounds.contains(world.getCharacter().getX(), world.getCharacter().getY())){
                Assets.nognici.setTexture(Assets.prozrachniy);
            }
            if (gubkaBounds.contains(world.getCharacter().getX(), world.getCharacter().getY())){
                Assets.gubka.setTexture(Assets.prozrachniy);
            }
        }
}
