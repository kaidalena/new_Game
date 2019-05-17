//package com.badlogicgames.superjumper;
//
//import com.badlogic.gdx.Gdx;
//import com.badlogic.gdx.ScreenAdapter;
//import com.badlogic.gdx.graphics.GL20;
//import com.badlogic.gdx.graphics.OrthographicCamera;
//import com.badlogic.gdx.graphics.g2d.TextureRegion;
//import com.badlogic.gdx.math.Rectangle;
//import com.badlogic.gdx.math.Vector3;
//
//import java.util.Timer;
//import java.util.TimerTask;
//
//public class MainMenuScreen_my extends ScreenAdapter {
//	public static SuperJumper game;
//	public static OrthographicCamera guiCam;
//	public static TextureRegion text;
//	Rectangle settingBounds;
//	Rectangle zvez;
//	Rectangle lampBounds;
//	Rectangle holstBounds;
//	Rectangle nextBounds;
//	Rectangle kraterBounds;
//	Vector3 touchPoint;
//	public static int level=0, x=270, r=0;
//	public static int y = 310;
//	private CharacterWorld world;
//	private CharacterRenderer renderer;
//	private float runTime;
//	private static Timer t;
//	private static Timer k;
//	boolean g=false;
//	boolean s = true;
//
//	public MainMenuScreen_my(SuperJumper game) {
//
//		this.game = game;
//		guiCam = new OrthographicCamera(1920, 1080);
////		System.out.println(guiCam.position.x + " " + guiCam.position.y);
//		guiCam.position.set(1920/2, 1080/2, 0);
//
//		settingBounds = new Rectangle(1920-100-84, 1080-100, 100, 100);
//		lampBounds = new Rectangle(1920-84, 1080-100, 84, 100);
//		holstBounds = new Rectangle(580, 0, 800, 280);
//		nextBounds = new Rectangle(1765, 0, 155, 100);
//		kraterBounds = new Rectangle(720, 1080-687-243, 280, 243);
//		zvez = new Rectangle(0, 0, 20, 20);
//		touchPoint = new Vector3();
//		world = new CharacterWorld(100);
//		renderer = new CharacterRenderer(world, game.batcher);
//
//		TimerTask p = new TimerTask() {
//			@Override
//			public void run() {
//				x+=2;
//				if (x>=960) y--;
//				else  y++;
//				if (x>=1760){
//					x=y=0;
////					CharacterRenderer.level++;
//					if(level<6)
//					{
//						Assets.backgroundRegion.setTexture(Assets.background[++level]);
//						Assets.page.play();
//					}
//				}
//			}
//		};
////		TimerTask w = new TimerTask() {
////			@Override
////			public void run() {
////					if (level==1) {
////						r++;
////						Assets.backgroundRegion = new TextureRegion(Assets.background[1], 1920 / 2 - (int) 1.92 * r, 1080 / 2 - (int) 1.08 * r, 1920 / 2 + (int) 1.92 * r, 1080 / 2 + (int) 1.08 * r);
////						if (r == 100) g = true;
////					}
////			}
////		};
//		t = new Timer();
//		t.scheduleAtFixedRate(p,5,5);
////
////		k = new Timer();
////		k.scheduleAtFixedRate(w,5,5);
//
//		Gdx.input.setInputProcessor(new CharacterInput(world.getCharacter()));
//	}
//
//
//	public void update () {
//		if (level>0) t.cancel();
//
//		guiCam.unproject(touchPoint.set(Gdx.input.getX(), Gdx.input.getY(), 0));
//
//		if (settingBounds.contains(touchPoint.x, touchPoint.y)) Assets.setting.setTexture(Assets.atlas);
//		else Assets.setting.setTexture(Assets.prozrachniy);
//
//		if (lampBounds.contains(touchPoint.x, touchPoint.y)) Assets.lamp.setTexture(Assets.atlas);
//		else Assets.lamp.setTexture(Assets.prozrachniy);
//
//		if (holstBounds.contains(touchPoint.x, touchPoint.y) || !s)
//		{
//			Assets.holst.setTexture(Assets.atlas);
//			if (s) Assets.text = Assets.dobro_pog;
//		}
//		else {
//			Assets.holst.setTexture(Assets.prozrachniy);
//			Assets.text=Assets.proz;
//		}
//
//
//		if (nextBounds.contains(touchPoint.x, touchPoint.y)) Assets.next.setTexture(Assets.atlas);
//		else Assets.next.setTexture(Assets.prozrachniy);
//
//		if (Gdx.input.justTouched()) {
//			guiCam.unproject(touchPoint.set(Gdx.input.getX(), Gdx.input.getY(), 0));
//
//
//            if (settingBounds.contains(touchPoint.x, touchPoint.y)) {
//                if (Assets.music.isPlaying()) Assets.music.pause();
//                else Assets.music.play();
//            }
//
//			if (nextBounds.contains(touchPoint.x, touchPoint.y)) {
////				CharacterRenderer.level++;
//				if(level<6)
//				{
//					Assets.backgroundRegion.setTexture(Assets.background[++level]);
//					Assets.page.play();
//				}
//				return;
//			}
//
//			if (kraterBounds.contains(touchPoint.x, touchPoint.y)) {
//				if(level>0 && level<6) {
////					game.setScreen(new MiniJimper(game, this));
//					Assets.paus();
//				}
////					game.setScreen(new new_screen((game), this));
//				return;
//			}
//		}
//	}
//
//
//	public void draw () {
//
////		if (g==true) {
////			k.cancel();
////			Assets.backgroundRegion = new TextureRegion(Assets.background[0], 0, 0, 1920, 1080);
////		}
//
//		GL20 gl = Gdx.gl;
//		gl.glClearColor(1, 0, 0, 1);
//		gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
//		guiCam.update();
//		game.batcher.setProjectionMatrix(guiCam.combined);
//
//		game.batcher.disableBlending();
//		game.batcher.begin();
////		if (g==true || level!=1) game.batcher.draw(Assets.backgroundRegion, 0, 0, 1920, 1080);
//		game.batcher.draw(Assets.backgroundRegion, 0, 0, 1920, 1080);
//		game.batcher.end();
//
//		game.batcher.enableBlending();
//		game.batcher.begin();
//		if (level==0) {
//			game.batcher.draw(Assets.zvezda, x , 765-471+y, 50, 50);
//		}
//		if (level==1) {
////			game.batcher.draw(Assets.ppp, 0 , 0, 1920, 1080);
//
//			game.batcher.draw(Assets.baobab, 1347 , 1080-103-367, 309, 367);
//			game.batcher.draw(Assets.krater, 720, 1080-687-243, 280, 243);
//		}
//
//		if (level>0){
//			game.batcher.draw(Assets.lamp, 1920-84, 1080-100, 84, 100);
//			game.batcher.draw(Assets.holst, 580, 0, 800, 280);
//			game.batcher.draw(Assets.text, 705 , 1080-870-92, 600, 92);
//		}
//
//		game.batcher.draw(Assets.setting, 1920-100-84, 1080-100, 100, 100);
//		game.batcher.draw(Assets.next, 1765, 0, 155, 100);
//
//		game.batcher.end();
//
//	}
//
//	@Override
//	public void render (float delta) {
//		update();
//		draw();
//		runTime += delta;
//		world.update(delta);
//		renderer.render(runTime);
//	}
//
//
//	@Override
//	public void pause () {
//	}
//
//	@Override
//	public void resize(int width, int height) {
//
//	}
//
//	@Override
//	public void show() {
//		Gdx.app.log("GameScreenJump", "show called");
//	}
//
//	@Override
//	public void hide() {
//		Gdx.app.log("GameScreenJump", "hide called");
//	}
//
//	@Override
//	public void resume() {
//		Gdx.app.log("GameScreenJump", "resume called");
//	}
//
//	@Override
//	public void dispose() {
//	}
//
//	public void view (){
//		s=false;
//		Assets.holst.setTexture(Assets.atlas);
//		Assets.text = Assets.pozdrav;
//		System.out.println("two");
//		Timer w = new Timer();
//		TimerTask two = new TimerTask() {
//			@Override
//			public void run() {
//				Assets.holst.setTexture(Assets.prozrachniy);
//				Assets.text.setTexture(Assets.prozrachniy);
//				System.out.println("tree");
//				s=true;
//				w.cancel();
//			}
//		};
//		w.scheduleAtFixedRate(two,4000,4000);
//	}
//
//}