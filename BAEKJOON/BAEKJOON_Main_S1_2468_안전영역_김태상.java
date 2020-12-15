package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BAEKJOON_Main_S1_2468_안전영역_김태상 {
	public static int arr[][];
	public static boolean visited[][];
	public static int N;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		
		arr = new int [N][N];
		int maxNum = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
				if(maxNum<arr[i][j]) maxNum=arr[i][j];
			}
		}

		
		
		int maxcnt = 0;
		for (int rain = 0; rain <= maxNum; rain++) {
			int cnt = 0;
			visited = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(arr[i][j]>rain && !visited[i][j]) {
						cnt++;
						dfs(i,j,rain);
					}
				}
			}
			if(maxcnt<cnt) maxcnt=cnt;
		}
		System.out.println(maxcnt);
		
		
	}//end of main
	private static void dfs(int i, int j, int rain) {
		visited[i][j]=true;
		
		int[][] xy = {{-1,0},{1,0},{0,-1},{0,1}}; 
		
		for (int k = 0; k < xy.length; k++) {
			int newi = i+xy[k][0];
			int newj = j+xy[k][1];
			
			if(newi>=0 && newj>=0 && newi<arr.length && newj<arr.length) {
				if(arr[newi][newj]>rain && !visited[newi][newj]) {
					dfs(newi,newj,rain);
				}
			}
		}
		
		
	}
}//end of class