package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_Solution_5550_나는개구리로소이다_D4_김태상 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int t= Integer.parseInt(st.nextToken());

		for (int testcase = 1; testcase <= t; testcase++) {
			st = new StringTokenizer(br.readLine());
			String croak = st.nextToken();
			
			//첫번째 k찾기
			int fristK=0;
			for (int i = 0; i < croak.length(); i++) {
				if(croak.charAt(i)=='k') {
					fristK=i;
					break;
				}
			}
			
			//첫번째 k이전까지 c의 개수 찾기
			int cCnt=0;
			for (int i = 0; i < fristK; i++) {
				if(croak.charAt(i)=='c') cCnt++;
			}
			//System.out.println(cCnt);
			
			int[][] arr = new int[cCnt][5];
//			for (int i = 0; i < arr.length; i++) {
//				System.out.println(Arrays.toString(arr[i]));
//			}
			
			int c=0;
			int result=1;
ex:			for (int i = 0; i < croak.length(); i++) {
				if(croak.charAt(i)=='c') {
					for (int j = 0; j < cCnt; j++) {
						if(arr[j][0]==0) {
							arr[j][0]=1; 
							break;
						}
					}
					
				}else if(croak.charAt(i)=='r') {
					for (int j = 0; j < cCnt; j++) {
						if(arr[j][1]==0) {
							arr[j][1]=1;  
							if(arr[j][0]==0) {
								result=-1;
								break ex;
							}
							break;
						}
						
					}
				}else if(croak.charAt(i)=='o') {
					for (int j = 0; j < cCnt; j++) {
						if(arr[j][2]==0) {
							arr[j][2]=1; 
							if(arr[j][1]==0) {
								result=-1;
								break ex;
							}
							break;
						}
						
					}
				}else if(croak.charAt(i)=='a') {
					for (int j = 0; j < cCnt; j++) {
						if(arr[j][3]==0) {
							arr[j][3]=1; 
							if(arr[j][2]==0) {
								result=-1;
								break ex;
							}
							break;
						}
						
					}
				}else if(croak.charAt(i)=='k') {
					for (int j = 0; j < cCnt; j++) {
						if(arr[j][4]==0) {
							arr[j][4]=1;  
							if(arr[j][3]==0) {
								result=-1;
								break ex;
							}
							break;
						}
						
					}
				}
				
				
			}
			
			for (int j = 0; j < arr.length; j++) {
				for (int k = 0; k < arr[j].length; k++) {
					if(arr[j][k]==0) {
						result=-1;
						break;
					}
				}
			}
			
			for (int i = 0; i < arr.length; i++) {
					System.out.println(Arrays.toString(arr[i]));
			}
			System.out.println(result);
			
			
			
			
		}
		
	}//end of main
}//end of class


/*
8
crcoarkcoroakak
ccccrrrrooooaaaakkkk
karoc
croakcorakcroak
ccroak
croakcroakcroakcroakcroakcroakcroakcroakcroakcroak
ccccccccccrrrrrrrrrrooooooooooaaaaaaaaaakkkkkkkkkk
crcocrroaokacakkrocrakcorakoak

*/