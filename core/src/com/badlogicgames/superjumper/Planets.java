package com.badlogicgames.superjumper;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

public abstract class Planets extends Game_Screen {

    public static Rectangle nextBounds;
//    public static Rectangle holstBounds;
    public static CharacterWorld world;
    public static CharacterRenderer renderer;
    public static  float runTime;
    public static boolean s = true;
    public static boolean lamp = false;
    public  static TextureRegion text;
    public static int number = 0, x = 0, y = 0, width = 0, height = 0;

    public Planets(SuperJumper main){
        super(main);
//        holstBounds = new Rectangle(580, 0, 800, 280);
        nextBounds = new Rectangle(1765, 0, 155, 100);
    }

    public abstract void update ();
    public abstract void draw ();

    @Override
    public void render (float delta){
        update();
        draw();
        runTime += delta;
        world.update(delta);
        renderer.render(runTime);
    }

    @Override
    public void pause () {
    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void show() {
        Gdx.app.log("GameScreen_jump", "show called");
    }

    @Override
    public void hide() {
        Gdx.app.log("GameScreen_jump", "hide called");
    }

    @Override
    public void resume() {
        Gdx.app.log("GameScreen_jump", "resume called");
    }

    @Override
    public void dispose() {
    }

    @Override
    public void Standard_button() {
        guiCam.unproject(touchPoint.set(Gdx.input.getX(), Gdx.input.getY(), 0));

        if (settingBounds.contains(touchPoint.x, touchPoint.y)) Assets.setting.setTexture(Assets.atlas);
        else Assets.setting.setTexture(Assets.prozrachniy);

        if (lampBounds.contains(touchPoint.x, touchPoint.y)) {
            lamp = true;
            Assets.lamp.setTexture(Assets.atlas);
        }
        else {
            lamp = false;
            Assets.lamp.setTexture(Assets.prozrachniy);
        }

//        if (nextBounds.contains(touchPoint.x, touchPoint.y)) Assets.next.setTexture(Assets.atlas);
//        else Assets.next.setTexture(Assets.prozrachniy);

//        if (holstBounds.contains(touchPoint.x, touchPoint.y) || !s) {
//            Assets.holst.setTexture(Assets.atlas);
//            if (s) Assets.text = Assets.dobro_pog;
//        } else {
//            Assets.holst.setTexture(Assets.prozrachniy);
//            Assets.text = Assets.proz;
//        }

        if (Gdx.input.justTouched()) {
            guiCam.unproject(touchPoint.set(Gdx.input.getX(), Gdx.input.getY(), 0));

            if (settingBounds.contains(touchPoint.x, touchPoint.y)) {
                if (Assets.music.isPlaying()) Assets.music.pause();
                else Assets.music.play();
            }

            if (nextBounds.contains(touchPoint.x, touchPoint.y)) {
                game.level++;
                game.next_history();
            }
        }
    }

        public void drow_text(){
            game.batcher.draw(text, 1920/2-972/2, 1080/2-400/2, 973, 401);
            switch(number){
                case 3:
                    game.batcher.draw(Assets.next, 1803, 1080-130-112, 100, 130);
                    game.batcher.draw(Assets.character_stop, 500, 0, 350, 557);
                    break;
                case 4:
                    game.batcher.draw(Assets.next, 1690, 1080-130-112, 100, 130);
                    game.batcher.draw(Assets.character_stop, 225, 280, 350, 557);
                    break;
                case 0:
                case 1:
                case 5:
                case 9:
                case 10:
                    game.batcher.draw(Assets.character_stop, 215, 0, 350, 557);
                    break;
                default:
                    game.batcher.draw(Assets.character_stop, 1115, 0, 350, 557);
                    break;
            }
        }

}
