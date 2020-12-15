package BAEKJOON;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BAEKJOON_Main_S1_7576_토마토_김태상 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N= sc.nextInt();
		int M=sc.nextInt();
		int map[][] = new int[M+2][N+2];
		
		for (int i = 1; i < map.length-1; i++) {
			for (int j = 1; j < map[i].length-1; j++) {
				map[i][j]=sc.nextInt();
			}
		}
		for (int i = 0; i < map.length; i=i+map.length-1) {
			for (int j = 0; j < map[i].length; j++) {
				map[i][j]=5;
			}
		}
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j=j+map[i].length-1) {
				map[i][j]=5;
			}
		}
		

		
		Queue<int[]> q=new LinkedList<int[]>();
		for (int i = 1; i < map.length-1; i++) {
			for (int j = 1; j < map[i].length-1; j++) {
				if(map[i][j]==1) {
					q.add(new int[]{i,j});
				}
			}
		}

		int cnt=0;
		while(!q.isEmpty()) {
			int qsize = q.size();
			int[][] qpoll= new int[qsize][2];
			int flag=0;
			for (int i = 0; i < qsize; i++) {
				qpoll[i] = q.poll();
			}
			for (int i = 0; i < qpoll.length; i++) {
				int x=qpoll[i][0];
				int y=qpoll[i][1];
				
				int[][] xy= {{-1,0},{1,0},{0,-1},{0,1}};
				for (int j = 0; j < xy.length; j++) {
					int newx=x+xy[j][0];
					int newy=y+xy[j][1];
					if(map[newx][newy]==0) {
						map[newx][newy]=1;
						q.add(new int[] {newx,newy});
						flag=1;
					}
				}
			}
			if(flag==1) cnt++;
			
		}
		int i=0;
		int result=0;
ex:		for (i = 1; i < map.length-1; i++) {
			for (int j = 1; j < map[i].length-1; j++) {
				if(map[i][j]==0) {
					result=-1;
					break ex;
				}
			}
		}
		if(result==-1) System.out.println(result);
		else System.out.println(cnt);
		

		
		
		
	}//end of main
}//end of class

