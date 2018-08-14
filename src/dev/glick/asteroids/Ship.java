package dev.glick.asteroids;

import java.awt.Polygon;

public class Ship {
	public Polygon polygon;
	public int locX, locY;
	public double speedX,speedY;
	public double accelX, accelY;
	public double angle;
	int[] localX = {-20,0,20,0};
	int[] localY = {-20,20,-20,-10};
	int[][] localXY= {{-20,0,20,0},{-20,20,-20,-10}};
	int[][] test= {{5,5},{1,1}};

	
	public Ship() {
		accelX=0;
		accelY=0;
		speedX=0;
		speedY=0;
		
		polygon = new Polygon(localX,localY, 4);
		}
	
	public void updatePos() {
		//translation
		
		
		
		//rotation
		Calc.multiplyMatrix(localXY, test, 2, 3, 2);
		
		
		
		int[] globalX = {1,3};
		int[] globalY = {1,4};
		polygon = new Polygon(globalX,globalY, 4);

	}
}
