package archsoftwokrs.pong.actores;

import archsoftwokrs.pong.nucleo.Pong;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class ActorPala extends ActorPalaBase {
 	
	public ActorPala() {
		super();	
	}
	
	@Override
	public void act(float delta) {
		super.act(delta);
		this.recPala.y = getY();
		this.recPala.x = getX();
		mover();
	}
	
	public void mover() {
		if(Gdx.input.isKeyPressed(Keys.DOWN)) {
			setY(getY() - 500 * Gdx.graphics.getDeltaTime());
			//this.recPala.y -= 500 * Gdx.graphics.getDeltaTime(); 
		}
		
		if(Gdx.input.isKeyPressed(Keys.UP)) {
			setY(getY() + 500 * Gdx.graphics.getDeltaTime());
			//this.recPala.y -= 500 * Gdx.graphics.getDeltaTime(); 
		}
	}
	
	public void dispose() {
		
	}

}
