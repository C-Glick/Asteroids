package dev.glick.asteroids;

public class Launcher {
	//the launching point of the program, everything stems from here
	public static void main(String[] args) {
		Game game =new Game("Title!",1920,1080);
		game.start();
	}

}
