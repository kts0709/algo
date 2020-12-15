package SWEA;

import java.util.Scanner;

public class SWEA_Solution_5643_키순서_D4_김태상_DFS방법 { //DFS
	static int result =0;
	static int N;
	static int M;
	static int[][] map;
	static int cnt;
	static boolean[] v;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			N=sc.nextInt();
			M=sc.nextInt();
			map= new int [N+1][N+1];
			
			for (int i = 0; i < M; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				
				map[x][y]=1;
			}
			result=0;
			
			
			//구현 : 모든 정ㅂ점에서 나보다 큰사람 수 세고 나보다 작은 사람 세고 그 합이 N-1이면 알수 있다. result++;
			for (int i = 1; i <= N; i++) {
				cnt=0;
				
				//나보다 큰 사람 세기
				v=new boolean[N+1];
				dfs(i);
				//나보다 작은 사람 세기
				v=new boolean[N+1];
				dfs1(i);
				
				if(cnt==N-1) {
					result++;
				}
				
				
			}
			System.out.println("#"+t+" "+result);
		}
		
		
	}//end of main
	private static void dfs1(int idx) {
		v[idx]=true;
		
		for (int i = 1; i <=N ; i++) {
			if(v[i]) continue;
			if(map[i][idx]==0) continue;
			cnt++;
			dfs1(i);
		}
	}
	static void dfs(int idx) {
		v[idx]=true;
		
		for (int i = 1; i <=N ; i++) {
			if(v[i]) continue;
			if(map[idx][i]==0) continue;
			cnt++;
			dfs(i);
		}
	}
	
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