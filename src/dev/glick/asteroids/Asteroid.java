package dev.glick.asteroids;

import java.awt.Polygon;
import java.util.List;

public class Asteroid {
	private Game game;
	public Polygon polygon;
	public int globX, globY;										
	public double speedX,speedY;										
	int[] localX = {-20,0,20,0};									
	int[] localY = {20,-20,20,10};
	int[][] localXY= {{-50,-10,10,30,50,40,0,-30},{-20,-30,-40,-20,0,40,50,30}};
	
	
	public Asteroid(int speedX, int speedY) {
		polygon = new Polygon(localXY[0], localXY[1], 8) ;
		polygon.translate(500, 500);
	}
}
