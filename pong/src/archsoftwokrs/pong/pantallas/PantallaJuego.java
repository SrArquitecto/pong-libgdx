package archsoftwokrs.pong.pantallas;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL11;
import com.badlogic.gdx.scenes.scene2d.Stage;

import archsoftwokrs.pong.actores.ActorBola;
import archsoftwokrs.pong.actores.ActorPala;
import archsoftwokrs.pong.actores.ActorPalaBase;
import archsoftwokrs.pong.actores.ActorPalaIA;
import archsoftwokrs.pong.actores.ActorPorteria;
import archsoftwokrs.pong.nucleo.Pong;

public class PantallaJuego extends PantallaBase {
	
	private Stage escena;
	private ActorPalaBase actorPalaJ1, actorPalaJ2;
	private ActorBola actorBola;
	private ActorPorteria actorPorteriaJ1, actorPorteriaJ2;
	
	//Con esto calculamos la posicion relativa del actor "actorPala" respecto del eje X.
	private float posRelativaX = Gdx.graphics.getWidth()/16; 

	public PantallaJuego(Pong juego) {
		super(juego);

	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL11.GL_COLOR_BUFFER_BIT);
		
		this.escena.act();	
		
		this.actorPalaJ1.controlarBola(actorBola);
		this.actorPalaJ2.controlarBola(actorBola);
		
		this.actorPalaJ2.recogerDatosBola(actorBola);
		
		this.actorPorteriaJ1.comprobarBola(actorBola);
		this.actorPorteriaJ2.comprobarBola(actorBola);
		
		this.escena.draw();
	}

	@Override
	public void show() {
		this.escena = new Stage();
		
		this.actorPalaJ1 = new ActorPala();
		this.actorPalaJ1.setPosition(this.posRelativaX, (Gdx.graphics.getHeight() - this.actorPalaJ1.getHeight()) / 2);
		this.escena.addActor(this.actorPalaJ1);
		
		this.actorPalaJ2 = new ActorPalaIA();
		this.actorPalaJ2.setPosition(Gdx.graphics.getWidth() - this.posRelativaX, (Gdx.graphics.getHeight() - this.actorPalaJ1.getHeight()) / 2);
		this.escena.addActor(this.actorPalaJ2);
		
		this.actorBola = new ActorBola();
		this.actorBola.setPosition((Gdx.graphics.getWidth() - actorBola.getWidth()) / 2, (Gdx.graphics.getHeight() - actorBola.getHeight()) / 2);
		this.escena.addActor(this.actorBola);
		
		
		//La porteria contraria a la del Jugador 1 (que esta a la izquierda) es la que almacena la puntuacion del Jugador 1. 
		//Ya se vera una posible solucion.
		this.actorPorteriaJ1 = new ActorPorteria();
		this.actorPorteriaJ1.setXY(Gdx.graphics.getWidth()/2 - 40, Gdx.graphics.getHeight() - 20);
		this.actorPorteriaJ1.setPosition(Gdx.graphics.getWidth() + this.actorBola.getHeight(), 0);
		this.escena.addActor(this.actorPorteriaJ1);
		
		this.actorPorteriaJ2 = new ActorPorteria();
		this.actorPorteriaJ2.setXY(Gdx.graphics.getWidth()/2 + 40, Gdx.graphics.getHeight() - 20);
		this.actorPorteriaJ2.setPosition(-this.actorBola.getWidth(), 0);
		this.escena.addActor(this.actorPorteriaJ2);
	}

	@Override
	public void dispose() {
		this.escena.dispose();
	}

}
