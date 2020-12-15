package SWEA;

import java.util.Scanner;

public class SWEA_Solution_1289_원재의메모리복구하기_D3_김태상{
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int Tc=sc.nextInt();
		
		for (int testCase = 1; testCase <= Tc; testCase++) {
			String val = sc.next();
			
			int cnt =0; 
			char pre='0';
			for (int i = 0; i < val.length(); i++) {
				if(pre != val.charAt(i)) {
					cnt++;
					pre = val.charAt(i);
				}
			}
			System.out.println("#"+testCase+" "+cnt);
		}
	}
}
