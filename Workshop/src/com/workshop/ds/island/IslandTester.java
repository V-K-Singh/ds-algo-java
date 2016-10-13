package com.workshop.ds.island;

public class IslandTester {
	
	public static void main(String[] args) {
		int[][] inputArray = new int[][]{
				{1,0,1,0,0},
				{1,0,0,1,0},
				{0,0,1,0,1},
				{1,0,0,1,0},
		};
		
		Island island = new Island();
		System.out.println("Is island exist: "+island.island(inputArray, 4,5));
		System.out.println("Max size of island "+island.getMaxIslandSize());
	}

}
