package com.zombie_bird.game.gameworld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Circle;
import com.zombie_bird.game.gameobjects.MyRectangle;

/**
 * Created by Clarence E Moore on 2022-03-22.
 * <p>
 * Description:
 */

public class GameWorld {

    private MyRectangle myRectangle = new MyRectangle(0, 0, 25, 25, Color.BLUE);
    private Circle circle = new Circle(0, 136,6);



    public void update(float delta){
        Gdx.app.log("GameWorld", "update");
        myRectangle.setX(myRectangle.getX() + 1);
        if (myRectangle.getX() > 137) {
            myRectangle.setX(0);
        }

        circle.x= circle.x + 2;
        if (circle.x > 137) {
            circle.x = 0;
        }
    }

    public MyRectangle getRectangle() {
        return myRectangle;
    }

    public Circle getCircle() {

        return circle;
    }

}
