package dev.glick.asteroids;

import dev.glick.asteroids.display.Display;

public class Launcher {

	public static void main(String[] args) {
		Game game =new Game("Title!",500,500);
		game.start();
	}

}
