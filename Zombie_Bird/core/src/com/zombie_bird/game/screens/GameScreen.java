package com.zombie_bird.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.zombie_bird.game.gameworld.GameRenderer;
import com.zombie_bird.game.gameworld.GameWorld;
import com.zombie_bird.game.zbhelpers.InputHandler;

/**
 * Created by Clarence E Moore on 2022-03-22.
 * <p>
 * Description:
 */

public class GameScreen implements Screen {

    private GameWorld gameWorld;
    private GameRenderer gameRenderer;
    private float runTime;


    //This is the constructor, not this class declaration
    public GameScreen() {
        Gdx.app.log("GameScreen", "Attached");

        float screenWidth = Gdx.graphics.getWidth();
        float screenHeigth = Gdx.graphics.getHeight();
        float gameWidth = 136;
        float gameHeight = screenHeigth / (screenWidth / gameWidth);

        int midPointY = (int) (gameHeight / 2);

        gameWorld = new GameWorld(midPointY);
        gameRenderer = new GameRenderer(gameWorld, (int) gameHeight, midPointY);

        Gdx.input.setInputProcessor(new InputHandler(gameWorld.getBird()));

    }

    @Override
    public void render(float delta) {
        // Sets a Color to Fill the Screen With (RGB = 10, 15, 230), Opacity of 1 (100%)
        Gdx.gl.glClearColor(10/255.0f, 15/255.0f, 230/255.0f, 1f);
        // Fills the screen with the selected color
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        // Covert Frame rate to String, print it
        //Gdx.app.log("GameScreen FPS", (1/delta) + "");
        //Passing in delta to our update method so we can perform fram-rate independent movement
        runTime += delta;
        gameWorld.update(delta);
        gameRenderer.setShapeRenderer(runTime);

    }

    @Override
    public void show() { Gdx.app.log("GameScreen", "show called");}

    @Override
    public void resize(int width, int height) {
        Gdx.app.log("GameScreen", "resizing");
    }

    @Override
    public void pause() {
        Gdx.app.log("GameScreen", "pause called");
    }

    @Override
    public void resume() {
        Gdx.app.log("GameScreen", "resume called");
    }

    @Override
    public void hide() {
        Gdx.app.log("GameScreen", "hide called");
    }

    @Override
    public void dispose() {
        // Left blank on purpose
    }
}
