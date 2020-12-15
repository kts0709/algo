package SWEA;

import java.util.Scanner;

public class SWEA_Solution_4408_자기방으로돌아가기_D4_김태상 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		for (int testcase = 1; testcase <= t; testcase++) {
			
			int[] map = new int[210];

			int N = sc.nextInt(); //돌아가야할 학생 수
			
			for (int i = 0; i < N; i++) {
				int startRoom=sc.nextInt();
				int endRoom=sc.nextInt();
				int sindex=0;
				int eindex=0;
				
				if(startRoom%2==0) sindex=startRoom/2-1;
				else sindex=startRoom/2;
				if(endRoom%2==0) eindex=endRoom/2-1;
				else eindex=endRoom/2;
				
				
				if(sindex<eindex) {
					for (int j = sindex; j <= eindex; j++) {
						map[j]++;
						//System.out.println(j+" : "+map[j]);
					}
				}else {
					for (int j = eindex; j <= sindex; j++) {
						map[j]++;
						//System.out.println(j+" : "+map[j]);
					}
				}

				
			}
			int max=0;
			for (int i = 0; i < map.length; i++) {
				if(map[i]>max) max=map[i];
			}
			System.out.println("#"+testcase+" "+max);
			
			
			
			
			
		}//end of testcase
		
		
		
	}//end of main
}//end of class
