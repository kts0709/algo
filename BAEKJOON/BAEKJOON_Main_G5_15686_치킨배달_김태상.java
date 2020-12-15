package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BAEKJOON_Main_G5_15686_치킨배달_김태상 {
	
	static int N;//지도의 크기
	static int M;//남길 치킨집 개수
	
	//치킨 집들&집들을 따로 관리 --> 맵작성x --> 리스트로 관리
	static List<Point> chickenStores, homes;
	//도시의 최소 치킨거리
	static int MinchickenDist=Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer tokens = new StringTokenizer(br.readLine());
		N=Integer.parseInt(tokens.nextToken());
		M=Integer.parseInt(tokens.nextToken());
		
		//집과 치킨집 가져오기
		chickenStores=new ArrayList<>();
		homes=new ArrayList<>();
		
		for (int r = 1; r <=N; r++) {
			tokens=new StringTokenizer(br.readLine());
			for (int c = 1; c <= N; c++) {
				int info = Integer.parseInt(tokens.nextToken());
				if(info==1) {
					homes.add(new Point(r,c));
				}else if(info==2) {
					chickenStores.add(new Point(r,c));
				}
			}
		}
//		System.out.println(chickenStores);
//		System.out.println(homes);
		
		
		//전체 치킨집에서 M개 고르기
		comb(M, new Point[M],0);
		
		System.out.println(MinchickenDist);
		
	}//end of main
	
	
	//조합
	static void comb(int ti, Point[] temp, int si) {
		if(ti==0) {
			//System.out.println(Arrays.toString(temp));
			//도시의 치킨거리는?
			check(temp);
			return;	
		}else {
			for(int i=si;i<chickenStores.size();i++) {
				temp[ti-1]=chickenStores.get(i);
				comb(ti-1,temp,si+1);
			}
		}
	}

	static void check(Point[] temp) {
		int cityChickenDist=0;
		
		//각 집별로 각 치킨집과의 최소 거리를 찾아서 sum
		for(Point p : homes) {
			int chickenDist=Integer.MAX_VALUE;
			for(Point c:temp) {
				int dist=p.getDist(c);
				chickenDist=Math.min(chickenDist, dist);
			}
			cityChickenDist+=chickenDist;
		}
		MinchickenDist=Math.min(MinchickenDist, cityChickenDist);
		
	}

	static class Point{
		int row, col;

		public Point(int row, int col) {
			super();
			this.row=row;
			this.col=col;
		}
		//치킨거리
		public int getDist(Point other) {
			return Math.abs(this.row-other.row)+Math.abs(this.col-other.col);
		}
		@Override
		public String toString() {
			return "Point [row=" + row + ", col=" + col + "]";
		}
		
		
	}
	
}//end of class
/*
5 3
0 0 1 0 0
0 0 2 0 1
0 1 2 0 0
0 0 1 0 0
0 0 0 0 2
 */

