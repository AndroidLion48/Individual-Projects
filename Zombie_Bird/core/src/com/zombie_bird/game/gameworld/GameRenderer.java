package com.zombie_bird.game.gameworld;

import com.badlogic.gdx.Gdx;

/**
 * Created by Clarence E Moore on 2022-03-22.
 * <p>
 * Description:
 */

public class GameRenderer {
    private GameWorld gameWorld;

    public GameRenderer(GameWorld World) {
        this.gameWorld = World;


    }

    public void render(){

        Gdx.app.log("GameRenderer", "render");
    }
}
