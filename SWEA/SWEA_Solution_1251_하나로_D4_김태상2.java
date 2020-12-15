package SWEA;


import java.util.Arrays;
import java.util.Scanner;

public class SWEA_Solution_1251_하나로_D4_김태상2{
	static class Edge implements Comparable<Edge> {
		int v1;
		int v2;
		long cost;
		public Edge(int v1, int v2, long cost) {
			this.v1 = v1;
			this.v2 = v2;
			this.cost = cost;
		}
		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return Long.compare(this.cost, o.cost);
		}
	}
	
	static int[] parents;
	static int[] rank;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int test_case = 1; test_case <= T; test_case++) {
			
			int N = sc.nextInt();
			
			int[][] arr = new int[N][2];
			
			for (int i = 0; i < N; i++)
				arr[i][0] = sc.nextInt();
			for (int i = 0; i < N; i++)
				arr[i][1] = sc.nextInt();
			
			double E = sc.nextDouble();
			
			Edge[] edges = new Edge[N*(N-1)/2];
			int cnt = 0;
			for (int i = 0; i < N-1; i++) {
				for (int j = i+1; j < N; j++) {
					edges[cnt] = new Edge(i, j, dist(arr[i][0], arr[j][0], arr[i][1], arr[j][1]));
					cnt++;
				}
			}
			
			Arrays.sort(edges);
			// uion find
			parents = new int[N];
			rank = new int[N];
			for (int i = 0; i < N; i++) {
				makeSet(i);
			}
			
			long result = 0;
			cnt = 0;
			for (int i = 0; i < N*(N-1)/2; i++) {
				int v1 = findSet(edges[i].v1);
				int v2 = findSet(edges[i].v2);
				if (v1 == v2)
					continue;
				result += edges[i].cost;
				union(v1, v2);
				cnt++;
				
				if (cnt == N-1)
					break;
			}
			System.out.println("#" + test_case + " " + Math.round(result*E));
		}
			
	}
	
	static long dist(int x1, int x2, int y1, int y2) {
		return (long)(Math.pow(x1-x2, 2) + Math.pow(y1-y2, 2));
	}
	
	static void makeSet(int x) {
		parents[x] = x;
	}
	
	static int findSet(int x) {
		if (x == parents[x])
			return x;
		else {
			parents[x] = findSet(parents[x]);
			return parents[x];
		}
	}
	
	static void union(int x, int y) {
		int px = findSet(x);
		int py = findSet(y);
		if (rank[px] > rank[py]) {
			parents[py] = px;
		} else {
			parents[px] = py;
			if (rank[px] == rank[py]) {
				rank[py]++;
			}
		}
	}
}
/*
3
2
0 0
0 100
1.0
4
0 0 400 400
0 100 0 100
1.0
6
0 0 400 400 1000 2000
0 100 0 100 600 2000
0.3
*/