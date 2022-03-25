package com.zombie_bird.game.gameworld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Circle;

import java.awt.Rectangle;

/**
 * Created by Clarence E Moore on 2022-03-22.
 * <p>
 * Description:
 */

public class GameWorld {

    private Rectangle rectangle = new Rectangle(0, 0, 17, 12);
    private Circle circle = new Circle(0, 136,6);



    public void update(float delta){
        Gdx.app.log("GameWorld", "update");
        rectangle.x++;
        if (rectangle.x > 137) {
            rectangle.x = 0;
        }
        circle.x= circle.x + 2;
        if (circle.x > 137) {
            circle.x = 0;
        }
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    public Circle getCircle() {

        return circle;
    }

}
