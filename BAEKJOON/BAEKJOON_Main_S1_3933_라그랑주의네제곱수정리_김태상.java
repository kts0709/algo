package BAEKJOON;

import java.util.Scanner;

public class BAEKJOON_Main_S1_3933_라그랑주의네제곱수정리_김태상 {
	public static void main(String[] args) {
		
		//System.out.println((int) Math.sqrt(15));
		
		int[] testcase = new int[10];
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < testcase.length; i++) {
			testcase[i]=sc.nextInt();
			if(testcase[i]==0) break;
			int len = (int)Math.sqrt(testcase[i]);
			
			int cnt=0;
			
			for (int j1 = 1; j1 <= len; j1++) {
				if(j1*j1==testcase[i]) {
					cnt++;
					break;
				}else if(j1*j1>testcase[i])break;
				for (int j2 = j1; j2 <= len; j2++) {
					if(j1*j1+j2*j2==testcase[i]) {
						cnt++;
						break;
					}else if(j1*j1+j2*j2>testcase[i])break;
					for (int j3 = j2; j3 <= len; j3++) {
						if(j1*j1+j2*j2+j3*j3==testcase[i]) {
							cnt++;
							break;
						}else if(j1*j1+j2*j2+j3*j3>testcase[i])break;
						for (int j4 = j3; j4 <= len; j4++) {
							if(j1*j1+j2*j2+j3*j3+j4*j4==testcase[i]) {
								cnt++;
								break;
							}else if(j1*j1+j2*j2+j3*j3+j4*j4>testcase[i])break;
						}
					}
				}		
			}
			
			
			
			
			
			
			
			System.out.println(cnt);
			
		}
		
	}//end of main

	
}//end of class
