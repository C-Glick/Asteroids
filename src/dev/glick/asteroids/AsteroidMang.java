package dev.glick.asteroids;

import java.util.ArrayList;
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
		asteroidArray = new ArrayList<>();
		spawnRate = 120;
		speedFactor = 10;
	}
	
	public void tick() {
		if (gui.frames % spawnRate == 0) {
			Asteroid asteroid = new Asteroid((int) Math.round(randomSpeed()),(int) Math.round(randomSpeed()));
			asteroidArray.add(asteroid);
		}
		
		if(asteroidArray.isEmpty()==false) {
			//update all asteroid pos.
		}
	}
	
	public void createAsteroid() {
		Asteroid asteroid = new Asteroid((int) Math.round(randomSpeed()),(int) Math.round(randomSpeed()));
		asteroidArray.add(asteroid);
	}
	
	private double randomSpeed() {
		double result = (Math.random()*speedFactor)-(speedFactor/2);
		
		return result;
	}
}
