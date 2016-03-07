package com.spxscripts.object.terrain;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

/**
 * Created by Sphiinx on 3/5/2016.
 */
public class TerrainManager {

    public static Texture empty;
    public static Texture dirt;
    public static Texture stone;

    public static void create() {
        empty = new Texture(Gdx.files.internal("terrain/empty16x16.png"));
        empty.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        dirt = new Texture(Gdx.files.internal("terrain/dirt16x16.png"));
        dirt.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        stone = new Texture(Gdx.files.internal("terrain/stone16x16.png"));
        stone.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
    }

    public static void dispose() {
        dirt.dispose();
        stone.dispose();
    }

}

