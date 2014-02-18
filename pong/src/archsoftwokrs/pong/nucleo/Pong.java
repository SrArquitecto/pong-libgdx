package archsoftwokrs.pong.nucleo;

import archsoftwokrs.pong.pantallas.PantallaJuego;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Pong extends Game {
	
	public static final AssetManager MANAGER = new AssetManager();
	
	private PantallaJuego pantallaJuego;
	
	@Override
	public void create() {		
		Pong.MANAGER.load("imagenes/pala.png", Texture.class);
		Pong.MANAGER.load("imagenes/bola.png", Texture.class);

		while(!Pong.MANAGER.update()) {
			
			System.out.println("Cargando...");
		}
		
		System.out.println("¡Cargado!");
		
		this.pantallaJuego = new PantallaJuego(this);
		super.setScreen(this.pantallaJuego);
	}
	
	public void dispose() {
	Pong.MANAGER.dispose();
	}
}