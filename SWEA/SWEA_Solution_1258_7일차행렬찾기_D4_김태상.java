package SWEA;

import java.util.Arrays;
import java.util.Scanner;

public class SWEA_Solution_1258_7일차행렬찾기_D4_김태상{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		for (int testcase = 1; testcase <= t; testcase++) {
			
			int n = sc.nextInt();
			
			int[][] arr = new int[n][n];
			boolean[][] select = new boolean[n][n];
			int answer[][] = new int[10000][10];
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					arr[i][j]=sc.nextInt();
				}
			}
			int cnt=0;
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr[i].length; j++) {
					int minx=0,maxx=0;
					int miny=0,maxy=0;
					if(arr[i][j]!=0 && select[i][j]==false) {
						cnt++;
						minx=i;
						miny=j;
						for (int k = j; k < arr.length; k++) {
							if(arr[i][k]==0) {
								maxy=k;
								break;
							}
							if(k==arr.length-1) {
								maxy=k+1;
								break;
							}
						}
						
						for (int k = i; k < select.length; k++) {
							if(arr[k][j]==0 ) {
								maxx=k;
								break;
							}
							if(k==arr.length-1) {
								maxx=k+1;
								break;
							}
						}
						
						for (int k = minx; k < maxx; k++) {
							for (int k2 = miny; k2 < maxy; k2++) {
								select[k][k2]=true;
							}
						}
						
						int ans = (maxx-minx)*(maxy-miny);
						if(answer[ans][0]==0) {
							answer[ans][0] = (maxx-minx);
							answer[ans][1] = (maxy-miny);
						}else if(answer[ans][2]==0) {
							answer[ans][2] = (maxx-minx);
							answer[ans][3] = (maxy-miny);
						}
						if(answer[ans][0]>answer[ans][2]) {
							int tmpx=answer[ans][0];
							int tmpy=answer[ans][1];
							answer[ans][0] = answer[ans][2];
							answer[ans][1] = answer[ans][3];
							answer[ans][2] = tmpx;
							answer[ans][3] = tmpy;		
						}
							
					}
					
				}
			}
		
			System.out.print("#"+testcase+" "+cnt);
			for (int i =0; i <answer.length; i++) {
				for (int k = 0; k < answer[i].length; k++) {
					if(answer[i][k]!=0) System.out.print(" "+answer[i][k]);
				}
			}
			System.out.println();
			
			
			
			
		}//end of testcase
		
		
		
	}//end of main
}//end of class
