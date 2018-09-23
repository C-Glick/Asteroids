package dev.glick.asteroids.display;

import dev.glick.asteroids.Game;

public class GUI {

	public int lives;
	public int score;
	public int frames;
	public int time;
	private Game game;
	private int low;
	private int high;
	
	public GUI(Game game) {
		lives =3;
		score =0;
		time =0;
		frames =1;
		low = 15;
		high = 30;
		this.game = game;
	}
	
	public void tick(){
		
		frames++;
		time=frames/60;
		
	}
	
	public void loseLife() {
		if (lives>0) {
			lives = lives - 1;	
		}
		else {
			game.end();
		}
	}
	public int getScore() {
		return score;
	}
	
	public void setScore(int score) {
		this.score = score;
	}
	public void pointsLowInc() {
		score = score +low;
	}
	public void pointsHighInc() {
		score = score +high;
	}
}
