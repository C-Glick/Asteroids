package dev.glick.asteroids.display;

public class GUI {

	public int lives;
	public int score;
	public int frames;
	public int time;
	
	public GUI() {
		lives =3;
		score =0;
		time =0;
		frames =1;
	}
	
	public void tick(){
		
		frames++;
		time=frames/60;
		
	}
}
