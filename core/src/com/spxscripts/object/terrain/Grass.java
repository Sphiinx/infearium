package com.spxscripts.object.terrain;


import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.spxscripts.BlockObject;

/**
 * Created by Sphiinx on 3/7/2016.
 */
public class Grass extends BlockObject{

    private Rectangle hitBox;
    private Sprite sprite;
    private int xPosition;
    private int yPosition;

    public Grass(int x, int y) {
        hitBox = new Rectangle(x, y, 16, 16);
        sprite = new Sprite(TerrainManager.grass, 0, 0, 16, 16);
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

