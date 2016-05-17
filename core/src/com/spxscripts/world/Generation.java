package com.spxscripts.world;


import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.spxscripts.BackgroundObject;
import com.spxscripts.BlockObject;
import com.spxscripts.background.Parallax.Mountain1;
import com.spxscripts.background.Parallax.Pine1;
import com.spxscripts.background.Parallax.Sky;
import com.spxscripts.object.terrain.Dirt;
import com.spxscripts.object.terrain.Grass;
import com.spxscripts.object.terrain.Stone;
import com.spxscripts.api.util.SimplexNoise;

import java.util.ArrayList;

/**
 * Created by Sphiinx on 3/5/2016.
 */
public class Generation{

    public ArrayList<BlockObject> blocks = new ArrayList<BlockObject>();
    private ArrayList<BackgroundObject> parallax = new ArrayList<BackgroundObject>();
    public SimplexNoise noiseGen;
    public long seed = System.currentTimeMillis();

    public Generation() {

    }

    public void generateBlocks(int leftGenerationStart, int worldSizeX, int worldSizeY, int blockSize) {
        noiseGen = new SimplexNoise(seed);

        for (int i = leftGenerationStart; i < worldSizeX + leftGenerationStart; i+= blockSize) {
            for (int j = 0; j > worldSizeY; j-= blockSize) {
                int noise = (int) noiseGen.eval(i * 0.15f, -1 * 0.15f);
                System.out.println(noise);
                if (j < -128) {
                    blocks.add(new Stone(i, j));
                } else if (j <= -16) {
                    blocks.add(new Dirt(i, j));
                } else {
                    blocks.add(new Grass(i, j));
                }

            }
        }
        System.out.println("Blocks in game: " + blocks.size());
    }

    public void generateParallax(int leftGenerationStart, int x, int y, int parallaxSize) {
        for (int i = leftGenerationStart; i < x + leftGenerationStart; i+= parallaxSize) {
            parallax.add(new Mountain1(i, y, 2));
            parallax.add(new Pine1(i, y, 2));
        }
    }

    public void generateSky(int leftGenerationStart, int x, int y, int parallaxSize) {
        for (int i = leftGenerationStart; i < x + leftGenerationStart; i+= parallaxSize) {
            parallax.add(new Sky(i, y, 1));
        }
    }

    public void drawBlocks(SpriteBatch batch){
        for (BlockObject object : blocks) {
            object.draw(batch);
        }
    }

    public void drawParallax(SpriteBatch batch){
        for (BackgroundObject object : parallax) {
            object.draw(batch);
        }
    }

    public void drawSky(SpriteBatch batch){
        for (BackgroundObject object : parallax) {
            object.draw(batch);
        }
    }

}

