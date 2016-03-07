package com.spxscripts.object.character;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

/**
 * Created by Sphiinx on 3/5/2016.
 */
public class CharacterManager {

    public static Texture character;

    public static void create() {
        character = new Texture(Gdx.files.internal("character/kevin.png"));
        character.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

    }

    public static void dispose() {
        character.dispose();
    }

}

