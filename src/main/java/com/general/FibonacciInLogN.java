package com.general;

import java.util.Scanner;
/**
 * Calculates Fibonacci number in log(n) time
 * @author raj
 *
 */
public class FibonacciInLogN {

	public static void main(String[] args){
		
		System.out.println("Enter fibonnaci number");
		Scanner scanner = new Scanner(System.in);
		
		int n = scanner.nextInt();
		
		
		int[][] result=calculateFibonacci(n);
		System.out.println(result[1][0]);
	}
	
	
	public static int[][] calculateFibonacci(int n){
		if(n==0){
			return new int[][]{
				{0,0},
				{0,0}
			};
		}
		if(n==1){
			return new int[][]{
				{1,1},
				{1,0}
			};
		}
		int[][] left = calculateFibonacci(n/2);
		int[][] right = calculateFibonacci(n-n/2);
		
		return multiplyMatrix(left, right);
		
		
		
	}
	
	public static int[][] multiplyMatrix(int[][] a, int[][] b){
		
		int[][] result = new int[2][2];
		
		result[0][0]=a[0][0]*b[0][0] + a[0][1]*b[1][0]; 
		result[0][1]=a[0][0]*b[0][1] + a[0][1]*b[1][1]; 
		result[1][0]=a[1][0]*b[0][0] + a[1][1]*b[1][0]; 
		result[1][1]=a[1][0]*b[0][1] + a[1][1]*b[1][1]; 
		
		
		return result;
	}
}
