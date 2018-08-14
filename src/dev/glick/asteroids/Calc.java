package dev.glick.asteroids;

public class Calc {
	
	
	
		//r1 is rows in first matrix, c1 is columns in first matrix, c2 is columns on second matrix
		//r1 and c2 must be equal product will be number of rows in first matrix by columns in second
	 public static double[][] multiplyMatrices(double[][] firstMatrix, double[][] secondMatrix, int r1, int c1, int c2) {
	        double[][] product = new double[r1][c2];
	        for(int i = 0; i < r1; i++) {
	            for (int j = 0; j < c2; j++) {
	                for (int k = 0; k < c1; k++) {
	                    product[i][j] += firstMatrix[i][k] * secondMatrix[k][j];
	                }
	            }
	        }

	        return product;
	    }
	 public static int[] convertArray(double[] array) {
		 int[] intArray = new int[array.length];
		 for (int i=0; i<intArray.length; ++i) {
		     intArray[i] = (int) Math.round(array[i]);
		 }
		 return intArray;
	 }
}
