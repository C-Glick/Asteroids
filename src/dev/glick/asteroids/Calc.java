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
	 
	 public static double[][] multiplyMatrix(double[][] matrix, double factor) {
		 double[][] result = new double[matrix[0].length][matrix[1].length];
		 for (int i=0; i<matrix.length; i++) {
			 for(int k=0; k<matrix[i].length; k++) {
				 double a = matrix[i][k];
				 double x = a*factor;
				 result [i][k] =x;
			 }
		 }
		 return result;
	 }
	 
	 public static int[][] multiplyMatrix(int[][] matrix, int factor) {
		 int[][] result = new int[matrix[0].length][matrix[1].length];
		 for (int i=0; i<matrix.length; i++) {
			 for(int k=0; k<matrix[i].length; k++) {
				 int a = matrix[i][k];
				 int x = a*factor;
				 result [i][k] =x;
			 }
		 }
		 return result;
	 }
	 
	 																//convert double array to int array by rounding to int
	 public static int[] convertArray(double[] array) {
		 int[] intArray = new int[array.length];
		 for (int i=0; i<intArray.length; ++i) {
		     intArray[i] = (int) Math.round(array[i]);
		 }
		 return intArray;
	 }
}
