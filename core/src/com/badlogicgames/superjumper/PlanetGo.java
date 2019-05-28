package com.badlogicgames.superjumper;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;

public class PlanetGo extends Planets {

    private boolean visibleObject[] = new boolean[count];

    public PlanetGo(SuperGame main, int mainObject, MyObject ... ob){
        super(main, mainObject, ob);
        text = Assets.text1[number];

        for (int k = 0; k<count; k++){
            visibleObject[k] = true;
        }
    }

    public void update () {


        text = Assets.text1[number];
        standardButton();
        zadanieKrater();

        if (Gdx.input.justTouched()) {
            guiCam.unproject(touchPoint.set(Gdx.input.getX(), Gdx.input.getY(), 0));

                if ( object[0].position.contains(touchPoint.x, touchPoint.y) && !visibleObject[2] && !visibleObject[3] && !visibleObject[4]) {
                    visibleObject[0] = false;
                    view();
                }

                if ( object[1].position.contains(touchPoint.x, touchPoint.y) && !visibleObject[0] && !visibleObject[5]) {
                    visibleObject[1] = false;
                    view();
                }

                if (!s && yes.contains(touchPoint.x, touchPoint.y)){
                    if ((number>=0 && number<=4) || number == 6 || number == 8)
                        number++;
                    else if (number == (Assets.text1.length -1)){
                        game.level++;
                        game.nextHistory();
                    }
                    else {
                        s=true;
                        renderer.visible = true;
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
        for (int w=0; w<object.length; w++){
            if (visibleObject[w]) {
                game.batcher.draw(object[w].picture, object[w].position.x, object[w].position.y, object[w].position.width, object[w].position.height);
            }
        }
        standardDrow();
        game.batcher.end();
    }

        public void zadanieKrater (){
        for (int k = 2; k<object.length; k++)
            if (object[k].position.contains(world.getCharacter().getX(), world.getCharacter().getY())) visibleObject[k] = false;
        }

        @Override
    public void next(){
            game.level++;
            game.nextHistory();
        }
}
