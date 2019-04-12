package com.badlogicgames.superjumper;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;


public class Assets {

	public static Texture background[] = new Texture[7];
	public static TextureRegion backgroundRegion;
	public static Texture bgt;

	public static Texture items;
	public static Texture atlas;
	public static Texture temp;
	public static Texture prozrachniy;
	public static TextureRegion bg;
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


	public static Texture loadTexture (String file) {
		return new Texture(Gdx.files.internal(file));
	}

	public static void load () {
		background[0] = loadTexture("data/4.png");
		background[1] = loadTexture("data/Planeta_1PNG.png");
		background[2] = loadTexture("data/mars.jpg");
		background[3] = loadTexture("data/zemlya.png");
		bgt = loadTexture("data/cvety-roza.jpg");
		bg = new TextureRegion(bgt, 0, 0, 1920, 1080);

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
			character_down[j-1] = new TextureRegion(temp, k, 159, 48, 76);
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
	}
}