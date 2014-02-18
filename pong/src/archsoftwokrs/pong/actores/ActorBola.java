package archsoftwokrs.pong.actores;

import archsoftwokrs.pong.nucleo.Pong;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class ActorBola extends Actor {

	private Rectangle recBola;

	private static final float altoBola = Pong.MANAGER.get("imagenes/bola.png", Texture.class).getHeight();
	private static final float anchoBola = Pong.MANAGER.get("imagenes/bola.png", Texture.class).getWidth();
	
	private static final float posOrigenX = Gdx.graphics.getWidth()/2 - anchoBola/2;
	private static final float posOrigenY = Gdx.graphics.getHeight()/2 - altoBola/2;
	
	public ActorBola() {

		this.recBola = new Rectangle(posOrigenX, posOrigenY, anchoBola, altoBola);
		//this.recBola.width = Pong.MANAGER.get("imagenes/bola.png", Texture.class).getWidth();
		//this.recBola.height = Pong.MANAGER.get("imagenes/bola.png", Texture.class).getHeight();
		//this.recBola.x = Gdx.graphics.getWidth()/2 - this.anchoBola/2;
		//this.recBola.y = Gdx.graphics.getHeight()/2 - this.altoBola/2;
	}
	
	@Override
	public void draw(Batch batch, float parentAlpha) {
		Pong.MANAGER.finishLoading();
		batch.draw(Pong.MANAGER.get("imagenes/bola.png", Texture.class), this.recBola.x, this.recBola.y);
	}
}
