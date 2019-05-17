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

public class MenuScreenJump extends ScreenAdapter {
	public static SuperJumper game;
	OrthographicCamera guiCam;
	Rectangle soundBounds;
	Rectangle playBounds;
	Rectangle highscoresBounds;
	Rectangle helpBounds;
	Vector3 touchPoint;


	public MenuScreenJump(SuperJumper game) {
		this.game = game;
		this.guiCam = new OrthographicCamera(1920,1080);
		guiCam.position.set(1920 / 2, 1080 / 2, 0);
		soundBounds = new Rectangle(0+600, 0+300, 64, 64);
		playBounds = new Rectangle(160 - 150+600, 200 + 18+600, 300, 36);
		highscoresBounds = new Rectangle(160 - 150+600, 200 - 18+500, 300, 36);
		helpBounds = new Rectangle(160 - 150+600, 200 - 18 - 36+400, 300, 36);
		touchPoint = new Vector3();
	}

	public void update () {
		if (Gdx.input.justTouched()) {
			guiCam.unproject(touchPoint.set(Gdx.input.getX(), Gdx.input.getY(), 0));

			if (playBounds.contains(touchPoint.x, touchPoint.y)) {
				Sets.playSound(Sets.clickSound);
				game.setScreen(new GameScreenJump(game));
				return;
			}
			if (highscoresBounds.contains(touchPoint.x, touchPoint.y)) {
				Sets.playSound(Sets.clickSound);
				game.setScreen(new HighscoresScreen(game));
				return;
			}
			if (helpBounds.contains(touchPoint.x, touchPoint.y)) {
				Sets.playSound(Sets.clickSound);
				game.setScreen(new HelpScreen(game));
				return;
			}
			if (soundBounds.contains(touchPoint.x, touchPoint.y)) {
				Sets.playSound(Sets.clickSound);
				Settings.soundEnabled = !Settings.soundEnabled;
				if (Settings.soundEnabled)
					Sets.music.play();
				else
					Sets.music.pause();
			}
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
		game.batcher.draw(Sets.backgroundRegion, 0, 0, 1920, 1080);
		game.batcher.end();

		game.batcher.enableBlending();
		game.batcher.begin();
		game.batcher.draw(Sets.logo, 160 - 274 / 2 + 600, 480 - 10 - 142 + 600, 274, 142);
		game.batcher.draw(Sets.mainMenu, 10 + 600 , 200 - 110 / 2 +600, 300, 110);
		game.batcher.draw(Settings.soundEnabled ? Sets.soundOn : Sets.soundOff, 0+600, 0+300, 64, 64);
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
