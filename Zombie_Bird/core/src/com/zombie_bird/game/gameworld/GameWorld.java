package com.zombie_bird.game.gameworld;

import com.zombie_bird.game.gameobjects.Bird;

/**
 * Created by Clarence E Moore on 2022-03-22.
 * <p>
 * Description:
 */

public class GameWorld {

    private Bird bird;

    public GameWorld(int midPointY) {
        // Initilizing bird here
        bird = new Bird(33, midPointY -5, 17, 12);
    }

    public void update(float delta) {
        bird.update(delta);
    }

    public Bird getBird() {
        return bird;
    }
}
