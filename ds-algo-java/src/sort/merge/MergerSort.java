package sort.merge;

import java.util.*;

import sun.security.x509.UniqueIdentity;

public class MergerSort {

	static int level;

	public static void main(String[] args) {
		// Unsorted array
//		 Integer[] a = { 2, 6, 3, 5, 1,2,5,4,3 };

		int max = 10000000;

		Integer[] a = new Integer[max];

		for (int i = 0; i < max; i++)
			a[i] = new Random().nextInt(max);

		long start = System.currentTimeMillis();
		Integer []result=removeDuplicateMergeSort(a);

		System.out.println((System.currentTimeMillis()-start));
		
//		 System.out.println("merge sort "+Arrays.toString(result));
		
		System.out.println("count of unique from merge sort"+result.length);
		
		start = System.currentTimeMillis();
		result = removeDuplicateHashSet(a);
		System.out.println((System.currentTimeMillis()-start));
		
//		System.out.println("hashset "+Arrays.toString(result));
		
		System.out.println("count of unique from set "+result.length);
		
	}

	private static Integer[] removeDuplicateHashSet(Integer[] a) {
		Integer[] unique = new Integer[a.length];

		HashSet<Integer> set = new HashSet<>();
		for (int i = 0; i < a.length; i++)
			set.add(a[i]);

		int j = 0;
		for (int i : set)
			unique[j++] = i;

		return unique;
	}

	private static Integer[] removeDuplicateMergeSort(Integer[] a) {

		Integer[] unique = new Integer[a.length];

		mergeSort(a);

		int current = a[0];
		boolean found = false;

		for (int i = 0, j = 0; i < a.length; i++) {
			if (current == a[i] && !found) {
				found = true;
			} else if (current != a[i]) {
				unique[j++] = current;
				current = a[i];
				found = false;
			}
		}

		return unique;
	}

	@SuppressWarnings("rawtypes")
	public static Comparable[] mergeSort(Comparable[] list) {
		// If list is empty; no need to do anything
		if (list.length <= 1) {
			return list;
		}

		// Split the array in half in two parts
		Comparable[] first = new Comparable[list.length / 2];
		Comparable[] second = new Comparable[list.length - first.length];
		System.arraycopy(list, 0, first, 0, first.length);
		System.arraycopy(list, first.length, second, 0, second.length);

		// Sort each half recursively
		mergeSort(first);
		mergeSort(second);

		// System.out.println(++level);
		// Merge both halves together, overwriting to original array

		merge(first, second, list);
		return list;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static void merge(Comparable[] first, Comparable[] second, Comparable[] result) {
		// Index Position in first array - starting with first element
		int iFirst = 0;

		// Index Position in second array - starting with first element
		int iSecond = 0;

		// Index Position in merged array - starting with first position
		int iMerged = 0;

		// Compare elements at iFirst and iSecond,
		// and move smaller element at iMerged
		while (iFirst < first.length && iSecond < second.length) {
			if (first[iFirst].compareTo(second[iSecond]) < 0) {
				result[iMerged] = first[iFirst];
				iFirst++;
				/*
				 * } else if (first[iFirst].compareTo(second[iSecond]) == 0){
				 * 
				 * result[iMerged] = first[iFirst]; iFirst++; iSecond++;
				 */
			} else {
				result[iMerged] = second[iSecond];
				iSecond++;
			}
			iMerged++;
		}
		// copy remaining elements from both halves - each half will have
		// already sorted elements
		System.arraycopy(first, iFirst, result, iMerged, first.length - iFirst);
		System.arraycopy(second, iSecond, result, iMerged, second.length - iSecond);
	}
}