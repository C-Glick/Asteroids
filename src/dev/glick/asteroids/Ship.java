package dev.glick.asteroids;

import java.awt.Polygon;

public class Ship {
	private Game game;
	public Polygon polygon;
	public int globX, globY;
	public double speedX,speedY;
	public double accelX, accelY;
	public double angle;
	int[] localX = {-20,0,20,0};
	int[] localY = {-20,20,-20,-10};
	double[][] localXY= {{-20,0,20,0},{-20,20,-20,-10}};
	int[][] test= {{5,5},{1,1}};

	
	public Ship(Game game) {
		this.game = game;
		accelX=0;
		accelY=0;
		speedX=0;
		speedY=0;
		
		polygon = new Polygon(localX,localY, 4);
		}
	
	public void tick() {
		if(game.getKeyManager().up) {
			
		}
		if(game.getKeyManager().right) {
			if(angle>=360) {
				angle=0;
			}else {
				angle=angle+5;
			}
		}
		if(game.getKeyManager().left) {
			if(angle>=360) {
				angle=0;
			}else {
				angle=angle-5;
			}
		}
		if(game.getKeyManager().space) {
			
		}
		
		
		
		//rotation
		double radians = Math.toRadians(angle);
		double[][] rotationMatrix = {{Math.cos(radians), -(Math.sin(radians))},
								     {Math.sin(radians), Math.cos(radians)}};
		
		double[][] rotatedLocalXY = Calc.multiplyMatrices(rotationMatrix, localXY, 2, 2, 4);
		
		int[] rotatedX = Calc.convertArray(rotatedLocalXY[0]);
		int[] rotatedY = Calc.convertArray(rotatedLocalXY[1]);
		
		polygon = new Polygon(rotatedX,rotatedY, 4);
		
		//translation
		
		polygon.translate(globX, globY);	
	}
	
	
	public void setAngle(double input) {
		angle = input;
	}
	public void setXY(int x,int y) {
		globX = x;
		globY = y;
	}
}
