package com.spxscripts.data;

/**
 * Created by Sphiinx on 5/14/2016.
 */
public class Vars {

    public static Vars vars;

    public static Vars get() {
        return vars == null ? vars = new Vars() : vars;
    }

    public static void reset() {
        vars = null;
    }

    public int leftGenerationStart = -4000;
    public int worldSizeX = 8000;
    public int worldSizeY = -8000;
    public int blockSize = 16;

}

