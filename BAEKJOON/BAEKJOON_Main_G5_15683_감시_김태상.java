package BAEKJOON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class BAEKJOON_Main_G5_15683_감시_김태상 {
	static int N,M;
	static int[][] map;
	static int result=Integer.MAX_VALUE;
	static ArrayList<CCTV> list = new ArrayList<>();
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N=sc.nextInt();
		M=sc.nextInt();
		
		map=new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j]=sc.nextInt();
				if(1<=map[i][j] && map[i][j]<=5) {
					list.add(new CCTV(j,i,map[i][j]));
				}
			}
		}
		
		dfs(0,map);
		
		System.out.println(result);
		
	}//end of main
	
	
	
	static void dfs(int idx,int[][] nMap) { //백트래킹을 피하기 위한 nMap
		if(idx ==list.size()) {//종료
			int cnt =0;
			//사각지대 개수 세기
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(nMap[i][j]==0) {
						cnt++;
					}
				}
			}
			result=Math.min(result, cnt);
			return;
		}
		//리스트에서 cctv 뽑아서 감시  솔루션
		CCTV cctv = list.get(idx);
		int x = cctv.x;
		int y = cctv.y;
		int[][] vMap =new int[N][M];
		switch(cctv.type) {
		case 1:
			for (int d = 0; d < 4; d++) {
				//감시
				for (int i=0;i<N;i++) {
					vMap[i]=Arrays.copyOf(nMap[i], M);
				}
				
				detect(x,y,vMap,d);
				//다음 CCTV 호출
				dfs(idx+1,vMap);
				
			}
			break;
		case 2:
			for (int d = 0; d < 2; d++) {
				//감시
				for (int i=0;i<N;i++) {
					vMap[i]=Arrays.copyOf(nMap[i], M);
				}
				
				detect(x,y,vMap,d);
				detect(x,y,vMap,d+2);
				//다음 CCTV 호출
				dfs(idx+1,vMap);
				
			}
			break;
		case 3:
			for (int d = 0; d < 4; d++) {
				//감시
				for (int i=0;i<N;i++) {
					vMap[i]=Arrays.copyOf(nMap[i], M);
				}
				
				detect(x,y,vMap,d);
				detect(x,y,vMap,(d+1)%4);
				//다음 CCTV 호출
				dfs(idx+1,vMap);
				
			}
			break;
		case 4:
			for (int d = 0; d < 3; d++) {
				//감시
				for (int i=0;i<N;i++) {
					vMap[i]=Arrays.copyOf(nMap[i], M);
				}
				
				detect(x,y,vMap,d);
				detect(x,y,vMap,(d+1)%4);
				detect(x,y,vMap,(d+2)%4);
				//다음 CCTV 호출
				dfs(idx+1,vMap);
				
			}
			break;
		case 5:
			// 감시
			for (int i = 0; i < N; i++) {
				vMap[i] = Arrays.copyOf(nMap[i], M);
			}

			detect(x, y, vMap, 0);
			detect(x, y, vMap, 1);
			detect(x, y, vMap, 2);
			detect(x, y, vMap, 3);
			// 다음 CCTV 호출
			dfs(idx + 1, vMap);

			break;
		}
	}

	static void detect(int x, int y, int[][] cMap, int dir) {
		//상하좌우 감시 0:왼쪽  1:위  2:오른쪽  3:아래
		switch(dir) {
		case 0 ://왼쪽
			for(int i = x; i>=0;i--) {
				if(cMap[y][i]==6) break;
				cMap[y][i]=9;//9라는 임의의 갑으로 채우기
			}
			break;
		case 2 ://오른쪽
			for(int i = x; i<M;i++) {
				if(cMap[y][i]==6) break;
				cMap[y][i]=9;//9라는 임의의 갑으로 채우기
			}
			break;
		case 1 ://위쪽
			for(int i = y; i>=0;i--) {
				if(cMap[i][x]==6) break;
				cMap[i][x]=9;//9라는 임의의 갑으로 채우기
			}
			break;
		case 3 ://아래쪽
			for(int i = y; i<N;i++) {
				if(cMap[i][x]==6) break;
				cMap[i][x]=9;//9라는 임의의 갑으로 채우기
			}
			break;
		}
		
		
	}

	static class CCTV{
		int x,y;
		int type;
		public CCTV(int x, int y, int type) {
			super();
			this.x = x;
			this.y = y;
			this.type = type;
		}
	}//end of CCTV
	
}//end of class
/*
4 6
0 0 0 0 0 0
0 0 0 0 0 0
0 0 1 0 6 0
0 0 0 0 0 0
*/