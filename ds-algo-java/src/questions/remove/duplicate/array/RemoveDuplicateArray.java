package questions.remove.duplicate.array;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class RemoveDuplicateArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		String s = "abqxpldrhvkmzol";
		
//		System.out.println((char)detectDuplicateInStr(s));
		
//		int []a=new int[Integer.MAX_VALUE];
		
//		int []a=new int[100000];
		
		List ar=new ArrayList<>();
		
//		for(int i=0;i<100000;i++) a[i]=new Random().nextInt(10000);
		
		for(int i=0;i<100000;i++) ar.add(new Random().nextInt(100000));
		
		Collections.sort(ar);
		System.out.println(ar);
		
		System.out.println("completed");

	}

	static int detectDuplicateInStr(String str) {
		int found = -1;

		int[] hash = new int[256];

		for (int i = 0; i < 256; i++) {
			hash[i] = 0;
		}

		for (int i : str.toCharArray()) {
			if (hash[i] == 1) {
				found = i;
//				System.out.println("duplicate " + (char) i);
			} else
				hash[i]++;
		}

		return found;
	}

}
