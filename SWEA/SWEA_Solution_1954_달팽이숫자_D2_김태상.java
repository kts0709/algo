package SWEA;

import java.util.Scanner;

public class SWEA_Solution_1954_달팽이숫자_D2_김태상{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T=sc.nextInt();
		
		for (int testcase = 1; testcase <= T; testcase++) {
		
			int N = sc.nextInt();
			int arr[][] = new int[N][N];
			
			int x=0;
			int y=-1;
			int plus=1;
			int t=N;
			int result=1;
			

			while(true) {
				if(result>N*N)break;
				for (int n= 0; n < t; n++) {
					y=y+plus;
					arr[x][y]=result++;
				}
				t--;
				for (int n = 0; n < t; n++) {
					x=x+plus;
					arr[x][y]=result++;
				}
				plus=-plus;
			}
			
			System.out.println("#"+testcase);
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr.length; j++) {
					System.out.print(arr[i][j]+" ");
				}
				System.out.println();
			}
			
			
		}

	}//end of main
}//end of class
