package SWEA;
import java.util.Arrays;
import java.util.Scanner;

public class SWEA_Solution_1861_정사각형방_D4_김태상{
	public static int[][] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		for (int testcase = 1; testcase <= t; testcase++) {
			int n = sc.nextInt();
			arr=new int[n+2][n+2];
			
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					arr[i][j]=sc.nextInt();
				}
			}
			
			
			int movemax=0;
			int startroom=Integer.MAX_VALUE;
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					int movecnt=DFS(i,j,1);	
					if(movecnt>movemax) {
						movemax=movecnt;
						startroom=arr[i][j];
					}else if(movecnt==movemax && startroom>arr[i][j]) {
						startroom=arr[i][j];
					}
				}
			}
			System.out.println("#"+testcase+" "+startroom+" "+movemax);
		}//end of testcase
		
		
		
		
	}//end of main

	public static int DFS(int arri, int arrj, int move) {
		int[][] newxy = {{-1,0},{1,0},{0,-1},{0,1}};
		for (int i = 0; i < newxy.length; i++) {
			int newi=arri+newxy[i][0];
			int newj=arrj+newxy[i][1];
			if(arr[newi][newj]==arr[arri][arrj]+1) {
				return DFS(newi,newj,move+1);
			}
		}
		
		return move;
	}
}//end of class





