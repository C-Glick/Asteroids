package dev.glick.asteroids;

public class Calc {

	public static int[][] multiplyMatrix(int[][] A,int[][] B, int r1, int c1, int c2){
		
		int[][] output= new int[r1][c2];
		 for(int i = 0; i < r1; i++) {
	            for (int j = 0; j < c2; j++) {
	                for (int k = 0; k < c1; k++) {
	                    output[i][j] += A[i][k] * B[k][j];
	                }
	            }
	        }
		System.out.println(output);
		return output;
	}
}
