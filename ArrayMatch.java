import java.io.File;
import java.util.Scanner;

public class ArrayMatch {

	public static void main(String[] args) {
		int[] A = new int[]{10,11,8,19,11};
		
		int[] B = new int[]{10,2,8,9,3,7,4,1};
		int[] C = new int[]{10,2,8,9,4,1,4,1};
		
		int[] D = new int[]{10,2,8,9,3,7,4,1};
		int[] E = new int[]{10,10,10,2,3,7,4,1};
		
		int[] F = new int[]{10,2,8,9,3,7};
		int[] G = new int[]{10,10,10,9,3,7};
		
		int[] H = new int[]{10,2,8,9,3,7,4,1,1};
		int[] I = new int[]{10,10,10,2,3,7,4,1,1};
		
		if (match(A,A)){
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
		if (match(B,C)){
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
		if (match(D,E)){
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
		
		if (match(F,G)){
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
		
		if (match(I,H)){
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
		
	}
	
	/*
	private static boolean match(int[] A, int[] B){
		if (matchHelper(A, B)){
			System.out.println("YES");
			return true;
		} else {
			System.out.println("NO");
			return false;
		}
	}*/
	
	private static boolean match(int[] A, int[] B){
		
		if (areArraysEqual(A, B)){
			//System.out.println("YES");
			return true;
		}
		
		if (A.length % 2 != 0){
			//System.out.println("NO");
			return false;
		}
		//int n = A.length/2;
		int[] A2 = new int[A.length/2];
		int[] A3 = new int[A.length/2];
		int[] B2 = new int[B.length/2];
		int[] B3 = new int[B.length/2];
		
		split(A2,A3,A);
		split(B2,B3,B);
		//matchHelper
		return (match(A2,B2) && match(A3,B3)) || (match(A2,B2) && match(A2,B3)) || (match(A3,B2) && match(A3,B3));
		
	}
	
	private static boolean areArraysEqual(int[] A, int[] B){
				
		int i = 0; 
		boolean equal = true;
		
		while (i < A.length && equal == true){
			if (A[i] != B[i]){
				equal = false; // array is not the same or a match
			}
			i++;
		}
		return equal; // array is the same or a match
	}
	
	private static void split(int[] A, int[] B, int[] Original){
		int mid = Original.length/2;
		
		for (int i = 0; i < mid; i++){
			A[i] = Original[i];
		}
		
		for (int i = mid; i < Original.length; i++){
			B[i-mid] = Original[i];
		}
	}
}

