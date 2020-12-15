package SWEA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class SWEA_Solution_3234_준환이의양팔저울_D4_김태상 {
	static int cnt;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		String[] s = null;
		int N = 0;
		int[] sinker = null;
		boolean[] select = null;
		
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			sinker = new int[N];
			select = new boolean[N];
			cnt = 0;
			s = br.readLine().split(" ");
			for(int i=0; i<N; i++) {
				sinker[i] = Integer.parseInt(s[i]);
			}
			dfs2(0, sinker, 0, 0, 0, select);
			bw.write("#"+t+" "+cnt+"\n");
		}
		br.close();
		bw.close();
	}
	
	static void dfs2(int depth, int[] sinker, int nSum, int left, int right, boolean[] select) {
		if(depth == sinker.length) {
			cnt++;
			return;
		}
		for(int i=0; i<sinker.length; i++) {
			if(select[i]) continue;
			select[i] = true;
			dfs2(depth+1, sinker, nSum, left+sinker[i], right, select);
			nSum = right + sinker[i];
			if(nSum <= left) {
				dfs2(depth+1, sinker, nSum, left, nSum, select);
			}
			select[i] = false;
		}
		
	}
}
/*

3
3
1 2 4
3
1 2 3
9
1 2 3 5 6 4 7 8 9
*/