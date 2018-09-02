package dev.glick.asteroids.display;

public class GUI {

	public int lives;
	public int score;
	public int frames;
	public int time;
	
	public GUI() {
		lives =3;
		score =0;
		time =1;
		frames =60;
	}
	
	public void tick(){
		
		frames++;
		time=frames/60;
		
	}
}
