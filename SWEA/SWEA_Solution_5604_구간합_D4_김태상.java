package SWEA;

import java.util.Scanner;

/**
 * SW Expert 5604 구간합 
 * 구간 [A, B], 구간합 : 구간에 포함되는 모든 정수의 각 자리의 합 
 * 	[8,12] = 8 + 9 + 1 + 0 + 1 + 1 + 1 + 2 = 23
 * 구간 [A,B]의 구간합을 출력
 * 
 * 10으로 나눠서 각 자리를 분리 -> 변수에 += 누적,   => 시간 터짐 
 * 
 * 배열에 0~9까지 저장해놓음 -> 뒷자리 수는 0~9가 반복 됨, 1의 자리만 먼저 구함
 * - 시작점을 주고 cnt하고 [cnt%10]을  수행하여 배열 접근 
 * 앞자리는 N/10으로 구함 -> 10~19 인 경우 1이 10개 이므로 
 * 
 * int는 구할 가짓수가 많아서( 예)9*10^18 개 ) 범위가 벗어나므로 long 사용
 * 
 * 배열로 표시했을때 뒷자리가 0~9가 다 나오는 구간 -> 직사각형 
 * 을 구함 
 */
public class SWEA_Solution_5604_구간합_D4_김태상 {
	static int T;
	static long A,B;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		
		for (int TC = 1; TC <= T; TC++) {
			A = sc.nextLong();
			B = sc.nextLong();
			long[] ans = new long[10]; //  
			long point = 1; // 자릿수를 나타냄, 일의자리, 십의자리 .... 
			while(A <= B) {
				while(B%10 != 9 && A <= B) {// 일의자리가 9가 되었는가? 
					cal(B,ans,point); // 각 자리의 합
					B--;
				}
				if(B < A)
					break;
				while(A%10 != 0 && A <= B) {
					cal(A, ans, point);
					A++;
				}
				A /= 10;
				B /= 10;
				for (int i = 0; i < 10; i++) {
					ans[i] += (B-A+1)*point;
				}
				point *= 10;
			}
			long sum = 0;
			for (int i = 0; i < 10; i++) {
				sum += (ans[i]*i);
			}
			System.out.println("#"+TC+" "+sum);
			// 소수점 구할때만 printf 사용할 것
			
		}// end of TC
		
	}// end of main

	// 각 자리의 합
	private static void cal(long x, long[] ans, long point) {
		while(x>0) { // String으로 바꾼후 한자리씩 가져옴 
			String s = String.valueOf(x);
			int xx = s.charAt(s.length()-1)-'0'; // 문자0을 빼서 숫자값으로 변환ㅁ 
			ans[xx] += point;
			x /=10;
		}
	}
}// end of class
