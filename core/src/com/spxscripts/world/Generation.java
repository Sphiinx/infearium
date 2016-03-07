package com.spxscripts.world;


import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.spxscripts.BlockObject;
import com.spxscripts.object.terrain.Dirt;

import java.util.ArrayList;

/**
 * Created by Sphiinx on 3/5/2016.
 */
public class Generation{

    public static ArrayList<BlockObject> blocks = new ArrayList<BlockObject>();

    public Generation() {

    }

    public static void generateMap(int worldSizeX, int worldSizeY) {
        for (int i = -5000; i < worldSizeX; i++) {
            for (int j = 0; j < worldSizeY; j++) {
                blocks.add(new Dirt(i * -16, j * -16));
            }
        }
    }

    public static void drawMap(SpriteBatch batch){
        for (BlockObject object : blocks) {
            object.draw(batch);
        }
    }

}

