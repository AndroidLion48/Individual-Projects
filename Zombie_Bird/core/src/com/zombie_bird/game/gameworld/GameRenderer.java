package com.zombie_bird.game.gameworld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import static com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType.Filled;
import static com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType.Line;

/**
 * Created by Clarence E Moore on 2022-03-22.
 * <p>
 * Description: Renderer renders the picture
 */

public class GameRenderer {

    private GameWorld gameWorld;
    private OrthographicCamera camera;
    private ShapeRenderer shapeRenderer;

    public GameRenderer(GameWorld World) {
        this.gameWorld = World;

        camera = new OrthographicCamera();
        camera.setToOrtho(true, 136, 204);

        shapeRenderer = new ShapeRenderer();
        shapeRenderer.setProjectionMatrix(camera.combined);

    }

    public void render() {
        Gdx.app.log("GameRenderer", "render");

        // 1. drawing a black background. This prevents flickering.

        Gdx.gl.glClearColor(0,255, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // 2. Drawing the Filled rectangle.

        // Tells shapeRenderer to begin drawing filed shapes.
        shapeRenderer.begin(Filled);

        // Chooses RGB Color of 87, 109, 120 at full opacity.
        shapeRenderer.setColor(87 / 225.0f, 109 / 225.0f, 120 /225.0f, 1);

        // Draws the rectangle from myWorld (Using ShapeType.Filled)
        shapeRenderer.rect(gameWorld.getRectangle().x, gameWorld.getRectangle().y,
                           gameWorld.getRectangle().width, gameWorld.getRectangle().height);

        // Tells the shapeRenderer to finish rendering
        // We MUST do this every time.
        shapeRenderer.end();

        // 3. Drawing the rectangle's outline

        //Tells shapeRenderer to draw an outline of the following shapes.
        shapeRenderer.begin(Line);

        // Chooses RGB Color of 255, 109, 120 at full opacity.
        shapeRenderer.setColor(255 / 255.0f, 109 / 255.0f, 120 / 255.0f, 1);

        // Draws the rectangle from myWorld (Using ShapeType.Line)
        shapeRenderer.rect(gameWorld.getRectangle().x,gameWorld.getRectangle().y, gameWorld.getRectangle().width, gameWorld.getRectangle().height);

        shapeRenderer.end();

        shapeRenderer.begin(Line);
        shapeRenderer.setColor(0 / 255.0f, 0f, 255f, 1);
        shapeRenderer.circle(gameWorld.getCircle().x, gameWorld.getCircle().y, gameWorld.getCircle().radius);

        shapeRenderer.end();
    }
}
