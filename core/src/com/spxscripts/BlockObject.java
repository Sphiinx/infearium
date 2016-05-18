package com.spxscripts;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;


/**
 * Created by Sphiinx on 3/4/2016.
 */
public abstract class BlockObject {

    public abstract boolean isColliding(Rectangle r);
    public abstract void action(int type, float x, float y);
    public abstract void update(float delta);
    public abstract void setPosition(float x, float y);
    public abstract float getX();
    public abstract float getY();
    public abstract void draw(SpriteBatch batch);
    public abstract int hitAction(int side);
    public abstract Rectangle getHitBox();

}

