package dev.glick.asteroids;

import java.awt.Polygon;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import dev.glick.asteroids.display.Line;

public class Ship {
	private Game game;
	public Polygon polygon;
	public int globX, globY;										//position of ship (center of polygon)
	public double speedX,speedY;
	private double accel;											//acceleration when pressing up
	private double rotationSpeed;
	public double angle;											//current angle of ship in degrees
	int[] localX = {-20,0,20,0};									//local vertices of the ship
	int[] localY = {20,-20,20,10};
	double[][] localXY= {{-20,0,20,0},{20,-20,20,10}};
	double tipX;
	double tipY;
	private long lastLaser=System.currentTimeMillis();
	List<Laser> laserArray;

	
	public Ship(Game game) {
		laserArray = new ArrayList<>();
		this.game = game;
		globX=1920/2;												//sets the starting location of the ship to the center of the screen
		globY=1080/2;
		accel=.05;
		rotationSpeed=2; //degrees per frame
		polygon = new Polygon(localX,localY, 4);					//creates a new polygon to draw in the starting location
		}
	
	public void tick() {											//updates all variables for the ship
		double radians = Math.toRadians(angle);						//converts angle to radians
		
		//get key presses
		
		if(game.getKeyManager().up) {
			speedX= speedX- (Math.sin(radians)*accel);				//if pressing up set the x and y speeds to the equal the accel, accel is the hypotenuse 
			speedY= speedY+ (Math.cos(radians)*accel);			
		}
		globY = globY - (int) Math.round(speedY);													//set the global x and y based on the speedX and speedY
		globX = globX - (int) Math.round(speedX);	
		if(game.getKeyManager().right) {							// if right increase the angle, if more that 360 set to 0
			if(angle>=360) {
				angle=0;
			}else {
				angle=angle+rotationSpeed;
			}
		}
		if(game.getKeyManager().left) {								//if left decrese the angle, if less than 0 set to 360 
			if(angle<=0) {
				angle=360;
			}else {
				angle=angle-rotationSpeed;
			}
		}
		if(game.getKeyManager().space) {
			
			long now = System.currentTimeMillis();
			if (now-lastLaser > 300) {
				
				double xDist = Math.sin(radians)*18;
				double yDist = Math.cos(radians)*18;
				
				Laser laser = new Laser(game, radians,globX+xDist,globY-yDist);
				laserArray.add(laser);
				lastLaser = now;
			}
			
		}
		
		
		
		//rotation
		
		double[][] rotationMatrix = {{Math.cos(radians), -(Math.sin(radians))},						//the rotation matrix the rotate the polygon vertex matrix			
								     {Math.sin(radians), Math.cos(radians)}};
		
		double[][] rotatedLocalXY = Calc.multiplyMatrices(rotationMatrix, localXY, 2, 2, 4);		//creates the rotated xy matrix by multiplying the original matrix by the rotation matrix
		
		int[] rotatedX = Calc.convertArray(rotatedLocalXY[0]);										//convert the matrix to two arrays for the polygon object
		int[] rotatedY = Calc.convertArray(rotatedLocalXY[1]);
		
		
		polygon = new Polygon(rotatedX,rotatedY, 4);												//set the class polygon to a new rotated polygon
		
		//translation
											
		polygon.translate(globX, globY);															//translate the ship from 0,0 to globalX globalY
	}
}
