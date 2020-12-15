package SWEA;

import java.util.Scanner;

public class SWEA_Solution_1213_3일차String_D3_김태상{
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		for (int testcase = 1; testcase <= 10; testcase++) {
			
			int t = sc.nextInt();
			String search = sc.next();
			String mainStr = sc.next();
			int cnt=0;
			for (int i = 0; i <= mainStr.length()-search.length(); i++) {
				if(mainStr.charAt(i) == search.charAt(0)) {
					int j;
					for (j = 0; j < search.length(); j++) {
						if(mainStr.charAt(i+j)!=search.charAt(j))break;
					}if(j==search.length()) cnt++;
				}
			}
			
			System.out.println("#"+testcase+" "+cnt);
			
			
			
			
			
		}
		
		
		
	}//end of main
}//end of class
