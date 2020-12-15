package SWEA;

import java.util.Scanner;

public class SWEA_Solution_1225_7일차암호생성기_D3_김태상{
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
	
		
		for (int testcase = 1; testcase <= 10 ; testcase++) {
			
			int arr[] = new int[8];
			int test=sc.nextInt();

			for (int i = 0; i < arr.length; i++) {
				arr[i]=sc.nextInt();
			}
			
			int i=1;
			int flag=-1;
			while(flag==-1) {
				int tmp=arr[0]-i;
				
				if(tmp<=0) {
					for (int j = 1; j < arr.length; j++) {
						arr[j-1]=arr[j];
					}
					arr[7]=0;
					
					System.out.print("#"+testcase+" ");
					for (int j = 0; j < arr.length; j++) {
						System.out.print(arr[j] + " ");
					}System.out.println();
					
					flag=0;
					
				}else {
					for (int j = 1; j < arr.length; j++) {
						arr[j-1]=arr[j];
					}
					
					arr[7]=tmp;
				}
				
				i++;
				if(i==6) i=1;

			}

		}

	}//end of main
	

	
	
}//end of class
