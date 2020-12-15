package SWEA;

import java.util.Arrays;
import java.util.Scanner;

public class SWEA_Solution_2805_농작물수확하기_D3_김태상 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int t= sc.nextInt();
		
		for (int testcase = 1; testcase <= t; testcase++) {
			int N = sc.nextInt();//map 크기
			
			int[][] map = new int[N][N];  //map만들기
			for (int i = 0; i < N; i++) {  
				String imap = sc.next();
				for (int j = 0; j < imap.length(); j++) {
					map[i][j]=Integer.valueOf(imap.charAt(j)-'0');
				}
			}
			int sum=0;
			for (int i = 0; i < (N+1)/2; i++) {//N=5일때 x=0~2
				for (int j = (N+1)/2-1-i; j < (N+1)/2+i; j++) {
					sum+=map[i][j];
				}
			}
			for (int i = 1; i <= N-(N+1)/2; i++) { //x=3~4
				for (int j = i ; j <N-i ; j++) {
					sum+=map[(N+1)/2-1+i][j];
				}
			}
			
			System.out.println("#"+testcase+" "+sum);
			
			
		}
		
		
	}//end of main
}//end of class



