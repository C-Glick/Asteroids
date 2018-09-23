package dev.glick.asteroids;

import dev.glick.asteroids.display.GUI;

public class Assets {
	public static Ship ship;
	public static GUI gui;
	public static Collision collision;
	public  Game game;
	public static AsteroidMang asteroidMang;
	
	public Assets(Game game) {
		this.game = game;
	}
	public void init() {
		
		ship = new Ship(game);
		gui = new GUI(game);
		collision = new Collision(game);
		asteroidMang = new AsteroidMang(game);
		
	}
	
}
