package archsoftwokrs.pong.actores;

import archsoftwokrs.pong.nucleo.Pong;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class ActorBola extends Actor {

	private TextureRegion texBola;
	private Rectangle recBola;
	
	private Vector2 direccion = new Vector2(-120f, -120f);
	
	public Rectangle getRec() {
		return recBola;
	}
	
	public Vector2 getDireccion() {
		return direccion;
	}
	
	public ActorBola() {
		
		this.texBola = new TextureRegion(Pong.MANAGER.get("imagenes/bola.png",  Texture.class), 
										 Pong.MANAGER.get("imagenes/bola.png", Texture.class).getWidth(), 
										 Pong.MANAGER.get("imagenes/bola.png", Texture.class).getHeight());
		
		super.setSize(this.texBola.getRegionWidth(), this.texBola.getRegionHeight());
		
		this.recBola = new Rectangle(getX(), getY(), getWidth(), getHeight());

	}
	
	@Override
	public void act(float delta) {
		super.act(delta);
		translate(direccion.x * delta, direccion.y * delta);
		this.recBola.x = getX();
		this.recBola.y = getY();
		
		this.comprobarLimites();
		
	}
	
	@Override
	public void draw(Batch batch, float parentAlpha) {
		super.draw(batch, parentAlpha);
		batch.draw(Pong.MANAGER.get("imagenes/bola.png", Texture.class), getX(), getY());
	}
	
	public void comprobarLimites() {
		if(getY() <= 0) {
			setY(0);
			this.direccion.y = -this.direccion.y + 10;
			this.direccion.x = this.direccion.x + 10;
		}
		
		else if(getY() >= Gdx.graphics.getHeight() - this.texBola.getRegionHeight()) {
			setY(Gdx.graphics.getHeight() - this.texBola.getRegionHeight());
			this.direccion.y = -this.direccion.y + 10;
			this.direccion.x = this.direccion.x + 10;
		}
			
	}
	

}
