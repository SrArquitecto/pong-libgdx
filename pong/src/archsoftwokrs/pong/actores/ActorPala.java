package archsoftwokrs.pong.actores;

import archsoftwokrs.pong.nucleo.Pong;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class ActorPala extends Actor {

	private TextureRegion texPala;
	private Rectangle recPala;
 	
	public ActorPala() {
		//Inicializamos la region de la textura y definimos sus dimensiones.
		this.texPala = new TextureRegion(Pong.MANAGER.get("imagenes/pala.png", Texture.class)
									   , Pong.MANAGER.get("imagenes/pala.png", Texture.class).getWidth()
									   , Pong.MANAGER.get("imagenes/pala.png", Texture.class).getHeight());
		
		//Definimos las dimensiones del actor.
		setSize(this.texPala.getRegionWidth(), this.texPala.getRegionHeight());
		
		//Inicializamos el rectangulo de colisiones del actor.
		this.recPala = new Rectangle(getX(), getY(), getWidth(), getHeight());
		
	}
	
	@Override
	public void act(float delta) {
		super.act(delta);
		this.recPala.y = getY();
		this.recPala.x = getX();
	}
	
	@Override
	public void draw(Batch batch, float parentAlpha) {

		batch.draw(this.texPala, getX(), this.recPala.y /*getY()*/, getOriginX(), getOriginY(), getWidth(), getHeight(), getScaleX(), getScaleY(), getRotation());
		
		//this.mover();
	}
	
	public void mover() {
		if(Gdx.input.isKeyPressed(Keys.DOWN)) {
			setY(getY() - 500 * Gdx.graphics.getDeltaTime());
			//this.recPala.y -= 500 * Gdx.graphics.getDeltaTime(); 
		}
	}
	
	public void dispose() {
		
	}

}
