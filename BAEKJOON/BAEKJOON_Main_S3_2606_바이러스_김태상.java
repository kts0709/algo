package BAEKJOON;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BAEKJOON_Main_S3_2606_바이러스_김태상 {
	
	public static int computers; //총 컴퓨터 수
	public static int lines;  //간선 갯수
	public static List[] graph; // 간선을 표시한 그래프
	public static boolean[] DFSvisited;
	public static int result=0;
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		computers = sc.nextInt();
		lines = sc.nextInt();
		graph = new List[computers +1];
		DFSvisited = new boolean[computers+1];
		
		for (int i = 1; i < graph.length; i++) {
			graph[i]=new ArrayList<Integer>();
		}
		
		for (int i = 0; i < lines; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			graph[a].add(b);
			graph[b].add(a);
		}
		
//		//입력확인
//		System.out.println(Arrays.toString(graph));
		
		DFS(1);
		System.out.println(result);
	}//end of main

	private static void DFS(int i) {
		DFSvisited[i]=true;
		
		List<Integer> childs = graph[i];
		childs.sort(null);
		
		for (int j = 0; j < childs.size(); j++) {
			int child = childs.get(j);
			if(!DFSvisited[child]) {
				result++;
				DFS(child);
			}
			
		}
	}
	
}//end of class
/*
7
6
1 2
2 3
1 5
5 2
5 6
4 7
*/