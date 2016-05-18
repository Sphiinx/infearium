package com.spxscripts.background.Parallax;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.spxscripts.BackgroundObject;
import com.spxscripts.background.BackgroundManager;

/**
 * Created by Sphiinx on 3/6/2016.
 */
public class mountain1 extends BackgroundObject {

    private Sprite sprite;

    public mountain1(float x, float y, float size) {
        sprite = new Sprite(BackgroundManager.mountain1, 0, 0, 1024, 1024);
        sprite.setSize(1024 * size, 1024 * size);
        setPosition(x, y);
    }

    @Override
    public boolean isColliding(Rectangle r) {
        return false;
    }

    @Override
    public void action(int type, float x, float y) {
        setPosition(sprite.getX() - x / 2, sprite.getY());
    }

    @Override
    public void update(float delta) {

    }

    @Override
    public void setPosition(float x, float y) {
        sprite.setPosition(x, y);
    }

    @Override
    public void draw(SpriteBatch batch) {
        sprite.draw(batch);
    }

    @Override
    public void moveLeft(float delta, int speed) {
        setPosition(sprite.getX() - (speed * delta), sprite.getY());
    }

    @Override
    public void moveRight(float delta, int speed) {
        setPosition(sprite.getX() + (speed * delta), sprite.getY());
    }

    @Override
    public int hitAction(int side) {
        return 0;
    }

    @Override
    public Rectangle getHitBox() {
        return null;
    }

}

