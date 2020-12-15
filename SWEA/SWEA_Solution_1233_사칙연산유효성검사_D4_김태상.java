package SWEA;
import java.util.Scanner;

public class SWEA_Solution_1233_사칙연산유효성검사_D4_김태상{

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int testcase = 1; testcase <= 10; testcase++) {
			int size = sc.nextInt();
			int result=0;
			for (int j = 1; j <= size; j++) {
				int arr1=sc.nextInt();
				String [] arr = sc.nextLine().split(" ");
				arr[0]=String.valueOf(arr1);
				
				if(j<=size/2) {
					if(arr[1].equals("+") || arr[1].equals("-") || arr[1].equals("*") || arr[1].equals("/")) result=1;
					else result=0; 
				}else {
					if(arr[1].equals("+") || arr[1].equals("-") || arr[1].equals("*") || arr[1].equals("/")) result=0;
				}
			}
			System.out.println("#"+testcase+" "+result);
		}
	}//end of main
}//end of class