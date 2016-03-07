package com.spxscripts;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

/**
 * Created by Sphiinx on 3/5/2016.
 */
public abstract class BackgroundObject {

    public abstract boolean isColliding(Rectangle r);
    public abstract void action(int type, float x, float y);
    public abstract void update(float delta);
    public abstract void setPosition(float x, float y);
    public abstract void draw(SpriteBatch batch);
    public abstract void moveLeft(float delta, int speed);
    public abstract void moveRight(float delta, int speed);
    public abstract int hitAction(int side);
    public abstract Rectangle getHitBox();

}

