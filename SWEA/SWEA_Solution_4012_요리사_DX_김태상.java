package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class SWEA_Solution_4012_요리사_DX_김태상 {
	static int N, S[][],min; 
	static boolean[] visit;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int TC = 1; TC <= T; TC++) {
			N = Integer.parseInt(br.readLine());
			S = new int[N][N];
			visit = new boolean[N];
			
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine()," ");
				for (int j = 0; j < N; j++) 
					S[i][j] = Integer.parseInt(st.nextToken());
			}
			min = Integer.MAX_VALUE; 
			comb(0,0);
			System.out.println("#"+TC+" "+min);
			
		}// end of TC
		
	}// end of main
	

		private static void comb(int cnt, int cur) {
			if(cur >= N)
				return;
			if(cnt == N/2) {
				int sum1 = 0;
				int sum0 = 0;
				for (int i = 0; i < N; i++) {
					for (int j = i+1; j < N; j++) {
						if(visit[i]!=visit[j])
							continue;
						if(visit[i])
							sum1 += S[i][j] + S[j][i];
						else
							sum0 += S[i][j] + S[j][i];
					}
				}
				min = Math.min(min, Math.abs(sum1-sum0));
				return;
			}else {
				for (int i = cur; i < N; i++) {
					visit[i] = true;
					comb(cnt+1, i+1);
					visit[i] = false;
				}
			}
			
			
		}
}// end of class
