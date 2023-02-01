package com.zombie_bird.game.gameworld;

import com.zombie_bird.game.gameobjects.Bird;

/**
 * Created by Clarence E Moore on 2022-03-22.
 * <p>
 * Description:
 */

public class GameWorld {

    private final Bird bird;
    private GameRenderer gameRenderer;

    public GameWorld(int midPointY) {
        // Initializing bird here
        bird = new Bird(33, midPointY -5, 17, 12);
    }

    public void update(float delta) {
        bird.update(delta);
    }

    public Bird getBird() {
        return bird;
    }

    public void setRender(GameRenderer gameRenderer) {
        this.gameRenderer = gameRenderer;

    }
}
