package com.spxscripts.infearium.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.spxscripts.infearium.Infearium;

public class DesktopLauncher {

	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Infearium";
		config.useGL30 = false;
		config.width = 1920;
		config.height = 1080;
		new LwjglApplication(new Infearium(), config);
	}

}
