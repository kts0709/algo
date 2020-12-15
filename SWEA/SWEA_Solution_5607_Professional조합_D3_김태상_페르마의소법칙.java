package SWEA;

import java.util.Scanner;

public class SWEA_Solution_5607_Professional조합_D3_김태상_페르마의소법칙 {
	private static final int MOD = 1234567891;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int testcase = 1; testcase <= T; testcase++) {
			int N = sc.nextInt();
			int R = sc.nextInt();
			long fac[] = new long[N + 1];
            fac[0] = 1;
            for (int i = 1; i <= N; i++) fac[i] = (fac[i - 1] * i) % MOD;

            long bottom = (fac[R] * fac[N - R]) % MOD;//a
            long reBottom = fermat(bottom, MOD - 2);//a^(p-2)

            long ans =(fac[N] * reBottom) % MOD;
            System.out.println("#"+testcase+" "+ans);
			
		}

	}
	private static long fermat(long n, int x) {
        if (x == 0) return 1;
        long tmp = fermat(n, x / 2);
        long ret = (tmp * tmp) % MOD;
        if (x % 2 == 0) return ret;
        else return (ret * n) % MOD;
    }
}

