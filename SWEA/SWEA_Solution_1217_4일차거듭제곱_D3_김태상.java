package SWEA;

import java.util.Scanner;

public class SWEA_Solution_1217_4일차거듭제곱_D3_김태상{
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		for (int testcase = 1; testcase <= 10; testcase++) {
			int t= sc.nextInt();
			int N= sc.nextInt();
			int M= sc.nextInt();
			
			System.out.print("#"+testcase+" ");
			pow(N,M,0,1);
			
		}
		
	}//end of main

	public static void pow(int n, int m,int cnt,int result) {
		if(cnt==m) {
			System.out.println(result);
			return;
		}
		result=result*n;
		cnt++;
		pow(n,m,cnt,result);
	}
}//end of class
