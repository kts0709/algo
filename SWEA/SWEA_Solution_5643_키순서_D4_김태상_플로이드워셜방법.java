package SWEA;

import java.util.Arrays;
import java.util.Scanner;

public class SWEA_Solution_5643_키순서_D4_김태상_플로이드워셜방법 { //DFS
	static int result =0;
	static int N;
	static int M;
	static int[][] map;
	static int INF = 999_999;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			N=sc.nextInt();
			M=sc.nextInt();
			map= new int [N+1][N+1];
			for (int[] arr : map) {      //최대값으로 채우기
				Arrays.fill(arr, INF);
			}
			
			for (int i = 0; i < M; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				map[x][y]=1;
			}
			result=0;
			
			for (int k = 1; k <= N; k++) {
				for (int i = 1; i <= N; i++) {
					for (int j = 1; j <= N; j++) {
						if(map[i][j] > map[i][k]+map[k][j]){
							map[i][j] = map[i][k]+map[k][j];
						}
					}
				}
			}
			int[] counts = new int[N+1];
			for (int i = 1; i <+N ; i++) {
				for (int j = 1; j <= N; j++) {
					if(map[i][j]!=INF) {
						counts[i]++;
						counts[j]++;
					}
				}
			}
			
			for (int i = 1; i <= N; i++) {
				if(counts[i]==N-1) {
					result++;
				}
			}
			

			System.out.println("#"+t+" "+result);
		}
		
		
	}//end of main

	
}//end of class
/*
1    
6     
6      
1 5    
3 4    
5 4
4 2
4 6
5 2
*/