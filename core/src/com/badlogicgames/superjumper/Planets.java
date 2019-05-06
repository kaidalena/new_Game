package com.badlogicgames.superjumper;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

public abstract class Planets extends Game_Screen {

    public static Rectangle nextBounds;
    public static Rectangle yes;
    public static CharacterWorld world;
    public static CharacterRenderer renderer;
    public static float runTime;
    public static boolean s = true;
    public static boolean lamp = false;
    public static TextureRegion text;
    public static int number = 0, x = 0, y = 0, width = 0, height = 0;

    public Planets(SuperJumper main) {
        super(main);
        number = 0;
        nextBounds = new Rectangle(1765, 0, 155, 100);
        yes = new Rectangle(1920/2-500/2, 1080/2-400/2, 500, 400);
        s = false;
        world = new CharacterWorld(100);
        renderer = new CharacterRenderer(world, game.batcher);
        Gdx.input.setInputProcessor(new CharacterInput(world.getCharacter()));
    }

    public abstract void update();

    public abstract void draw();

    @Override
    public void render(float delta) {
        update();
        draw();
        runTime += delta;
        world.update(delta);
        renderer.render(runTime);
    }

    @Override
    public void pause() {
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
        } else {
            lamp = false;
            Assets.lamp.setTexture(Assets.prozrachniy);
        }

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

    public void Standard_drow(){
        game.batcher.draw(Assets.lamp, 1920-84, 1080-100, 84, 100);
        game.batcher.draw(Assets.setting, 1920-100-84, 1080-100, 100, 100);
        if (lamp) {
            game.batcher.draw(Assets.podskaz, 1920 - 693, 1080 - 540, 693, 538);
            game.batcher.draw(text, 1275, 1080 -247- 141, 600, 247);
        }
        if (!s) drow_text();
    }

    public void view() {
        number++;
        s = false;
    }

    public void drow_text() {
        switch (game.level) {
            case 1:
                drow_text_1();
                break;
            case 2:
                drow_text_2();
                break;
            case 3:
            case 4:
            case 5:
        }
    }

    public void drow_text_1() {
        game.batcher.draw(text, 1920 / 2 - 972 / 2, 1080 / 2 - 400 / 2, 973, 401);
        switch (number) {
            case 3:
                game.batcher.draw(Assets.next, 1803, 1080 - 130 - 112, 100, 130);
                game.batcher.draw(Assets.rebbit_stop, 500, 0, 350, 520);
                break;
            case 4:
                game.batcher.draw(Assets.next, 1690, 1080 - 130 - 112, 100, 130);
                game.batcher.draw(Assets.rebbit_stop, 225, 280, 350, 520);
                break;
            case 0:
            case 1:
            case 5:
            case 9:
            case 10:
                game.batcher.draw(Assets.rebbit_stop, 225, 0, 350, 520);
                break;
            default:
                game.batcher.draw(Assets.rebbit_stop, 1115, 0, 350, 520);
                break;
        }
    }

    public void drow_text_2() {
        game.batcher.draw(text, 1920 / 2 - 1460 / 2, 1080 / 2 - 700 / 2, 1460, 699);
        game.batcher.draw(Assets.text2[10], 100, 100, 325, 439);
        game.batcher.draw(Assets.text2[9], 1920-100-375, 100, 330, 375);
    }
}
