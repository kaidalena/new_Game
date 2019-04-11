/*******************************************************************************
 * Copyright 2011 See AUTHORS file.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/

package com.badlogicgames.superjumper;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

public class MainMenuScreen extends ScreenAdapter {
	SuperJumper game;
	OrthographicCamera guiCam;
	Rectangle settingBounds;
	Rectangle lampBounds;
	Rectangle holstBounds;
	Rectangle nextBounds;
	Rectangle kraterBounds;
//	Rectangle soundBounds;
//	Rectangle playBounds;
//	Rectangle highscoresBounds;
//	Rectangle helpBounds;
	Vector3 touchPoint;
	int i=0;

	public MainMenuScreen (SuperJumper game) {
		this.game = game;

		guiCam = new OrthographicCamera(1920, 1080);
		System.out.println(guiCam.position.x + " " + guiCam.position.y);
		guiCam.position.set(1920/2, 1080/2, 0);

		settingBounds = new Rectangle(1920-100-84, 1080-100, 100, 100);
		lampBounds = new Rectangle(1920-84, 1080-100, 84, 100);
		holstBounds = new Rectangle(580, 0, 800, 280);
		nextBounds = new Rectangle(1765, 0, 155, 100);
		kraterBounds = new Rectangle(720, 1080-687-243, 280, 243);
//		soundBounds = new Rectangle(0, 0, 64, 64);
//		playBounds = new Rectangle(160 - 150, 200 + 18, 300, 36);
//		highscoresBounds = new Rectangle(160 - 150, 200 - 18, 300, 36);
//		helpBounds = new Rectangle(160 - 150, 200 - 18 - 36, 300, 36);
		touchPoint = new Vector3();
	}

	public void update () {
		guiCam.unproject(touchPoint.set(Gdx.input.getX(), Gdx.input.getY(), 0));

		if (settingBounds.contains(touchPoint.x, touchPoint.y)) Assets.setting.setTexture(Assets.atlas);
		else Assets.setting.setTexture(Assets.prozrachniy);

		if (lampBounds.contains(touchPoint.x, touchPoint.y)) Assets.lamp.setTexture(Assets.atlas);
		else Assets.lamp.setTexture(Assets.prozrachniy);

		if (holstBounds.contains(touchPoint.x, touchPoint.y)) Assets.holst.setTexture(Assets.atlas);
		else Assets.holst.setTexture(Assets.prozrachniy);

		if (nextBounds.contains(touchPoint.x, touchPoint.y)) Assets.next.setTexture(Assets.atlas);
		else Assets.next.setTexture(Assets.prozrachniy);

		if (Gdx.input.justTouched()) {
			guiCam.unproject(touchPoint.set(Gdx.input.getX(), Gdx.input.getY(), 0));

			if (nextBounds.contains(touchPoint.x, touchPoint.y)) {
//				game.setScreen(new GameScreen(game));
				Assets.backgroundRegion.setTexture(Assets.background[++i]);
				return;
			}

			if (kraterBounds.contains(touchPoint.x, touchPoint.y)) {
//				game.setScreen(new GameScreen(game));
				game.setScreen(new new_screen(game, this));
				return;
			}
//			if (highscoresBounds.contains(touchPoint.x, touchPoint.y)) {
//				Assets.playSound(Assets.clickSound);
//				game.setScreen(new HighscoresScreen(game));
//				return;
//			}
//			if (helpBounds.contains(touchPoint.x, touchPoint.y)) {
//				Assets.playSound(Assets.clickSound);
//				game.setScreen(new HelpScreen(game));
//				return;
//			}
//			if (soundBounds.contains(touchPoint.x, touchPoint.y)) {
//				Assets.playSound(Assets.clickSound);
//				Settings.soundEnabled = !Settings.soundEnabled;
//				if (Settings.soundEnabled)
//					Assets.music.play();
//				else
//					Assets.music.pause();
//			}
		}
	}

	public void draw () {
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
		if (i==1) {
			game.batcher.draw(Assets.baobab, 1347, 1080-103-367, 309, 367);
			game.batcher.draw(Assets.krater, 720, 1080-687-243, 280, 243);
		}
		if (i>0){
			game.batcher.draw(Assets.lamp, 1920-84, 1080-100, 84, 100);
			game.batcher.draw(Assets.holst, 580, 0, 800, 280);
		}
		game.batcher.draw(Assets.setting, 1920-100-84, 1080-100, 100, 100);
		game.batcher.draw(Assets.next, 1765, 0, 155, 100);

		game.batcher.end();
	}

	@Override
	public void render (float delta) {
		update();
		draw();
	}

	@Override
	public void pause () {
		Settings.save();
	}
}
