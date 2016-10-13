package com.workshop.recursion;

public class TowerOfHanoiTest {
	public static void main(String[] args) {
		int diskCount = 3;
		towerOfHanoi(diskCount, "A", "B", "Aux");
		
	}

	private static void towerOfHanoi(int diskCount, String fromPeg,
			String toPeg, String auxPeg) {
		if(diskCount == 1){
			System.out.println("Move disk 1 from peg "+fromPeg+" to peg "+toPeg);
			return;
		}
		towerOfHanoi(diskCount-1, fromPeg, auxPeg, toPeg);
		System.out.println("Move disk from "+fromPeg+"to to peg"+toPeg);
		towerOfHanoi(diskCount-1, auxPeg,toPeg,fromPeg);
		
	}
	
}
