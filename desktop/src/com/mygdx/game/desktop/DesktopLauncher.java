package com.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogicgames.superjumper.SuperGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Game";
		config.height = 1080;
		config.width = 1920;
		config.fullscreen=true;
		new LwjglApplication(new SuperGame(), config);
	}
}
