package com.badlogicgames.superjumper;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;


public class Assets {

	public static Texture background[] = new Texture[7];
	public static Texture history[] = new Texture[7];
	public static Texture privetstvie;
	public static TextureRegion backgroundRegion;
	public static Texture atlas;
	public static Texture temp;
	public static Texture zvez;
	public static Texture pppz;
	public static Texture text2_;
	public static Texture text_;
	public static Texture but;
	public static TextureRegion hist[] = new TextureRegion[7];
	public static TextureRegion text1[] = new TextureRegion[10];
    public static TextureRegion text2[] = new TextureRegion[11];
	public static TextureRegion podskaz;
	public static TextureRegion nognici;
	public static TextureRegion gubka;
	public static TextureRegion ppp;
	public static TextureRegion vedro;
	public static TextureRegion schetka;
	public static TextureRegion setting;
	public static TextureRegion lamp;
	public static TextureRegion next;
	public static TextureRegion baobab;
	public static TextureRegion krater;
	public static TextureRegion buterfly[] = new TextureRegion[28];
	public static TextureRegion character;
	public static TextureRegion character_stop;
	public static TextureRegion character_left[] = new TextureRegion[5];
	public static TextureRegion character_right[] = new TextureRegion[5];
	public static TextureRegion character_up[] = new TextureRegion[5];
	public static TextureRegion character_down[] = new TextureRegion[5];
	public static Animation character_left_animation;
	public static Animation character_right_animation;
	public static Animation character_up_animation;
	public static Animation character_down_animation;
	public static Animation character_animation;
	public static Music music;
	public static Sound page;

	private static int number = 0, x = 0, y = 0, width = 973, height = 401;

	public static Texture loadTexture (String file) {
		return new Texture(Gdx.files.internal(file));
	}

	public static void load () {
		background[0] = loadTexture("data/4_.png");
		background[1] = loadTexture("data/Planeta_1PNG.png");
		background[2] = loadTexture("data/korol.png");
		background[3] = loadTexture("data/честолюбец.png");
		background[4] = loadTexture("data/planped.png");
		background[5] = loadTexture("data/stpl.png");
		background[6] = loadTexture("data/planpn.png");
		history[0] = loadTexture("data/приветствие.png");
		history[1] = loadTexture("data/история2.png");
		history[2] = loadTexture("data/история3.png");
		hist[0] = new TextureRegion(history[0], 0, 0, 3840,2160);
		hist[1] = new TextureRegion(history[1], 0, 0, 1544, 866);
		hist[2] = new TextureRegion(history[2], 0, 0, 1920, 1080);

		privetstvie = loadTexture("data/ajy.jpg");
		text_ = loadTexture("data/Слова1.png");
		but = loadTexture("data/butterfly.png");
		atlas = loadTexture("data/Atlas.png");
		temp = loadTexture("data/sprayt.png");
		zvez = loadTexture("data/zvezda.png");
		pppz = loadTexture("data/nebo.jpg");
		text2_ = loadTexture("data/Слова2.png");

		for (int i =0; i<10; i++){
			if (x % 2919 == 0 && x != 0) {
				x = 0;
				y += 401;
			}
			text1[i] = new TextureRegion(text_, x, y, width, height);
			x+= 973;
		}

        x = y =0;
		for (int i = 0; i<9; i++){
		    text2[i] = new TextureRegion(text2_, x, y, 1460, 699);
		    if(x==0)  x = 1460;
		    else {
		        x=0;
		        y+=699;
            }
        }
		text2[9] = new TextureRegion(text2_,1684, 2957, 330, 375);
        text2[10] = new TextureRegion(text2_,2014, 2938, 325, 439);

		podskaz = new TextureRegion(atlas, 1204, 245,693, 538);

		x = y =0;
		for (int i=0; i<28; i++) {
			if (i == 14) {
				x=0;
				y = 65;
			}
			buterfly[i] = new TextureRegion(but, x,y,70,65);
			if (i<14) buterfly[i].flip(true, false);
			x+=70;
		}

		backgroundRegion = new TextureRegion(background[0], 0, 0, 1920, 1080);
		nognici = new TextureRegion(atlas, 786, 388, 99, 54);
		gubka = new TextureRegion(atlas, 776, 290, 71, 67);
		vedro = new TextureRegion(atlas, 679, 344, 76, 99);
		schetka = new TextureRegion(atlas, 688, 282, 56, 43);
		ppp = new TextureRegion(pppz, 0,0,1920,1080);
		setting = new TextureRegion(atlas, 1724, 0, 100, 100);
		lamp = new TextureRegion(atlas, 1824, 0, 84, 100);
		next = new TextureRegion(atlas, 1690, 112, 100, 130);
		baobab = new TextureRegion(atlas, 0, 207, 367, 378);
		krater = new TextureRegion(atlas, 355, 230, 280, 243);
		int k = 0;
		for (int j=1; j<=5; j++) {
			character_right[j-1] = new TextureRegion(temp, k, 305, 147, 305);
			character_down[j-1] = new TextureRegion(temp, k, 610, 147, 305);
			character_up[j-1]= new TextureRegion(temp, k, 915, 147, 305);
			character_left[j-1] = new TextureRegion(temp, k, 305, 147, 305);
			k+=147;
		}
		for (int r =0; r<5; r++) character_left[r].flip(true, false);
		character= new TextureRegion(loadTexture("data/1.png"), 0, 0, 2480, 3508);
		character_stop = new TextureRegion(temp, 147, 0, 147, 305);
		character_down_animation = new Animation(0.08f, character_down);
		character_down_animation.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);
		character_right_animation = new Animation(0.08f, character_right);
		character_right_animation.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);
		character_up_animation = new Animation(0.08f, character_up);
		character_up_animation.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);
		character_left_animation = new Animation(0.08f, character_left);
		character_left_animation.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);


		music = Gdx.audio.newMusic(Gdx.files.internal("data/music.mp3"));
		music.play();
		music.setVolume(0.1f);
		music.setLooping(true);

		page = Gdx.audio.newSound(Gdx.files.internal("data/page.mp3"));
	}

	public static void paus (){
		music.stop();
		page.stop();
	}

	public static void run (){
		music.play();
		page.play(1);
	}
}