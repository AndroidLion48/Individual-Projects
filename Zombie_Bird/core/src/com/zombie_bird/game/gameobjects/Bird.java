package com.zombie_bird.game.gameobjects;

import com.badlogic.gdx.math.Vector2;

/**
 * Created by Clarence E Moore on 2022-04-05.
 * <p>
 * Description:
 */

public class Bird {

    private Vector2 position; // position of the bird in the game
    private Vector2 velocity; // velocity of the bird movement in the game
    private Vector2 acceleration; // acceleration of the bird movement in the game

    private float rotation; // For handling bird rotation
    private int width; // Determines the width of the bird
    private int height; // Determines the height of the bird

    public Bird(float x, float y,int width, int height,) {

        this.width = width;
        this.height = height;
        position = new Vector2(x, y);
        velocity = new Vector2(0, 0);
        acceleration = new Vector2(0, 460);
    }

    public void update(float delta) {

        velocity.add(acceleration.cpy().scl(delta));

        if (velocity.y > 200) {
            velocity.y = 200;
        }
        position.add(velocity.cpy().scl(delta));
    }

    public void onClick(){
        velocity.y = -140;
    }

    public float getX() {
        return position.x;
    }

    public float getY() {
        return position.y;
    }

    public float getRotation() {

        return rotation;
    }

    public float getWidth() {

        return width;
    }

    public float getHeight() {

        return height;
    }
}
