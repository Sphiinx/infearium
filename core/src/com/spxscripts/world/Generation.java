package com.spxscripts.world;


import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.spxscripts.BlockObject;
import com.spxscripts.object.terrain.Dirt;
import com.spxscripts.object.terrain.Empty;
import com.spxscripts.object.terrain.Grass;
import com.spxscripts.object.terrain.Stone;
import com.spxscripts.util.SimplexNoise;

import java.util.ArrayList;

/**
 * Created by Sphiinx on 3/5/2016.
 */
public class Generation{

    public ArrayList<BlockObject> blocks = new ArrayList<BlockObject>();
    public SimplexNoise noiseGen;
    public long seed = System.currentTimeMillis();

    public Generation() {

    }

    public void generateMap(int worldSizeX, int worldSizeY) {
        noiseGen = new SimplexNoise(seed);
        float hillCoeff = 8f;
        float terrainLimit = hillCoeff + (worldSizeY / 8);
        int dirtLimit = Math.round(hillCoeff + (worldSizeY / 8));
        int caveStart = dirtLimit - (worldSizeY / 32);

        for (int i = 0; i < worldSizeX; i++) {
            float noise = (float) noiseGen.eval(i * 0.15f, -1 * 0.15f);
            int actualHeight = Math.round(noise * hillCoeff);

            int topOfDirt = actualHeight + (worldSizeY / 16);
            int endOfDirt = actualHeight + (worldSizeY / 8);
            for (int y = endOfDirt; y >= topOfDirt; y--) {
                blocks.add(new Dirt(i, y));
            }
            blocks.add(new Grass(i, actualHeight + (worldSizeY / 16)));

            for (int y = endOfDirt; y < worldSizeY; y++) {
                blocks.add(new Stone(i, y));
            }

            for (int y = caveStart - Math.round(4 * noise) - 6; y <caveStart + Math.round(3 * noise) + 3; y++) {
                blocks.add(new Empty(i, y));
            }
        }

        float caveStartThreshold = 0.56f;
        float caveEndThreshold = 0.825f;
        for (int x = 0; x < worldSizeX; x++) {
            for (int y = caveStart; y < worldSizeY; y++) {
                float noise = (float) noiseGen.eval(x * 0.1f, y * 0.1f);
                noise = (noise + 1) / 2f;
                if (noise >= caveStartThreshold && noise <= caveEndThreshold) {
                    blocks.add(new Empty(x, y));
                }
            }
         }

    }

    public void drawMap(SpriteBatch batch){
        for (BlockObject object : blocks) {
            object.draw(batch);
        }
    }

}

