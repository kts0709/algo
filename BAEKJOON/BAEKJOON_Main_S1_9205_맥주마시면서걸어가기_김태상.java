package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//BFS문제
public class BAEKJOON_Main_S1_9205_맥주마시면서걸어가기_김태상 {
	
	public static boolean XYDistance(XY store1, XY store2) { //좌표간 거리가 1000이하이면 true
		int x = Math.abs(store1.getX()-store2.getX());
		int y = Math.abs(store1.getY()-store2.getY());
		return (x+y <= 1000) ? true:false;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int testcase = Integer.parseInt(st.nextToken()); //testcase 수
		
		for (int tc = 1; tc <= testcase; tc++) {
			st=new StringTokenizer(br.readLine());
			int stores = Integer.parseInt(st.nextToken()); //편의점 수
			
			XY[] storesXY = new XY[stores+2]; //편의점들 좌표 + 집+ 페스티발 좌표
			boolean[] visited = new boolean[stores+2]; // BFS 방문확인
			
			//상근이 집 좌표 입력
			st=new StringTokenizer(br.readLine());
			int houseX = Integer.parseInt(st.nextToken()); //집x좌표
			int houseY = Integer.parseInt(st.nextToken()); //집y좌표
			storesXY[0] = new XY(houseX,houseY);
			
			//편의점 수만큼 좌표 입력
			for (int store = 1; store <= stores; store++) {//
				st=new StringTokenizer(br.readLine());
				int storeX = Integer.parseInt(st.nextToken());
				int storeY = Integer.parseInt(st.nextToken());
				storesXY[store]=new XY(storeX,storeY);
			}
			
			//페스티발 좌표 입력
			st = new StringTokenizer(br.readLine());
			int festivalX = Integer.parseInt(st.nextToken());
			int festivalY = Integer.parseInt(st.nextToken());
			storesXY[stores+1]= new XY(festivalX,festivalY);
			
//			for (int i = 0; i < storesXY.length; i++) {
//				System.out.println(storesXY[i]);
//			} //입력값 확인
			
			
			//BFS 시작
			Queue<XY> q = new LinkedList<>();
			q.add(storesXY[0]);
			visited[0]=true;
			
			while(!q.isEmpty()) {
				XY front = q.poll();
				for (int i = 1; i < storesXY.length; i++) {
					if(!visited[i] && XYDistance(front, storesXY[i])) {
						q.add(storesXY[i]);
						visited[i]=true;
					}
				}
			}//end of BFS
			
			System.out.println(visited[stores+1] ? "happy":"sad");
			
		}//end of testcase
		
	}//end of main

}//end of class

class XY { //좌표 값을 위한 클래스
	public int x;
	public int y;
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public XY(int x, int y) {
		super();
		this.x=x;
		this.y=y;
	}

	@Override
	public String toString() {
		return "XY [x=" + x + ", y=" + y + "]";
	}
	
}


//testcase
/*
2
2
0 0
1000 0
1000 1000
2000 1000
2
0 0
1000 0
2000 1000
2000 2000
*/
