package dev.glick.asteroids;

import java.awt.Polygon;
import java.util.List;

public class Asteroid {
	private Game game;
	public Polygon polygon;
	public int globX, globY;										
	public int speedX,speedY;
	public boolean large;
	int[][] localXYBase= {{-5,-1,1,3,5,4,0,-3},{-2,-3,-4,-2,0,4,5,3}};
	AsteroidMang asteroidMang;
	
	
	public Asteroid(int speedX, int speedY, boolean large,Game game) {
		this.game = game;
		this.speedX = speedX;
		this.speedY = speedY;
		this.large = large;
		this.asteroidMang = game.getAsteroidMang();
		
		if (large) {
			int[][] largeXY = Calc.multiplyMatrix(localXYBase, 10);
			polygon = new Polygon(largeXY[0], largeXY[1], 8) ;
			int startX = (int) (Math.random()*1920);
			globX = startX;
			int startY = (int) (Math.random()*1080);
			globY=startY;
			
			polygon.translate(startX,startY);
		}
		else {
			int[][] smallXY = Calc.multiplyMatrix(localXYBase, 4);
			polygon = new Polygon(smallXY[0], smallXY[1], 8) ;
			int startX = (int) (Math.random()*1920);
			globX = startX;
			int startY = (int) (Math.random()*1080);
			globY=startY;
			
			polygon.translate(startX,startY);		}
		
	}
	
	public Asteroid(int x ,int y, int speedX, int speedY, boolean large,Game game) {
		this.game = game;
		this.speedX = speedX;
		this.speedY = speedY;
		this.large = large;
		this.asteroidMang = game.getAsteroidMang();
		
		if (large) {
			int[][] largeXY = Calc.multiplyMatrix(localXYBase, 10);
			polygon = new Polygon(largeXY[0], largeXY[1], 8) ;
			globX = x;
			globY=y;
			polygon.translate(globX,globY);
		}
		else {
			int[][] smallXY = Calc.multiplyMatrix(localXYBase, 4);
			polygon = new Polygon(smallXY[0], smallXY[1], 8);
			globX = x;
			globY = y;
			polygon.translate(globX,globY);
		}
		
	}
	
	public void tick() {
		polygon.translate(speedX, speedY);
		globX = globX + speedX;
		globY = globY + speedY;
	}
	
	public void destroy() {
		if (large) {
			game.getGui().pointsLowInc();
			for(int i=0; i<4; i++) {
				asteroidMang.createAsteroid(globX, globY, asteroidMang.randomSpeed(),asteroidMang.randomSpeed() , false);
			}
			large = false;
			asteroidMang.removeAsteroid(this);

		}
		else {
			game.getGui().pointsHighInc();
			asteroidMang.removeAsteroid(this);
		}
	}
	
	public Polygon getPolygon() {
		return polygon;
	}
}
