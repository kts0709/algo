package SWEA;

import java.util.Scanner;
/**
 * SW Expert 5987번 달리기 
 * 사람 N명, 모든 사람의 등수가 다름 
 * M : 누가 먼저 들어왔는지에 대한 정보 
 * output: N명의 사람이 들어오는 순서로 가능한 모든 경우의 수
 * 
 * 1. 순서가 있음 -> 순열( (flag,cnt), 비트마스킹)
 * 2. 방향 flag를 알아야함
 */
public class SWEA_Solution_5987_달리기_D4_김태상_개선 {

	static int T,N,M;
	static int[] needs; // 순열을 만들기 위한 배열
	static long[] memo;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		
		for (int TC = 1; TC <= T; TC++) {
			int f, s; // 먼저 들어온사람, 나중에 들어온사람
			N = sc.nextInt();
			M = sc.nextInt();
			needs = new int[N];
			memo = new long[(1<<N)]; // 들어갈 갯수만큼 만듬ㄴ
			for (int i = 0; i < M; i++) {
				f = sc.nextInt()-1; // 인덱스로 사용하기 위하여 -1 
				s = sc.nextInt()-1;
				needs[f] |= (1<<s); // 1 2 4 8 16 32 를 넣는것
			}
			
			long r = dfs(0);
			
			System.out.println("#"+TC+" "+r);
		}// end of TC
		
	}// end of main
	private static long dfs(int flag) {
		if(flag==(1<<N)-1) {
			return 1;
		}
		if(memo[flag] > 0){ // 이미 구한적 있음 
			return memo[flag];
		}
		// 순열 
		for (int i = 0; i < N; i++) {
			// 순열
			if( (flag & 1<<i) == 0 ) { // 선택되지 않았을 경우 -> 순열
				// 순열이면서 순서까지 표시하고 싶음  예) 1+2, 2+1은 같으나 순열로 나타내면 12, 21 -> 순서
				// topologica sort,  
				if( (flag & needs[i]) == needs[i] ) { 
					// 순열 
					memo[flag] += dfs(flag | 1<<i); // 사용한것 표시하고 dfs 호출 -> 기존과 같은 효과
				}
			}
		}
		return memo[flag];
	}
}// end of class 
