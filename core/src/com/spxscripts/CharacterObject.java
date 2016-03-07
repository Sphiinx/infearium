package com.spxscripts;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

/**
 * Created by Sphiinx on 3/4/2016.
 */
public abstract class CharacterObject {

    public abstract int isColliding(Rectangle r);
    public abstract int getVelocityX();
    public abstract float getVelocityY();
    public abstract float distanceTo(BlockObject object);
    public abstract void action(int type, float x, float y);
    public abstract void update(float delta);
    public abstract void setPosition(float x, float y);
    public abstract void moveLeft(float delta, int speed);
    public abstract void moveRight(float delta, int speed);
    public abstract void draw(SpriteBatch batch);
    public abstract Rectangle getHitBox();

}

