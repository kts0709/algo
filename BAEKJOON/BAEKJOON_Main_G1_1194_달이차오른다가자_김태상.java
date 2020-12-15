package BAEKJOON;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BAEKJOON_Main_G1_1194_달이차오른다가자_김태상 {
	
	static int N,M;
	static char[][] map;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	static boolean[][][]  v;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N=sc.nextInt();
		M=sc.nextInt();
		
		map = new char[N][M];
		v=new boolean[N][M][1<<6];//비트연산자 이용
		String s="";
		Data start = null;
		for (int i = 0; i < N; i++) {
			s=sc.next();
			for (int j = 0; j < M; j++) {
				map[i][j]=s.charAt(j);
				if(map[i][j]=='0') {
					start = new Data(j,i,0,0);
				}
			}
		}
		
		int result=bfs(start);
		System.out.println(result==0?-1:result);
		
			
	}//end of main
	
	static int bfs(Data start) {
		Queue<Data> q = new LinkedList<>();
		q.offer(start);
		v[start.y][start.x][0]=true;
		Data d;
		while(!q.isEmpty()) {
			d=q.poll();
			if(map[d.y][d.x]=='1') {
				return d.cnt;
			}
			
			for (int i = 0; i < 4; i++) {
				int nx = d.x+dx[i];
				int ny = d.y+dy[i];
				int key = d.key;
				//1.범위 벗어난 것 무시
				if(nx<0||nx>=M ||ny<0||ny>=N){
					continue;
				}
				//2.벽이면 무시
				if(map[ny][nx]=='#') {
					continue;
				}
				//3.방문했던 곳 무시
				if(v[ny][nx][key]) {
					continue;
				}
				//4.키가 있으면 줍기 //////////////////////////////////////////////////////////////////
				if('a'<=map[ny][nx]&&map[ny][nx]<='f') {
					key|=(1<<(map[ny][nx]-'a'));
				}
				//5.문인데 키가 없으면 무시
				if('A'<=map[ny][nx]&&map[ny][nx]<='F') {
					if((key & (1<<(map[ny][nx]-'a'))) == 0) {
						continue;
					}
				}
				//6.방문체크하고 큐에 재삽입
				v[ny][nx][key]=true;
				q.offer(new Data(nx,ny,key,d.cnt+1));
			}
			
		}
		
		return -1;
	}

	static class Data{
		int x,y;
		int key; //
		int cnt;
		public Data(int x, int y, int key, int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.key = key;
			this.cnt = cnt;
		}
	}
	
	
	
}//end of class
/*
5 5
....1
#1###
.1.#0
....A
.1.#.
*/
