package com.spxscripts.world;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.spxscripts.BackgroundObject;
import com.spxscripts.BlockObject;
import com.spxscripts.background.Parallax.mountain1;
import com.spxscripts.background.Parallax.Pine1;
import com.spxscripts.background.Parallax.Sky;
import com.spxscripts.infearium.Infearium;
import com.spxscripts.object.terrain.Dirt;
import com.spxscripts.object.terrain.Grass;
import com.spxscripts.object.terrain.Stone;
import com.spxscripts.api.util.SimplexNoise;

import java.util.ArrayList;

/**
 * Created by Sphiinx on 3/5/2016.
 */
public class Generation {

    private final double DISTANCE_TO_CORNER = (Math.sqrt(Math.pow(Gdx.graphics.getWidth() / 2.0, 2) + Math.pow(Gdx.graphics.getHeight() / 2.0, 2)));

    public ArrayList<BlockObject> blocks = new ArrayList<BlockObject>();
    private ArrayList<BackgroundObject> parallax = new ArrayList<BackgroundObject>();
    public SimplexNoise noiseGen;
    public long seed = System.currentTimeMillis();

    public Generation() {

    }

    public float[][] generateSimplexNoise(int leftGenerationStart, int worldSizeX, int worldSizeY, int blockSize) {
        float[][] simplexnoise = new float[worldSizeX][worldSizeY];
        float frequency = 5.0f / (float) worldSizeX;

        for (int i = leftGenerationStart; i < worldSizeX + leftGenerationStart; i += blockSize) {
            for (int j = 0; j > worldSizeY; j -= blockSize) {
                simplexnoise[i][j] = (float) noiseGen.eval(i * frequency, j * frequency);
                simplexnoise[i][j] = (simplexnoise[i][j] + 1) / 2; // Generates a value between 0 and 1
            }
        }
        return simplexnoise;
    }

    public void generateBlocks(int leftGenerationStart, int worldSizeX, int worldSizeY, int blockSize) {
        noiseGen = new SimplexNoise(seed);

        for (int i = leftGenerationStart; i < worldSizeX + leftGenerationStart; i += blockSize) {
            for (int j = 0; j > worldSizeY; j -= blockSize) {
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
        for (int i = leftGenerationStart; i < x + leftGenerationStart; i += parallaxSize) {
            parallax.add(new mountain1(i, y, 2));
            parallax.add(new Pine1(i, y, 2));
        }
    }

    public void generateSky(int leftGenerationStart, int x, int y, int parallaxSize) {
        for (int i = leftGenerationStart; i < x + leftGenerationStart; i += parallaxSize) {
            parallax.add(new Sky(i, y, 1));
        }
    }

    public void drawBlocks(SpriteBatch batch) {
        int count = 0;
        for (BlockObject object : blocks) {
            final double DISTANCE = Infearium.character.distanceTo(object.getX(), object.getY());
            //System.out.println("Distance: " + DISTANCE);
            if (DISTANCE <= DISTANCE_TO_CORNER /*&& DISTANCE <= Gdx.graphics.getHeight() / 2*/) {
                object.draw(batch);
                count++;
            }
        }
        System.out.println("Block count: " + count);
    }

    public void drawParallax(SpriteBatch batch) {
        for (BackgroundObject object : parallax) {
            object.draw(batch);
        }
    }

    public void drawSky(SpriteBatch batch) {
        for (BackgroundObject object : parallax) {
            object.draw(batch);
        }
    }

}

