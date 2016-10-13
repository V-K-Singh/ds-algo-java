package com.workshop.array;

public class ArrayOparations {

	/**
	 * Input:
	 * 	1  2  3 4 
	 *  5  6  7 8 
 	 * 	9 10 11 12 
 	 * 	13 14 15 16 
	 * Output:
	 *  4  8 12 16 
	 *  3  7 11 15 
	 *  2  6 10 14 
	 *  1  5  9 13
	 * 
	 */
	public void rotateArrayBy90DegreeAntiClockWise(int[][] a, int col){
		for(int x=0;x<(col/2);x++){
			for(int y=x; y<col-1-x;y++){
				int temp = a[x][y];
				a[x][y] = a[y][col-x-1];
				a[y][col-x-1] = a[col-x-1][col-y-1];
				a[col-x-1][col-y-1] = a[col-1-y][x]; 
				a[col-1-y][x] = temp;
			}
		}
		
	}
	/**
	 * Output:
	 * 	1  2  3 4 
	 *  5  6  7 8 
 	 * 	9 10 11 12 
 	 * 	13 14 15 16 
	 * 
	 * Input:
	 *  4  8 12 16 
	 *  3  7 11 15 
	 *  2  6 10 14 
	 *  1  5  9 13
	 * 
	 */
	public void rotateArrayBy90DegreeClockWise(int[][] a, int col) {
		for(int x=0;x<col/2;x++){
			for(int y=x;y<col-x-1;y++){
				
				int temp = a[x][y];
				
				a[x][y] = a[col-1-y][x];
				a[col-1-y][x] = a[col-x-1][col-y-1];
				a[col-x-1][col-y-1]=a[y][col-x-1];
				a[y][col-x-1]=temp;
			}
		}
	}
}
