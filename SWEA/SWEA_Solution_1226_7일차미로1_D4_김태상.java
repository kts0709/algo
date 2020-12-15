package SWEA;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SWEA_Solution_1226_7일차미로1_D4_김태상{
	
	public static int[][] map = new int[16][16];
	public static int[][] visited = new int[16][16];
	public static int sx;
	public static int sy;
	

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		for (int testcase = 1; testcase <= 10; testcase++) {
			int t = sc.nextInt();
			
			for (int i = 0; i < map.length; i++) {  //input map
				String mapVal = sc.next();
				for (int j = 0; j < map.length; j++) {
					map[i][j]=Integer.valueOf(mapVal.charAt(j)-'0'); 
					visited[i][j]=Integer.valueOf(mapVal.charAt(j)-'0');
					
					if(map[i][j]==2) {
						sx=i;
						sy=j;
					}
				}
				
			}
			
			System.out.print("#"+testcase+" ");
			solve();

		}
		
		
	}//end of main

	static int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
	public static void solve() {
		  Queue<Integer> queue = new LinkedList<>();
	        queue.add(sx);
	        queue.add(sy);
	        while(!queue.isEmpty()) {
	            int x = queue.poll();
	            int y = queue.poll();
	            for(int i=0;i<4;i++) {
	                int tx = x+dir[i][0];
	                int ty = y+dir[i][1];
	                if(map[tx][ty]!=1) {
	                    if(map[tx][ty]==3) {
	                        System.out.println("1");
	                        return;
	                    }
	                    map[tx][ty] = 1;
	                    queue.add(tx);
	                    queue.add(ty);
	                }                
	            }            
	        }
	        System.out.println("0");
		
	}
}//end of class
