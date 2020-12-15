package SWEA;

import java.util.Scanner;

public class SWEA_Solution_1244_최대상금_D3_김태상{
	public static String str;
	public static char[] arr;
	public static int N;
	public static int answer;
	public static int max,flag=0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t=sc.nextInt();
		for (int testcase = 1; testcase <= t; testcase++) {
			str = sc.next();
			answer=Integer.parseInt(str); 
			arr=str.toCharArray(); 
			N=sc.nextInt();
			max=0;
			for (int i = 0; i < arr.length; i++) {
				if(max<arr[i])max=arr[i];
			}

			find(0,0);
			System.out.println("#" + testcase + " " + answer);
		}//end of testcase

	}//end of main

	public static void find(int n, int index) {

		if(n==N) {
			answer= Math.max(answer, Integer.parseInt(str));
			return;
		}else {
			for (int i = 0; i < arr.length; i++) {
				for (int j = i+1; j < arr.length; j++) {
					if(arr[i]<arr[j]) {
						swap(i,j);
						find(n+1,i);
						swap(j,i);		
					}
					
				}
			}
		}
	}

	public static void swap(int i, int j) {
		StringBuilder changeNum = new StringBuilder(str); 
		char A = str.charAt(i);
		char B = str.charAt(j);
		changeNum.setCharAt(i, B); 
		changeNum.setCharAt(j, A);
		str = changeNum.toString();
	}
	
	
	
}//end of class




//public class Z38_理쒕��긽湲�2 {
//	static int len, result;//�긽湲덇컪�쓽 湲몄씠, 蹂�寃쎈맂 �긽湲덉쓽 寃곌낵
//	static boolean[][] visit;
//
//	static int swap(int num, int a, int b) {
//		int pow1 = (int) Math.pow(10, len-a-1);//10**(len-a-1)
//		int pow2 = (int) Math.pow(10, len-b-1);
//		int digit1 = num / pow1 % 10;//�빐�떦 �옄由ъ닔 �닽�옄
//		int digit2 = num / pow2 % 10;
//		return num -digit1*pow1 + digit2*pow1 -digit2*pow2 + digit1*pow2;
//	}
//	
//	static void solve(int num, int remain) {
//		if( visit[num][remain] ) return;
//		visit[num][remain] = true;
//		if( remain == 0) {
//			if( num > result ) result = num;
//			return;
//		}
//		for(int i=0; i<len-1; i++) {
//			for(int j=i+1; j<len; j++) {
//				solve(swap(num, i, j), remain-1);
//			}
//		}
//	}
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int T = sc.nextInt();
//		for(int tc=1; tc<=T; tc++) {
//			int N = sc.nextInt();//珥덇린 �긽湲덇컪
//			int R = sc.nextInt();//援먰솚 �슏�닔
//			result = 0;//寃곌낵媛� 珥덇린�솕
//			len = String.valueOf(N).length(); //蹂�寃쎌쟾 �긽湲덇컪�쓽 湲몄씠
//			visit = new boolean[1000000][R+1];
//			solve(N, R);
//			System.out.format("#%d %d\n", tc, result);
//		}
//		sc.close();
//	}
//}
