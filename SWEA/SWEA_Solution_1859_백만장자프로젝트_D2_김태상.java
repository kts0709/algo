package SWEA;

import java.util.Scanner;

public class SWEA_Solution_1859_백만장자프로젝트_D2_김태상 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T= sc.nextInt();
		
		for (int testcase = 1; testcase <= T; testcase++) {
			
			int N = sc.nextInt();
			int[] arr= new int[N];
			for (int i = 0; i < arr.length; i++) {
				arr[i]=sc.nextInt();
			}
			int max=0;
			long sum=0;
			for (int i = arr.length-1; i >= 0; i--) {
				if(max<arr[i]) {
					max=arr[i];
				}else {
					int num = max-arr[i];
					sum+=num;
				}
			}
			System.out.println("#" + testcase + " " + sum);

		}
		
	}//end of main
}//end of class

/*�엯�젰
3
3
10 7 6
3
3 5 9
5
1 1 3 1 2
 */
