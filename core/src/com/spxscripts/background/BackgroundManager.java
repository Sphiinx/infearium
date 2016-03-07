package com.spxscripts.background;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

/**
 * Created by Sphiinx on 3/5/2016.
 */
public class BackgroundManager {

    public static Texture pine1;
    public static Texture mountain1;
    public static Texture sky;

    public static void create() {
        pine1 = new Texture(Gdx.files.internal("background/pine1.png"));
        pine1.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        mountain1 = new Texture(Gdx.files.internal("background/mountain1.png"));
        mountain1.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        sky = new Texture(Gdx.files.internal("background/sky.png"));
        sky.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
    }

    public static void dispose() {
        pine1.dispose();
        mountain1.dispose();
        sky.dispose();
    }

}

