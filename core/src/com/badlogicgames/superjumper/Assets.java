package com.badlogicgames.superjumper;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;


public class Assets {

	public static Texture background[] = new Texture[7];
	public static TextureRegion backgroundRegion;

	public static Texture items;
	public static Texture atlas;
	public static Texture temp;
	public static Texture prozrachniy;
	public static TextureRegion mainMenu;
	public static TextureRegion setting;
	public static TextureRegion lamp;
	public static TextureRegion holst;
	public static TextureRegion next;
	public static TextureRegion baobab;
	public static TextureRegion krater;
	public static TextureRegion back;
	public static TextureRegion rebbit_go[] = new TextureRegion[8];
	public static TextureRegion rebbit_stop;
	public static TextureRegion character_stop;
	public static TextureRegion character_left[] = new TextureRegion[8];
	public static TextureRegion character_right[] = new TextureRegion[8];
	public static TextureRegion character_up[] = new TextureRegion[8];
	public static TextureRegion character_down[] = new TextureRegion[8];
	public static Animation rebbit_go_Animation;
	public static Animation character_left_animation;
	public static Animation character_right_animation;
	public static Animation character_up_animation;
	public static Animation character_down_animation;
	public static Animation character_animation;

	public static TextureRegion pauseMenu;
	public static TextureRegion ready;
	public static TextureRegion gameOver;
	public static TextureRegion highScoresRegion;
	public static TextureRegion logo;
	public static TextureRegion soundOn;
	public static TextureRegion soundOff;
	public static TextureRegion arrow;
	public static TextureRegion pause;
	public static TextureRegion spring;
	public static TextureRegion castle;
	public static Animation_ coinAnim;
	public static Animation_ bobJump;
	public static Animation_ bobFall;
	public static TextureRegion bobHit;
	public static Animation_ squirrelFly;
	public static TextureRegion platform;
	public static Animation_ brakingPlatform;
	public static BitmapFont font;

	public static Music music;
	public static Sound jumpSound;
	public static Sound highJumpSound;
	public static Sound hitSound;
	public static Sound coinSound;
	public static Sound clickSound;

	public static Texture loadTexture (String file) {
		return new Texture(Gdx.files.internal(file));
	}

	public static void load () {
		background[0] = loadTexture("data/4.png");
		background[1] = loadTexture("data/Planeta_1PNG.png");
		background[2] = loadTexture("data/mars.jpg");
		background[3] = loadTexture("data/zemlya.png");

		backgroundRegion = new TextureRegion(background[0], 0, 0, 1920, 1080);

		items = loadTexture("data/items.png");
		atlas = loadTexture("data/Atlas.png");
		temp = loadTexture("data/girl.png");
		prozrachniy = loadTexture("data/prozrach.png");


		setting = new TextureRegion(prozrachniy, 1724, 0, 100, 100);
		lamp = new TextureRegion(prozrachniy, 1824, 0, 84, 100);
		holst = new TextureRegion(prozrachniy, 580, 1080-280, 800, 280);
		next = new TextureRegion(prozrachniy, 1765, 980, 155, 100);
		baobab = new TextureRegion(atlas, 9, 207, 309, 367);
		krater = new TextureRegion(atlas, 335, 224, 280, 243);
		back = new TextureRegion(new Texture("data/back.png"), 0, 0, 348, 345);
		int k = 0;
		for (int j=1; j<=8; j++) {
			character_right[j-1] = new TextureRegion(temp, k, 77, 48, 77);
			character_down[j-1] = new TextureRegion(temp, k, 159, 48, 77);
			character_up[j-1]= new TextureRegion(temp, k, 237, 48, 77);
			character_left[j-1] = new TextureRegion(temp, k, 77, 48, 77);
			k+=48;
		}
		for (int r =0; r<8; r++) character_left[r].flip(true, false);
		character_stop = new TextureRegion(temp, 0, 159, 48, 77);
		character_down_animation = new Animation(0.08f, character_down);
		character_down_animation.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);
		character_right_animation = new Animation(0.08f, character_right);
		character_right_animation.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);
		character_up_animation = new Animation(0.08f, character_up);
		character_up_animation.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);
		character_left_animation = new Animation(0.08f, character_left);
		character_left_animation.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);
		int x=0;
		for (int i=1; i<=8; i++) {
			rebbit_go[i-1] = new TextureRegion(atlas, x, 0, 180, 200);
			x+=180;
		}
		rebbit_stop  = new TextureRegion(atlas, 0, 0, 180, 200);
		rebbit_go_Animation = new Animation(0.08f, rebbit_go);
		rebbit_go_Animation.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);

		mainMenu = new TextureRegion(items, 0, 224, 300, 110);
		pauseMenu = new TextureRegion(items, 224, 128, 192, 96);
		ready = new TextureRegion(items, 320, 224, 192, 32);
		gameOver = new TextureRegion(items, 352, 256, 160, 96);
		highScoresRegion = new TextureRegion(Assets.items, 0, 257, 300, 110 / 3);
		logo = new TextureRegion(items, 0, 352, 274, 142);
		soundOff = new TextureRegion(items, 0, 0, 64, 64);
		soundOn = new TextureRegion(atlas, 240, 203, 188, 221);
		arrow = new TextureRegion(items, 0, 64, 64, 64);
		pause = new TextureRegion(items, 64, 64, 64, 64);

		spring = new TextureRegion(items, 128, 0, 32, 32);
		castle = new TextureRegion(items, 128, 64, 64, 64);
		coinAnim = new Animation_(0.2f, new TextureRegion(items, 128, 32, 32, 32), new TextureRegion(items, 160, 32, 32, 32),
				new TextureRegion(items, 192, 32, 32, 32), new TextureRegion(items, 160, 32, 32, 32));
		bobJump = new Animation_(0.2f, new TextureRegion(items, 0, 128, 32, 32), new TextureRegion(items, 32, 128, 32, 32));
		bobFall = new Animation_(0.2f, new TextureRegion(items, 64, 128, 32, 32), new TextureRegion(items, 96, 128, 32, 32));
		bobHit = new TextureRegion(items, 128, 128, 32, 32);
		squirrelFly = new Animation_(0.2f, new TextureRegion(items, 0, 160, 32, 32), new TextureRegion(items, 32, 160, 32, 32));
		platform = new TextureRegion(items, 64, 160, 64, 16);
		brakingPlatform = new Animation_(0.2f, new TextureRegion(items, 64, 160, 64, 16), new TextureRegion(items, 64, 176, 64, 16),
				new TextureRegion(items, 64, 192, 64, 16), new TextureRegion(items, 64, 208, 64, 16));

		font = new BitmapFont(Gdx.files.internal("data/font.fnt"), Gdx.files.internal("data/font.png"), false);
	}


	public static void playSound (Sound sound) {
		if (Settings.soundEnabled) sound.play(1);
	}
}