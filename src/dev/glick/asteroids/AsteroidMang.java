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
		speedFactor = 2;
	}
	
	public void tick() {
		if (gui.frames % spawnRate == 0) {
			createAsteroid(true);
		}
		
		if(!asteroidArray.isEmpty()) {
			//update all asteroid pos.
		}
	}
	
	public void createAsteroid(boolean large) {
		Asteroid asteroid = new Asteroid(randomSpeed(),randomSpeed(),large, game);
		asteroidArray.add(asteroid);
	}
	public void createAsteroid(int x, int y, int xSpeed, int ySpeed, boolean large) {
		Asteroid asteroid = new Asteroid(x,y,xSpeed*speedFactor,ySpeed*speedFactor, large, game);
		asteroidArray.add(asteroid);
	}
	
	public void removeAsteroid(Asteroid asteroid) {
		asteroidArray.remove(asteroid);
	}
	
	public int randomSpeed() {
		int result =(int) Math.round((Math.random()*speedFactor)-(speedFactor/2));
		
		return result;
	}
}
