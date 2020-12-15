package BAEKJOON;

import java.util.LinkedList;
import java.util.Scanner;

public class BAEKJOON_Main_S2_1260_DFS와BFS_김태상{
	
	
	public static int arr[][];
	public static boolean[] Dvisited;
	public static boolean[] Bvisited;
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int cnt= sc.nextInt();
		int start = sc.nextInt();
		arr = new int[N+1][N+1];
		Bvisited = new boolean[N+1];
		Dvisited = new boolean[N+1];
		
		for (int i = 0; i < cnt; i++) {
			int x = sc.nextInt();
			int y= sc.nextInt();
			arr[x][y]=1;
			arr[y][x]=1;
		}
		
		DFS(start);
		System.out.println();
		BFS(start);
		
		
	}//end of main

	

	private static void BFS(int start) {
		LinkedList<Integer> q = new LinkedList<>();
		q.add(start);
		Bvisited[start]=true;
		while(!q.isEmpty()) {
			int v =q.poll();
			System.out.print(v+" ");
			for (int i = 1; i < arr[v].length; i++) {
				if(arr[v][i]==1 && !Bvisited[i]) {
					q.offer(i);
					Bvisited[i]=true;
				}
			}
		}	
	}

	private static void DFS(int start) {
		System.out.print(start+" ");
		Dvisited[start]=true;
		for (int i = 0; i < arr[start].length; i++) {
			if(!Dvisited[i] && arr[start][i]==1) {
				DFS(i);
			}
		}
		
	}
}//end of class
