
package com.badlogicgames.superjumper;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class SuperGame extends Game {
	public int level = 0;
	public SpriteBatch batcher;


	@Override
	public void create () {
		batcher = new SpriteBatch();
		Assets.load();
		setScreen(new StartScreen(this));
	}

	@Override
	public void render() {
		super.render();
	}

	public void nextLevel(){

		switch(level){
			case 1:
			case 5:
				setScreen(new PlanetGo(this, 6,
						new MyObject(720, 1080-687-243, 280, 243,Assets.krater),
						new MyObject(1282, 1080 - 71 - 378, 367, 378, Assets.baobab),
						new MyObject(641, 1080 - 393 - 70, 96, 70, Assets.schetka),
						new MyObject(1248, 1080 - 516 - 99, 76, 99, Assets.vedro),
						new MyObject(968, 1080 - 240 - 65, 69, 65, Assets.gubka),
						new MyObject(1193, 1080 - 711 - 54, 99, 54, Assets.nognici)));
				break;
			case 3:
			case 2:
			case 4:
			case 6:
				setScreen(new PlanetGame(this, 1,
						new MyObject(895, 1080-95-175, 135, 175, Assets.krater)));
				break;
		}
	}

	public void nextHistory(){
		switch(level){
			case 1:
				setScreen(new History(this, Assets.privetstvie, Assets.hist[0]));
				break;
			case 2:
				setScreen(new History(this, Assets.privetstvie, Assets.hist[1]));
				break;
			case 3:
				setScreen(new History(this, Assets.privetstvie, Assets.hist[2]));
				break;
			case 5:
			case 4:
			case 6:
				setScreen(new History(this, Assets.privetstvie, Assets.hist[1]));
				break;
		}
	}
}

