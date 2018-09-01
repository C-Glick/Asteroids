package dev.glick.asteroids;

import java.awt.Rectangle;
import java.util.List;

public class Collision {
	Game game;
	Ship player;
	Rectangle playerBox;
	List<Laser> laserArray;
	List<Asteroid> asteroidArray;
	
	public Collision(Game game) {
		this.game = game;
	}
	
	public void init() {
		player = game.getShip();
		playerBox = player.polygon.getBounds();
		
		laserArray = game.getShip().laserArray;
		
		asteroidArray = game.getAssets().asteroidMang.asteroidArray;
	}
	
	public void tick() {
		 
	}

}
