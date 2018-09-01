package dev.glick.asteroids;

import java.util.List;
import dev.glick.asteroids.display.GUI;

public class AsteroidMang {

	Game game;
	List<Asteroid> asteroidArray;
	GUI gui;
	public int spawnRate;
	public int speedFactor;
	
	
	public AsteroidMang(Game game) {
		this.game = game;
		this.gui = game.getGui();
		spawnRate = 10;
		speedFactor = 30;
	}
	
	public void tick() {
		if (gui.time% spawnRate == 0) {
			Asteroid asteroid = new Asteroid((int) Math.round(Math.random()*speedFactor),(int) Math.round(Math.random()*speedFactor));
			asteroidArray.add(asteroid);
		}
		
		if(asteroidArray.isEmpty()==false) {
			//update all asteroid pos.
		}
	}
}
