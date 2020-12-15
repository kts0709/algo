package SWEA;

import java.util.Scanner;

public class SWEA_Solution_1491_원재의벽꾸미기_D3_김태상{
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int t=sc.nextInt();
		for (int testcase = 1; testcase <= t; testcase++) {
			
			long N = sc.nextInt();  
			long A = sc.nextInt();
			long B = sc.nextInt(); 
			long min=4444440;
			for (long R = 1; R <= N; R++) {
				for (long C = 1; C*R <= N; C++) {
					long rc = R-C;
					long nrc = N-(R*C);
					if(rc<0) rc=-rc;
					if(nrc<0) nrc=-nrc;
					
					long result=A*rc+B*nrc;
					if(result<min) min=result;
					
				}
			}
			
			System.out.println("#"+testcase+" "+min);
			
			
			
			
			
		}
		
		
		
	}//end of main
}//end of class
