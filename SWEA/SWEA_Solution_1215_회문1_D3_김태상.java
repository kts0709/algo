package SWEA;

import java.util.Scanner;

public class SWEA_Solution_1215_회문1_D3_김태상{
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		for (int testcase = 1; testcase <= 10; testcase++) {
			int N= sc.nextInt();
			String map[][] = new String[8][8];
			for (int i = 0; i < map.length; i++) {
				String mapval=sc.next();
				for (int j = 0; j < map.length; j++) {
					map[i][j]=String.valueOf(mapval.charAt(j));
				}
			}
			
			int cnt=0;
			
			for (int i = 0; i < map.length; i++) {            
				for (int j = 0; j <= map.length-N; j++) {
					
					int k;
					for (k = 0; k < N/2; k++) {
						if(!map[i][j+k].equals(map[i][j+N-1-k]))break;
					}
					if(k==N/2) cnt++;
					
				}
			}
			
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j <= map.length-N; j++) {
					
					int k;
					for (k = 0; k < N/2; k++) {
						if(!map[j+k][i].equals(map[j+N-1-k][i]))break;
					}
					if(k==N/2) cnt++;
				}
			}
			
			System.out.println("#"+testcase+" "+cnt);
			
			
			
		}
		
		
	}//end of main
}//end of class
