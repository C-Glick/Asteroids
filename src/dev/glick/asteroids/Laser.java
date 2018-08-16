package dev.glick.asteroids;

import dev.glick.asteroids.display.Line;

public class Laser {
	public Game game;
	private final int accel = 8;
	private int killDist = 100;
	public Line line;
	public int globX1, globY1, globX2, globY2;
	public double speedX,speedY;
	public double angle;
	public int length=50;
	int[] localX = {-20,0,20,0};
	int[] localY = {20,-20,20,10};
	double[][] localXY= {{-20,0,20,0},{20,-20,20,10}};
	

	public Laser(Game game, double radians, double startX, double startY) {
		this.game = game;
		
		speedX= (Math.sin(radians)*accel);				//if pressing up set the x and y speeds to the equal the accel, accel is the hypotenuse 
		speedY= (Math.cos(radians)*accel);
		
		
		
		double xDist = Math.sin(radians)*length;
		double yDist = Math.cos(radians)*length;
		line = new Line(startX,startY,startX+xDist,startY-yDist);			

		
	}
	
	public void tick(){
		line.y1 = line.y1 - (int) Math.round(speedY);													//set the global x and y based on the speedX and speedY
		line.x1 = line.x1 + (int) Math.round(speedX);	
		line.y2 = line.y2 - (int) Math.round(speedY);													//set the global x and y based on the speedX and speedY
		line.x2 = line.x2 + (int) Math.round(speedX);	
		
		if (line.x2 >game.width+killDist || line.y2 >game.height + killDist|| line.x2 < -killDist || line.y2 < -killDist ) {
			Assets.ship.laserArray.remove(this);
		}
		 
	}
	public Line getLine() {
		return line;
	}
	
}
