package BAEKJOON;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BAEKJOON_Main_S1_2178_미로탐색_김태상 {
	
	static int[][] arr;
	static boolean[][] visited;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,-1,0,1};
	static int N,M;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N][M];
		visited = new boolean[N][M];
		sc.nextLine();
		for (int i = 0; i < N; i++) {
			String line = sc.nextLine();
			for (int j = 0; j < M; j++) {
				arr[i][j]=line.charAt(j)-'0';
			}
		}
		
//		//입력 확인
//		for (int i = 0; i < arr.length; i++) {
//			System.out.println(Arrays.toString(visited[i]));
//		}

		BFS(0,0);
		System.out.println(arr[N-1][M-1]);
		
	}//end of main
	
	private static void BFS(int i, int j) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {i,j});
		visited[i][j] = true;
		
		while(!q.isEmpty()) {
			int location[] = q.poll();
			
			for (int k = 0; k < dx.length; k++) {
				int x = location[0]+dx[k];
				int y = location[1]+dy[k];
				
				//인덱스 에러 방지
				if(x<N && x>=0 && y<M && y>=0) {
					if(arr[x][y]!=0 && !visited[x][y]) {
						q.offer(new int[] {x,y});
						visited[x][y]=true;
						arr[x][y]=arr[location[0]][location[1]]+1;
					}
				}
				
			}
			
		}
	}
	
}//end of class

/*
4 6
101111
101010
101011
111011
 */