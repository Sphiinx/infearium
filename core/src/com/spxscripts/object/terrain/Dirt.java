package com.spxscripts.object.terrain;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.spxscripts.BlockObject;
import com.spxscripts.data.Vars;

/**
 * Created by Sphiinx on 3/4/2016.
 */
public class Dirt extends BlockObject {

    private Rectangle hitBox;
    private Sprite sprite;
    private int xPosition;
    private int yPosition;

    public Dirt(int x, int y) {
        hitBox = new Rectangle(x, y, Vars.get().blockSize, Vars.get().blockSize);
        sprite = new Sprite(TerrainManager.dirt, 0, 0, Vars.get().blockSize, Vars.get().blockSize);
        setPosition(x, y);
    }

    @Override
    public boolean isColliding(Rectangle r) {
        return false;
    }

    @Override
    public void action(int type, float x, float y) {

    }

    @Override
    public void update(float delta) {

    }

    @Override
    public void setPosition(float x, float y) {
        hitBox.x = x;
        hitBox.y = y;
        sprite.setPosition(x, y);
    }

    @Override
    public float getX() {
        return hitBox.x;
    }

    @Override
    public float getY() {
        return hitBox.y;
    }

    @Override
    public void draw(SpriteBatch batch) {
        sprite.draw(batch);
    }

    @Override
    public int hitAction(int side) {
        return 1;
    }

    @Override
    public Rectangle getHitBox() {
        return hitBox;
    }

}

