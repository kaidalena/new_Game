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

import com.badlogic.gdx.Application.ApplicationType;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogicgames.superjumper.WorldJump.WorldListener;

public class GameScreenJump extends ScreenAdapter {
	static final int GAME_READY = 0;
	static final int GAME_RUNNING = 1;
	static final int GAME_PAUSED = 2;
	static final int GAME_LEVEL_END = 3;
	static final int GAME_OVER = 4;

	SuperJumper game;

	int state;
	OrthographicCamera guiCam;
	Vector3 touchPoint;
	WorldJump world;
	WorldListener worldListener;
	WorldRendererJump renderer;
	Rectangle pauseBounds;
	Rectangle resumeBounds;
	Rectangle quitBounds;
	int lastScore;
	String scoreString;

	GlyphLayout glyphLayout = new GlyphLayout();

	public GameScreenJump(SuperJumper game) {
		this.game = game;

		state = GAME_READY;
		guiCam = new OrthographicCamera(320, 480);
		guiCam.position.set(320 / 2, 480 / 2, 0);
		touchPoint = new Vector3();
		worldListener = new WorldListener() {
			@Override
			public void jump () {
				Sets.playSound(Sets.jumpSound);
			}

			@Override
			public void highJump () {
				Sets.playSound(Sets.highJumpSound);
			}

			@Override
			public void hit () {
				Sets.playSound(Sets.hitSound);
			}

			@Override
			public void coin () {
				Sets.playSound(Sets.coinSound);
			}
		};
		world = new WorldJump(worldListener);
		renderer = new WorldRendererJump(game.batcher, world);
		pauseBounds = new Rectangle(320 - 64, 480 - 64, 64, 64);
		resumeBounds = new Rectangle(160 - 96, 240, 192, 36);
		quitBounds = new Rectangle(160 - 96, 240 - 36, 192, 36);
		lastScore = 0;
		scoreString = "SCORE: 0";
	}

	public void update (float deltaTime) {
		if (deltaTime > 0.1f) deltaTime = 0.1f;

		switch (state) {
		case GAME_READY:
			updateReady();
			break;
		case GAME_RUNNING:
			updateRunning(deltaTime);
			break;
		case GAME_PAUSED:
			updatePaused();
			break;
		case GAME_LEVEL_END:
			updateLevelEnd();
			break;
		case GAME_OVER:
			updateGameOver();
			break;
		}
	}

	private void updateReady () {
		if (Gdx.input.justTouched()) {
			state = GAME_RUNNING;
		}
	}

	private void updateRunning (float deltaTime) {
		if (Gdx.input.justTouched()) {
			guiCam.unproject(touchPoint.set(Gdx.input.getX(), Gdx.input.getY(), 0));

			if (pauseBounds.contains(touchPoint.x, touchPoint.y)) {
				Sets.playSound(Sets.clickSound);
				state = GAME_PAUSED;
				return;
			}
		}
		
		ApplicationType appType = Gdx.app.getType();
		
		// should work also with Gdx.input.isPeripheralAvailable(Peripheral.Accelerometer)
		if (appType == ApplicationType.Android || appType == ApplicationType.iOS) {
			world.update(deltaTime, Gdx.input.getAccelerometerX());
		} else {
			float accel = 0;
			if (Gdx.input.isKeyPressed(Keys.DPAD_LEFT)) accel = 5f;
			if (Gdx.input.isKeyPressed(Keys.DPAD_RIGHT)) accel = -5f;
			world.update(deltaTime, accel);
		}
		if (world.score != lastScore) {
			lastScore = world.score;
			scoreString = "SCORE: " + lastScore;
		}
		if (world.state == WorldJump.WORLD_STATE_NEXT_LEVEL) {
			game.setScreen(new WinScreen(game));
		}
		if (world.state == WorldJump.WORLD_STATE_GAME_OVER) {
			state = GAME_OVER;
			if (lastScore >= Settings.highscores[4])
				scoreString = "NEW HIGHSCORE: " + lastScore;
			else
				scoreString = "SCORE: " + lastScore;
			Settings.addScore(lastScore);
			Settings.save();
		}
	}

	private void updatePaused () {
		if (Gdx.input.justTouched()) {
			guiCam.unproject(touchPoint.set(Gdx.input.getX(), Gdx.input.getY(), 0));

			if (resumeBounds.contains(touchPoint.x, touchPoint.y)) {
				Sets.playSound(Sets.clickSound);
				state = GAME_RUNNING;
				return;
			}

			if (quitBounds.contains(touchPoint.x, touchPoint.y)) {
				Sets.playSound(Sets.clickSound);
				game.setScreen(new MenuScreenJump(game));
				return;
			}
		}
	}

	private void updateLevelEnd () {
		if (Gdx.input.justTouched()) {
			world = new WorldJump(worldListener);
			renderer = new WorldRendererJump(game.batcher, world);
			world.score = lastScore;
			state = GAME_READY;
		}
	}

	private void updateGameOver () {
		if (Gdx.input.justTouched()) {
			game.setScreen(new MenuScreenJump(game));
		}
	}

	public void draw () {
		GL20 gl = Gdx.gl;
		gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		renderer.render();

		guiCam.update();
		game.batcher.setProjectionMatrix(guiCam.combined);
		game.batcher.enableBlending();
		game.batcher.begin();
		switch (state) {
		case GAME_READY:
			presentReady();
			break;
		case GAME_RUNNING:
			presentRunning();
			break;
		case GAME_PAUSED:
			presentPaused();
			break;
		case GAME_LEVEL_END:
			presentLevelEnd();
			break;
		case GAME_OVER:
			presentGameOver();
			break;
		}
		game.batcher.end();
	}

	private void presentReady () {
		game.batcher.draw(Sets.ready, 160 - 192 / 2, 240 - 32 / 2, 192, 32);
	}

	private void presentRunning () {
		game.batcher.draw(Sets.pause, 320 - 64, 480 - 64, 64, 64);
		Sets.font.draw(game.batcher, scoreString, 16, 480 - 20);
	}

	private void presentPaused () {
		game.batcher.draw(Sets.pauseMenu, 160 - 192 / 2, 240 - 96 / 2, 192, 96);
		Sets.font.draw(game.batcher, scoreString, 16, 480 - 20);
	}

	private void presentLevelEnd () {
		glyphLayout.setText(Sets.font, "the princess is ...");
		Sets.font.draw(game.batcher, glyphLayout, 160 - glyphLayout.width / 2, 480 - 40);
		glyphLayout.setText(Sets.font, "in another castle!");
		Sets.font.draw(game.batcher, glyphLayout, 160 - glyphLayout.width / 2, 40);
	}

	private void presentGameOver () {
		game.batcher.draw(Sets.gameOver, 160 - 160 / 2, 240 - 96 / 2, 160, 96);
		glyphLayout.setText(Sets.font, scoreString);
		Sets.font.draw(game.batcher, scoreString, 160 - glyphLayout.width / 2, 480 - 20);
	}

	@Override
	public void render (float delta) {
		update(delta);
		draw();
	}

	@Override
	public void pause () {
		if (state == GAME_RUNNING) state = GAME_PAUSED;
	}
}