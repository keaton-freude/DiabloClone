package com.yeoldegames.diabloclone;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.Animation;

public class DiabloGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;

	private static final int FRAME_COLS = 8;
	private static final int FRAME_ROWS = 16;

	Animation walkAnimation;
	Texture walkSheet;
	TextureRegion[] walkFrames;
	SpriteBatch spriteBatch;
	TextureRegion currentFrame;

	Sprite sprite;



	float stateTime;


	@Override
	public void create() {
		batch = new SpriteBatch();
		walkSheet = new Texture("Paladin_Neutral.png");
		TextureRegion [][] tmp = TextureRegion.split(walkSheet, walkSheet.getWidth() / FRAME_COLS, walkSheet.getHeight()/FRAME_ROWS);
		walkFrames = new TextureRegion[FRAME_COLS * FRAME_ROWS];
		int index = 0;
		for(int i = 0; i < FRAME_ROWS; i++)
		{
			for(int j = 0; j < FRAME_COLS; j++)
			{
				walkFrames[index++] = tmp[i][j];
			}
		}
		walkAnimation = new Animation(.10f, walkFrames);
		stateTime = 0f;

	}

	@Override
	public void render() {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
		stateTime += Gdx.graphics.getDeltaTime();
		currentFrame = walkAnimation.getKeyFrame(stateTime, true);
		//currentFrame.set
		sprite = new Sprite(currentFrame);
		sprite.setScale(3.0f, 3.0f);
		sprite.setPosition(100f, 100f);
		batch.begin();
		sprite.draw(batch);
		batch.end();
	}

}
