package archsoftwokrs.pong.actores;

import archsoftwokrs.pong.nucleo.Pong;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.actions.MoveToAction;

public class ActorPalaIA extends ActorPalaBase {
 	
	private float y, x;
	private Vector2 velocidad = new Vector2(0f, 100f);
	
	public ActorPalaIA() {
		super();	
		//this.y = Gdx.graphics.getHeight() / 2;
	}
	
	@Override
	public void act(float delta) {
		super.act(delta);
		
		//if(>= Gdx.graphics.getWidth() / 2)

		//setY(MathUtils.random(this.y + 30, Gdx.graphics.getHeight() - (Gdx.graphics.getHeight() - this.y)));
		//setY(this.y + MathUtils.random(-10, 10) - getHeight()/2 * Gdx.graphics.getDeltaTime());
		
		//super.setY(this.y - getHeight()/2);
		this.recPala.y = getY();
		this.recPala.x = getX();
		
		this.controlarIA();
		super.controlarLimites();

	}
	
	public void recogerDatosBola(ActorBola actorBola) {
		this.y = actorBola.getRec().y + actorBola.getHeight()/2;
		this.x = actorBola.getRec().x + actorBola.getWidth()/2;
	}
	

	public void controlarIA() {
	
		if(this.x >= Gdx.graphics.getWidth() / 2) {
			
			if(this.recPala.y + this.recPala.getHeight()/2 < this.y)
					//translate(0, this.velocidad.y * Gdx.graphics.getDeltaTime());
					setY(getY() + 300 * Gdx.graphics.getDeltaTime());
			
			else if(this.recPala.y + this.recPala.getHeight()/2 > this.y)
					//translate(0, - (this.velocidad.y * Gdx.graphics.getDeltaTime()));
					setY(getY() - (300 * Gdx.graphics.getDeltaTime()));

		}
		
		//if(this.x < Gdx.graphics.getWidth() / 2) {
			
		//	if(this.recPala.y + this.recPala.getHeight()/2 < Gdx.graphics.getHeight()/2)
				//translate(0, this.velocidad.y * Gdx.graphics.getDeltaTime());
		//		setY(getY() + 300 * Gdx.graphics.getDeltaTime());
		
		//	else if(this.recPala.y + this.recPala.getHeight()/2 > Gdx.graphics.getHeight()/2)
				//translate(0, - (this.velocidad.y * Gdx.graphics.getDeltaTime()));
		//		setY(getY() - (300 * Gdx.graphics.getDeltaTime()));
			
			//else if(this.recPala.y + this.recPala.getHeight()/2 == Gdx.graphics.getHeight()/2)
				//setY(this.recPala.y);
		//}
			
	}
	
	@Override
	public void draw(Batch batch, float parentAlpha) {
		super.draw(batch, parentAlpha);
	}
	
}
