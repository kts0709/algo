package SWEA;

import java.util.Scanner;

public class SWEA_Solution_1209_Sum_D3_김태상{
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		for (int testcase = 1; testcase <= 10; testcase++) {
			int tc=sc.nextInt();
			
			int map[][] = new int[100][100];
			
			int sumx[] = new int[100];
			int sumy[] = new int[100];
			int sumz1=0;
			int sumz2=0;
			int max=0;
			
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map.length; j++) {
					map[i][j]=sc.nextInt();
					sumx[i]+=map[i][j];
					sumy[j]+=map[i][j];
					if(max<sumx[i]) max=sumx[i];
					if(max<sumy[j]) max=sumy[j];
				}
			}
			
			for (int i = 0; i < map.length; i++) {
				sumz1+=map[i][i];
				if(max<sumz1) max=sumz1;
				sumz2+=map[i][map.length-1-i];
				if(max<sumz2) max=sumz2;
			}
			
			
			
			
			
			System.out.println("#"+tc+" "+max);
			
			
			
			
			
		}
		
		
		
	}//end of main
}//end of class
