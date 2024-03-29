package com.zombie_bird.game.gameworld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.zombie_bird.game.gameobjects.Bird;
import com.zombie_bird.game.zbhelpers.AssetLoader;

import static com.zombie_bird.game.zbhelpers.AssetLoader.*;

/**
 * Created by Clarence E Moore on 2022-03-22.
 * <p>
 * Description: Renderer renders the picture
 */

public class GameRenderer {

    private GameWorld gameWorld;
    private OrthographicCamera camera;
    private ShapeRenderer shapeRenderer;

    private SpriteBatch batcher;

    private int midPointY;
    private int gameHeight;

    //Game objects
    private Bird bird;

    //Game Assets
    private TextureRegion bg, grass;
    private Animation birdAnimation;
    private TextureRegion birdMid, birdDown, birdUp;
    private TextureRegion skullUp, skullDown, bar;

    public GameRenderer(GameWorld world, int gameHeight, int midPointY) {
        gameWorld = world;

        this.gameHeight = gameHeight;
        this.midPointY = midPointY;

        camera = new OrthographicCamera();
        camera.setToOrtho(true, 136, gameHeight);

        batcher = new SpriteBatch();
        batcher.setProjectionMatrix(camera.combined);

        shapeRenderer = new ShapeRenderer();
        shapeRenderer.setProjectionMatrix(camera.combined);

        initGameObjects();
        initAssets();
    }
    public void render(float runTime, float delta){

        Bird bird = gameWorld.getBird();

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        shapeRenderer.begin(ShapeType.Filled);

        //Draw Background color
        shapeRenderer.setColor(55 / 255.0f, 80 / 255.0f, 100 / 255.0f, 1);
        shapeRenderer.rect(0, 0, 136,midPointY + 66);

        // Draw Grass
        shapeRenderer.setColor(111 / 255.0f, 186 / 225.0f, 45 / 255.0f, 1);
        shapeRenderer.rect(0, midPointY + 66,136, 11);

        //Draw Dirt
        shapeRenderer.setColor(111 / 255.0f,186 / 255.0f, 45 / 255.0f, 1);
        shapeRenderer.rect(0, midPointY + 77, 136, 52);

        shapeRenderer.end();

        batcher.begin();
        batcher.disableBlending();
        batcher.draw(bg, 0, midPointY + 23, 136, 43);

        batcher.enableBlending();

        //Draw bird at its coordinates. Retrieve the Naimation object from
        //AssetLoader
        //Pass in the runTime Variable to get the current frame.
        batcher.draw((TextureRegion) AssetLoader.birdAnimation.getKeyFrame(runTime), bird.getX(), bird.getY(), bird.getWidth(), bird.getHeight());

        if (bird.shouldntFlap()) {
            batcher.draw(birdMid, bird.getX(), bird.getY(),
                         bird.getWidth() / 2.0f, bird.getHeight() / 2.0f,
                         bird.getWidth(), bird.getHeight(), 1, 1, bird.getRotation());

        } else {
            batcher.draw((TextureRegion) birdAnimation.getKeyFrame(runTime), bird.getX(),
                         bird.getY(), bird.getWidth() / 2.0f,
                         bird.getHeight() / 2.0f, bird.getWidth(), bird.getHeight(),
                         1, 1, bird.getRotation());
        }

        batcher.end();

    }
    private void initGameObjects(){
        bird = gameWorld.getBird();
    }

    private void initAssets(){
        bg = AssetLoader.bg;
        grass = AssetLoader.grass;
        birdAnimation = AssetLoader.birdAnimation;
        birdMid = AssetLoader.bird;
        birdDown = AssetLoader.birdDown;
        birdUp = AssetLoader.birdUp;
        skullUp = AssetLoader.skullUp;
        skullDown = AssetLoader.skullDown;
        bar = AssetLoader.bar;
    }
}
