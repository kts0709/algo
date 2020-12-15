package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class SWEA_Solution_1868_파핑파핑지뢰찾기_D4_김태상_DFS {
	static int N;
	static char[][] map;
	static boolean[][] visit;
	// ��, ���, ��, ����, ��, ����, ��, �»�
	static int[] di = {-1, -1, 0, 1, 1, 1, 0, -1}; 
	static int[] dj = {0, 1, 1, 1, 0, -1, -1, -1}; 
	
	public static void main(String[] args) throws NumberFormatException, IOException {
//		System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int TC = 1; TC <= T; TC++) {
			N = Integer.parseInt(br.readLine());
			map = new char[N][N];
			visit = new boolean[N][N];
			
			for (int i = 0; i < N; i++) {
				String s = br.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j] = s.charAt(j);
				}
			}
			
			int ans = 0;
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(map[i][j]!= '.') continue;
					if(count(i,j)==0) { 
						ans++;
						dfs(i,j);
					}
				}
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(map[i][j]=='.') ans++;
				}
			}
			
			System.out.println("#"+TC+" "+ans);
		}// end of TC
		
		br.close();
		
	} // end of class

	private static void dfs(int i, int j) {
		visit[i][j]=true;
		int mine = count(i,j);
		map[i][j] = (char)(mine+'0');
		if(map[i][j]!='0') return;
		
		for (int d = 0; d < 8; d++) {
			int ni = i+di[d];
			int nj = j+dj[d];
			if(0<=ni && 0<=nj && ni<N && nj<N 
					&& map[ni][nj]=='.' && !visit[ni][nj])
				dfs(ni,nj);
		}
	}

	
	private static int count(int i, int j) {
		int mine = 0;
		for (int d = 0; d < 8; d++) {
			int ni = i+di[d];
			int nj = j+dj[d];
			if(0<=ni && 0<=nj && ni<N && nj<N && map[ni][nj]=='*')
				mine++;
		}
		return mine;
	}
} // end of class 
