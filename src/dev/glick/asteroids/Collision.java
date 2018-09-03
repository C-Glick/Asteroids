package dev.glick.asteroids;

import java.awt.Rectangle;
import java.util.List;

public class Collision {
	Game game;
	Ship player;
	Rectangle playerBox;
	List<Laser> laserArray;
	List<Asteroid> asteroidArray;
	AsteroidMang asteroidMang;
	
	public Collision(Game game) {
		this.game = game;
	}
	
	public void init() {
		player = game.getShip();
		playerBox = player.polygon.getBounds();
		
		laserArray = game.getShip().laserArray;
		
		asteroidMang = game.getAsteroidMang();
		asteroidArray = asteroidMang.asteroidArray;
	}
	
	public void tick() {
		//update player box
		playerBox= player.polygon.getBounds();
		
		//check if asteroid intersects player box
		if (!asteroidArray.isEmpty()) {
			for (int i=0; i<asteroidArray.size();i++) {
				Asteroid asteroid = asteroidArray.get(i);
				if (asteroid.polygon.intersects(playerBox)) {
					player.kill();
				}			
			}
		}
		
		//check if any asteroids are intersecting lasers
		if (!asteroidArray.isEmpty() && !laserArray.isEmpty()) {
			for (int i=0; i<asteroidArray.size();i++) {
				Asteroid asteroid = asteroidArray.get(i);
				for(int j=0; j<laserArray.size();j++) {
					Laser laser = laserArray.get(j);
					if (asteroid.polygon.getBounds().intersectsLine(laser.line)){
						asteroid.destroy();
						laser.remove();
				}
				
				}			
			}
		}
	}

}
