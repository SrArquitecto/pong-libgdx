package archsoftwokrs.pong.actores;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class ActorPorteria extends Actor {

	private Rectangle porteria;
	private int puntuacion;
	private float x, y;
	private BitmapFont fuente = new BitmapFont();
	
	//Coordenadas de puntuación.
	public void setXY(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	public ActorPorteria() {
		this.porteria = new Rectangle(getX(), getY(), 0, Gdx.graphics.getHeight());
		this.fuente.setColor(1, 1, 1, 1);
		this.fuente.setScale(2.5f);
		this.puntuacion = 0;

	}
	
	public ActorPorteria(String nombre) {
		
	}
	
	@Override
	public void draw(Batch batch, float parentAlpha) {
		super.draw(batch, parentAlpha);
		fuente.draw(batch, "" + this.puntuacion, this.x, this.y);
		
	}
	
	@Override
	public void act(float delta) {
		super.act(delta);
		this.porteria.x = getX();
		this.porteria.y = getY();
	}
	
	//Comprueba si la bola esta en la porteria. En caso afirmativo suma en el
	public void comprobarBola(ActorBola actorBola) {
		if(actorBola.getRec().overlaps(this.porteria)) {
			
			puntuacion++;
			actorBola.setPosition((Gdx.graphics.getWidth() - actorBola.getWidth()) / 2, (Gdx.graphics.getHeight() - actorBola.getHeight()) / 2);
			System.out.println(puntuacion);
			
			//Al reves... puesto que la puntuación es la del contrario...
			if(actorBola.getX() < Gdx.graphics.getWidth()) {
				actorBola.getDireccion().x = - 200;
				actorBola.getDireccion().x = -actorBola.getDireccion().x;
				actorBola.getDireccion().y = MathUtils.random(-60, 60);
			}
		}
		
	}

}

