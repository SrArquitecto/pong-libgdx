package archsoftwokrs.pong.nucleo;

import archsoftwokrs.pong.pantallas.PantallaJuego;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;

public class Pong extends Game {
	
	public static final AssetManager MANAGER = new AssetManager();
	
	private PantallaJuego pantallaJuego;
	
	@Override
	public void create() {		
		Pong.MANAGER.load("imagenes/pala.png", Texture.class);
		Pong.MANAGER.load("imagenes/bola.png", Texture.class);
		Pong.MANAGER.load("sonido/sonidoPala.ogg", Sound.class);
		Pong.MANAGER.load("sonido/sonidoLimite.ogg", Sound.class);
		Pong.MANAGER.load("sonido/sonidoPunto.ogg", Sound.class);

		while(!Pong.MANAGER.update()) {
			
			System.out.println("Cargando...");
		}
		
		System.out.println("¡Cargado!");
		
		this.pantallaJuego = new PantallaJuego(this);
		super.setScreen(this.pantallaJuego);
	}
	
	public void dispose() {
	Pong.MANAGER.dispose();
	this.pantallaJuego.dispose();
	}
}