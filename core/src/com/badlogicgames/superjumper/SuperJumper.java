
package com.badlogicgames.superjumper;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class SuperJumper extends Game {
	public int level = 0;
	public SpriteBatch batcher;
	public static Game_Screen planeta;


	@Override
	public void create () {
		batcher = new SpriteBatch();
		Assets.load();
		setScreen(new Start_screen(this));
	}

	@Override
	public void render() {
		super.render();
	}

	public void next_level(){
		switch(level){
			case 1:
			case 3:
			case 5:
				setScreen(new Planet_go(this));
				break;
			case 2:
			case 4:
			case 6:
				setScreen(new Planet_game(this));
				break;
		}
	}

	public void next_history(){
		switch(level){
			case 1:
			case 3:
			case 5:
			case 2:
			case 4:
			case 6:
				setScreen(new History(this, Assets.privetstvie, Assets.privet));
				break;
		}
	}
}

