package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class SWEA_Solution_9659_다항식계산_D4_김태상{
	static StringBuilder sb = new StringBuilder();
	static int T;
	static int t[] = new int[100];
	static int a[] = new int[100]; 
	static int b[] = new int[100];
	static long x[] = new long[100];
	static long ans[] = new long[100];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());
		for (int testcase = 1; testcase <= T; testcase++) {
			sb.append("#").append(testcase).append(" ");
			////////////////////////////////////////////
			int N = Integer.parseInt(br.readLine());
			
			for (int i = 2; i <=N; i++) {
				st = new StringTokenizer(br.readLine());
				t[i]=Integer.parseInt(st.nextToken());
				a[i]=Integer.parseInt(st.nextToken());
				b[i]=Integer.parseInt(st.nextToken());
			}
			
			int M = Integer.parseInt(br.readLine());
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				int number=Integer.parseInt(st.nextToken());
				ans[0]=1;
				ans[1]=number;
				
				for (int j = 2; j <=N; j++) {
					if (t[j] == 1)
						ans[j] = (ans[a[j]] + ans[b[j]]) % 998244353;
					else if (t[j] == 2)
						ans[j] = (a[j] * ans[b[j]]) % 998244353;
					else if (t[j] == 3)
						ans[j] = (ans[a[j]] * ans[b[j]]) % 998244353;
					
				}
				sb.append(ans[N]).append(" ");
			}
			////////////////////////////////////////////
			sb.append("\n");
		}
		System.out.println(sb);

	}// end of main
}// end of class



/*
1
4
1 0 1
2 2 2
3 2 3
4
0 1 2 3
*/

