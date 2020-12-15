package SWEA;

import java.util.Arrays;
import java.util.Scanner;

public class SWEA_Solution_2814_최장경로_D3_김태상 {
	public static int[][] arr;
	public static boolean visited[];
	public static int maxlen;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int testcase = 1; testcase <= t; testcase++) {
			int N=sc.nextInt(); //정점의 개수
			arr = new int[N+1][N+1];//배열 생성,index 0사용x 
			
			maxlen=0;
			int M=sc.nextInt(); //연결 노드의 개수
			for (int i = 1; i <= M; i++) {
				int x = sc.nextInt();
				int y= sc.nextInt();
				arr[x][y]=1;
				arr[y][x]=1;
			}
			for (int i = 1; i <= N; i++) {
				visited = new boolean[N+1];
				find(i,1,visited);
			}
			System.out.println("#"+testcase+" "+maxlen);

		}//end of testcase
		
	}//end of main
	
	public static void find(int index,int len, boolean[] visit) {
		visit[index]=true;
		for (int i = 1; i < arr.length; i++) {
			if(i==index)continue;
			if(visit[i])continue;
			if(arr[index][i]==0)continue;
			find(i,len+1,visit);
			visit[i]=false;
		}
		if(len>maxlen) maxlen=len;
	}
}//end of class
/*입력
1
6 5
1 2
1 3
2 4
2 5
2 6

*출력
#1 4
 */


