package com.workshop.array;

public class ArrayOperationTester {

	public static void main(String[] args) {
		int a[][] = {
				       {1, 2, 3, 4},
				       {5, 6, 7, 8},
				       {9,10, 11, 12},           
				       {13,14,15,16}};
		ArrayOparations arrayOparations = new ArrayOparations();
		System.out.println("Input array:");
		printArray(a,4);
		
		arrayOparations.rotateArrayBy90DegreeAntiClockWise(a, 4);
		System.out.println("Array after rotate-90-anticlockwise:");
		printArray(a,4);
		
		arrayOparations.rotateArrayBy90DegreeClockWise(a, 4);
		System.out.println("Array after rotate-90-clockwise:");
		printArray(a,4);
	}

	private static void printArray(int[][] a, int size) {
		for(int i=0;i<size;i++){
			for(int j=0;j<size;j++){
				System.out.print(a[i][j] +" ");
			}	
			System.out.println();
		}
	}

}
