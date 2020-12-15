package SWEA;

import java.util.Scanner;

public class SWEA_Solution_2007_패턴마디의길이_D2_김태상 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int Tc = sc.nextInt();
		
		for (int testCase = 1; testCase <= Tc; testCase++) {
			String s = sc.next();
			

			int i;
			for (i = 1; i <= 15; i++) {
				String sub1 = s.substring(0,i);
				String sub2 = s.substring(i,i+i);
				if(sub1.equals(sub2)) break;
				
			}
			System.out.println("#"+testCase+" "+i);
		
		
		}// end of testCase 
	}//end of main
}//end of class
