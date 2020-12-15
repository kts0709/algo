package SWEA;

import java.util.Scanner;

public class SWEA_Solution_1231_중위순회_D4_김태상{
	public static String[] nArr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int testcase = 1; testcase <= 10; testcase++) {
			int n = sc.nextInt(); 
			nArr= new String[100];
			sc.next();
			for (int i = 1; i <= n; i++) { 
				String[] nVal= sc.nextLine().split(" ");
				nArr[i]=nVal[1];
			}
			System.out.print("#"+testcase+" ");
			inOrder(1);
			System.out.println();
		}
	
	}//end of main

	public static void inOrder(int index) {
		if(nArr[index]==null || index>=nArr.length) return;
		inOrder(index*2);
		System.out.print(nArr[index]);
		inOrder(index*2+1);
		
	}
}//end of class
