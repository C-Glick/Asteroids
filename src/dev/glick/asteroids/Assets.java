package dev.glick.asteroids;

import dev.glick.asteroids.display.GUI;

public class Assets {
	public static Ship ship;
	public static GUI gui;
	public  Game game;
	
	public Assets(Game game) {
		this.game = game;
	}
	public void init() {
		
		ship = new Ship(game);
		gui = new GUI();
	}
	
}
