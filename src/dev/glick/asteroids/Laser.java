package dev.glick.asteroids;

public class Laser {
	private Game game;
	public Line line;
	public int globX, globY;
	public double speedX,speedY;
	public double angle;
	int[] localX = {-20,0,20,0};
	int[] localY = {20,-20,20,10};
	double[][] localXY= {{-20,0,20,0},{20,-20,20,10}};
	

	public Laser(Game game) {
		
		this.game = game;
		globX=1920/2;
		globY=1080/2;
		speedX=0;
		speedY=0;
		
		line = new Line(50,0);
		}
}
