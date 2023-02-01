package com.zombie_bird.game;


import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.zombie_bird.game.screens.GameScreen;
import com.zombie_bird.game.zbhelpers.AssetLoader;

public class MyGame extends Game {


  @Override
  public void create() {
    Gdx.app.log("ZBGame", "created");
    AssetLoader.load();
    setScreen(new GameScreen());
  }

    @Override
    public void dispose() {
        super.dispose();
        AssetLoader.dispose();
    }
}






//	SpriteBatch batch;
//	Texture img;
//
//	@Override
//	public void create () {
//		batch = new SpriteBatch();
//		img = new Texture("badlogic.jpg");
//	}
//
//	@Override
//	public void render () {
//		ScreenUtils.clear(1, 0, 0, 1);
//		batch.begin();
//		batch.draw(img, 0, 0);
//		batch.end();
//	}
//
//	@Override
//	public void dispose () {
//		batch.dispose();
//		img.dispose();
//	}
