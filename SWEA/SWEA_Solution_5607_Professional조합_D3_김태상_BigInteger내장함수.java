package SWEA;

import java.math.BigInteger;
import java.util.Scanner;
public class SWEA_Solution_5607_Professional조합_D3_김태상_BigInteger내장함수 {
	static Scanner sc  = new Scanner(System.in);
	static BigInteger nCrMod(int n, int r, int p) {
		long[] fact = new long[n+1];
		fact[0] = 1;
		for(int i=1; i<=n; i++) fact[i] = fact[i-1]*i % p;
		BigInteger P = BigInteger.valueOf(p);
		BigInteger A = BigInteger.valueOf(fact[n]);
		BigInteger B = BigInteger.valueOf(fact[r]).modInverse(P);
		BigInteger C = BigInteger.valueOf(fact[n-r]).modInverse(P);
		return A.multiply(B).multiply(C).remainder(P);
	}
	public static void main(String[] args) {
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			int N = sc.nextInt();
			int R = sc.nextInt();
			BigInteger res = nCrMod(N,R,1234567891);
			System.out.format("#%d %s\n", tc, res);
		}
	}
}