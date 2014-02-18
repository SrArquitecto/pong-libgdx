package archsoftwokrs.pong.pantallas;

import archsoftwokrs.pong.nucleo.Pong;

import com.badlogic.gdx.Screen;

public abstract class PantallaBase implements Screen {

	protected Pong juego;
	
	public PantallaBase(Pong juego) {
		this.juego = juego;
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub

	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub

	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

}
