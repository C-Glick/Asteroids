package dev.glick.asteroids;

public class Assets {
	public static Ship ship;
	public  Game game;
	
	public Assets(Game game) {
		this.game = game;
	}
	public void init() {
		
		ship = new Ship(game);
		
	}
	
}
