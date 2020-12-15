package BAEKJOON;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BAEKJOON_Main_S1_1697_숨바꼭질_김태상 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		int min[] = new int[100005];
		Arrays.fill(min, -1); 
		System.out.println(BFS(N,K,min));
		
	}//end of main

	private static int BFS(int N, int K, int[] min) {
		int nextN = N;
		int[] status =new int[3];
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(nextN);
		min[nextN] = 0;
		
		while(!q.isEmpty() && nextN !=K) {
			nextN=q.poll();
			
			status[0]=nextN-1;
			status[1]=nextN+1;
			status[2]=nextN*2;
			
			for (int i = 0; i < status.length; i++) {
				if(status[i]>=0 && status[i]<=100000) {
					if(min[status[i]]==-1) {
						q.add(status[i]);
						min[status[i]] =min[nextN]+1;
					}
				}
			}
		}
		return min[K];
	}
	
}//end of class

//5 17