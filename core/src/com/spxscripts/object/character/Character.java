package com.spxscripts.object.character;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.spxscripts.BlockObject;
import com.spxscripts.CharacterObject;

/**
 * Created by Sphiinx on 3/4/2016.
 */
public class Character extends CharacterObject {

    private Rectangle bottom, left, right, top, full;
    private Sprite sprite;
    private int velocityX = 150;
    private float velocityY = 0;

    public Character() {
        full = new Rectangle(0, 0, 64, 64);
        bottom = new Rectangle(0, 0, 64, 8);
        left = new Rectangle(0, 8, 32, 48);
        right = new Rectangle(32, 8, 32, 48);
        top = new Rectangle(0, 56, 64, 8);

        sprite = new Sprite(CharacterManager.character, 0, 0, 64, 64);
        this.setPosition(0, 0);
    }

    private boolean landed;

    @Override
    public int isColliding(Rectangle r) {
        if (bottom.overlaps(r)) {
            landed = true;
            return 1;
        }
        if (left.overlaps(r)) {
            return 2;
        }
        if (right.overlaps(r)) {
            return 3;
        }
        if (top.overlaps(r)) {
            return 4;
        }
        return -1;
    }

    @Override
    public double distanceTo(float x2, float y2) {
        return Math.sqrt(Math.pow((x2 - getX()), 2) + Math.pow((y2 - getY()), 2));
    }

    @Override
    public Rectangle getHitBox() {
        return bottom;
    }

    public void action(int type, float x, float y) {
        if (type == 1 || type == 4) {
            velocityY = 0;
            setPosition(bottom.x, y);
        }
        if (type == 2 || type == 3) {
            velocityY = 0;
            setPosition(x, bottom.y);
        }
    }

    public void update(float delta) {
        velocityY -= 15 * delta;
        bottom.y += velocityY;
        setPosition(bottom.x, bottom.y);
    }

    public void setPosition(float x, float y) {
        full.x = x;
        full.y = y;

        bottom.x = x;
        bottom.y = y;

        left.x = x;
        left.y = y + 8;

        right.x = x + 32;
        right.y = y + 8;

        top.x = x;
        top.y = y + 56;

        sprite.setPosition(x, y);
    }

    @Override
    public float getX() {
        return getHitBox().getX();
    }

    @Override
    public float getY() {
        return getHitBox().getY();
    }

    public void jump() {
        if (landed) {
            landed = false;
            velocityY = 6;
        }

    }

    public void moveLeft(float delta, int speed) {
        setPosition(full.x - (speed * delta), full.y);
    }

    public void moveRight(float delta, int speed) {
        setPosition(full.x + (speed * delta), full.y);
    }

    public void draw(SpriteBatch batch) {
        sprite.draw(batch);
    }

    @Override
    public int getVelocityX() {
        return velocityX;
    }

    @Override
    public float getVelocityY() {
        return velocityY;
    }

}

