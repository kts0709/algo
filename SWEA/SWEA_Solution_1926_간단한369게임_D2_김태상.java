package SWEA;

import java.util.Scanner;

public class SWEA_Solution_1926_간단한369게임_D2_김태상{
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		for (int i = 1; i <= N; i++) {
			int flag=0;
			int check=i;
			while(check>0) {
				if(check%10==3 ||check%10==6 ||check%10==9) {
					System.out.print('-');
					flag=1;
				}
				check/=10;
			}
			if(flag==0) {
				System.out.print(i);
			}
			System.out.print(" ");
			
		}
	
	}//end of main
}//end of class
