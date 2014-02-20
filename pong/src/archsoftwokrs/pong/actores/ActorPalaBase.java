package archsoftwokrs.pong.actores;

import archsoftwokrs.pong.nucleo.Pong;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;

public abstract class ActorPalaBase extends Actor {

	protected TextureRegion texPala;
	protected Rectangle recPala;
 	
	public ActorPalaBase() {
		//Inicializamos la region de la textura y definimos sus dimensiones.
		this.texPala = new TextureRegion(Pong.MANAGER.get("imagenes/pala.png", Texture.class),
									     Pong.MANAGER.get("imagenes/pala.png", Texture.class).getWidth(),
									     Pong.MANAGER.get("imagenes/pala.png", Texture.class).getHeight());
		
		//Definimos las dimensiones del actor.
		setSize(this.texPala.getRegionWidth(), this.texPala.getRegionHeight());
		
		//Inicializamos el rectangulo de colisiones del actor.
		this.recPala = new Rectangle(getX(), getY(), getWidth(), getHeight());
		
		
	}
	
	@Override
	public void act(float delta) {
		super.act(delta);
		this.controlarLimites();
	}
	
	@Override
	public void draw(Batch batch, float parentAlpha) {
		super.draw(batch, parentAlpha);
		batch.draw(this.texPala, getX(), getY(), getOriginX(), getOriginY(), getWidth(), getHeight(), getScaleX(), getScaleY(), getRotation());
		
	}
	
	public void controlarLimites() {
		if(getY() >= Gdx.graphics.getHeight() - getHeight())
			setY(Gdx.graphics.getHeight() - getHeight());
		
		if(getY() <= 0)
			setY(0);
	}

	public void controlarBola(ActorBola actorBola) {
		if(actorBola.getRec().overlaps(recPala)) {
			actorBola.getDireccion().x = - (actorBola.getDireccion().x + 50);
			actorBola.getDireccion().y = (actorBola.getDireccion().y + 50);
			Pong.MANAGER.get("sonido/sonidoPala.ogg", Sound.class).play();
		}		
	}

	public void recogerDatosBola(ActorBola actorBola) {
		// TODO Auto-generated method stub
		
	}

}
