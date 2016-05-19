package com.spxscripts.infearium;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.spxscripts.BlockObject;
import com.spxscripts.api.util.FPSCounter;
import com.spxscripts.background.BackgroundManager;
import com.spxscripts.data.Vars;
import com.spxscripts.object.character.Character;
import com.spxscripts.object.character.CharacterManager;
import com.spxscripts.object.terrain.TerrainManager;
import com.spxscripts.world.Generation;

public class Infearium extends ApplicationAdapter {

    private OrthographicCamera camera;
    private SpriteBatch batch;
    public static Character character;
    private Generation generation;


    @Override
    public void create() {
        Vars.reset();
        CharacterManager.create();
        BackgroundManager.create();
        TerrainManager.create();

        camera = new OrthographicCamera();
        camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        batch = new SpriteBatch();

        character = new Character();
        character.setPosition(0, 0);

        generation = new Generation();

        generation.generateBlocks(Vars.get().leftGenerationStart, Vars.get().worldSizeX, Vars.get().worldSizeY, Vars.get().blockSize);
        generation.generateSky(Vars.get().leftGenerationStart, Vars.get().worldSizeX, -200, 1024);
        generation.generateParallax(Vars.get().leftGenerationStart, Vars.get().worldSizeX, -400, 2048);

    }

    @Override
    public void dispose() {
        batch.dispose();
        BackgroundManager.dispose();
        CharacterManager.dispose();
        TerrainManager.dispose();
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.setProjectionMatrix(camera.combined);
        batch.begin();

        generation.drawParallax(batch);

        character.draw(batch);

        generation.drawBlocks(batch);

        batch.end();

        character.update(Gdx.graphics.getDeltaTime());
        handleCollision();
        handleFollowingCamera();
        handleMovement();
        FPSCounter.getFPS();
    }

    private void handleFollowingCamera() {
        camera.position.set(character.getHitBox().x, character.getHitBox().y, 0);
        camera.update();
    }

    private void handleCollision() {
        for (BlockObject o : generation.blocks) {
            if (o.getHitBox() != null) {
                switch (character.isColliding(o.getHitBox())) {
                    case 1:
                        character.action(1, 0, o.getHitBox().y + o.getHitBox().height);
                        break;
                    case 2:
                        float dist = character.getHitBox().getX() - (o.getHitBox().x + o.getHitBox().width + 1);
                        character.action(2, o.getHitBox().x + o.getHitBox().width + 1, 0);
                        /*for (BackgroundObject object : parallax) {
                            object.action(0, dist, 0);
                        }*/
                        break;
                    case 3:
                        float distance = character.getHitBox().getX() - (o.getHitBox().x - character.getHitBox().width - 1);
                        character.action(3, o.getHitBox().x - character.getHitBox().width - 1, 0);
                        /*for (BackgroundObject object : parallax) {
                            object.action(0, distance, 0);
                        }*/
                        break;
                    case 4:
                        character.action(4, 0, o.getHitBox().y - character.getHitBox().height);
                }
            }
        }
    }

    private void handleMovement() {
        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            character.moveLeft(Gdx.graphics.getDeltaTime(), character.getVelocityX());
            /*for (BackgroundObject object : parallax) {
                object.moveLeft(Gdx.graphics.getDeltaTime(), character.getVelocityX() / 2);
            }*/
        }
        if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            character.moveRight(Gdx.graphics.getDeltaTime(), character.getVelocityX());
            /*for (BackgroundObject object : parallax) {
                object.moveRight(Gdx.graphics.getDeltaTime(), character.getVelocityX() / 2);
            }*/
        }
        if (Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
            character.jump();
        }
    }

}
