package archsoftwokrs.pong.actores;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MoveAction;

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
	
	private Vector2 direccion = new Vector2(90f, 90f);
	
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
	}
	
	@Override
	public void draw(Batch batch, float parentAlpha) {

		batch.draw(Pong.MANAGER.get("imagenes/bola.png", Texture.class), getX(), getY());
	}
}
