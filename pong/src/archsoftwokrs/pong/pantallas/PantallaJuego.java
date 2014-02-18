package archsoftwokrs.pong.pantallas;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL11;
import com.badlogic.gdx.scenes.scene2d.Stage;
import archsoftwokrs.pong.actores.ActorBola;
import archsoftwokrs.pong.actores.ActorPala;
import archsoftwokrs.pong.nucleo.Pong;

public class PantallaJuego extends PantallaBase {
	
	private Stage stage;
	private ActorPala actorPala;
	private ActorBola actorBola;
	
	//Con esto calculamos la posicion relativa del actor "actorPala" respecto del eje X.
	private float posRelativaX = Gdx.graphics.getWidth()/16; 

	public PantallaJuego(Pong juego) {
		super(juego);

	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL11.GL_COLOR_BUFFER_BIT);
		
		this.stage.act();
		this.stage.draw();
	
	}

	@Override
	public void show() {
		this.stage = new Stage();
		
		this.actorPala = new ActorPala();
		this.actorPala.setPosition(this.posRelativaX, (Gdx.graphics.getHeight() - this.actorPala.getHeight()) / 2);
		this.stage.addActor(this.actorPala);
		
		this.actorBola = new ActorBola();
		this.stage.addActor(this.actorBola);
		
		
	}

	@Override
	public void dispose() {
		Pong.MANAGER.dispose();
		this.stage.dispose();
	}

}
