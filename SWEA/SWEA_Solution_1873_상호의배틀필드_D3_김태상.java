package SWEA;

import java.util.Arrays;
import java.util.Scanner;

public class SWEA_Solution_1873_상호의배틀필드_D3_김태상{
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		for (int testcase = 1; testcase <= t; testcase++) {
			
			int H = sc.nextInt();
			int W = sc.nextInt();
			int starti = 0;
			int startj = 0;
			
			String[][] map = new String[H][W];
			
			for (int i = 0; i < map.length; i++) { 
				String mapVal=sc.next();
				for (int j = 0; j < map[i].length; j++) {
					map[i][j]=String.valueOf(mapVal.charAt(j));
					if(map[i][j].equals("^") || map[i][j].equals("v") || map[i][j].equals("<") || map[i][j].equals(">")) {
						starti = i;
						startj = j;
					}
				}
			}
			
			int N = sc.nextInt();
			String NVal= sc.next(); 
			String[] NValArr = new String[NVal.length()];
			for (int i = 0; i < NVal.length(); i++) {
				NValArr[i]=String.valueOf(NVal.charAt(i));
			}
			
			for (int i = 0; i < NValArr.length; i++) {
				if(NValArr[i].equals("U")) {
					map[starti][startj]="^";
					if(starti>0) {
						if( map[starti-1][startj].equals(".") ) {
							map[starti-1][startj]="^";
							map[starti][startj]=".";
							starti--;
						}
					}
				}else if(NValArr[i].equals("D")) {
					map[starti][startj]="v";
					if(starti<map.length-1) {
						if( map[starti+1][startj].equals(".") ) {
							map[starti+1][startj]="v";
							map[starti][startj]=".";
							starti++;
						}
					}
				}else if(NValArr[i].equals("L")) {
					map[starti][startj]="<";
					if(startj>0) {
						if( map[starti][startj-1].equals(".") ) {
							map[starti][startj-1]="<";
							map[starti][startj]=".";
							startj--;
						}
					}
				}else if(NValArr[i].equals("R")) {
					map[starti][startj]=">";
					
					if(startj<map[0].length-1) {
						if( map[starti][startj+1].equals(".") ) {
							map[starti][startj+1]=">";
							map[starti][startj]=".";
							startj++;
						}
					}
				}else if(NValArr[i].equals("S")) {
					if(map[starti][startj].equals("^")) {
						
						for (int j = starti; j >= 0; j--) {
							if(map[j][startj].equals("*")) {
								map[j][startj]=".";
								break;
							}
							if(map[j][startj].equals("#")) {
								break;
							}
						}
						
					}else if(map[starti][startj].equals("v")) {
						
						for (int j = starti; j < map.length; j++) {
							if(map[j][startj].equals("*")) {
								map[j][startj]=".";
								break;
							}
							if(map[j][startj].equals("#")) {
								break;
							}
						}
						
					}else if(map[starti][startj].equals("<")) {
						
						for (int j = startj; j >= 0; j--) {
							if(map[starti][j].equals("*")) {
								map[starti][j]=".";
								break;
							}
							if(map[starti][j].equals("#")) {
								break;
							}
						}
						
					}else if(map[starti][startj].equals(">")) {
						
						for (int j = startj; j < map[0].length; j++) {
							if(map[starti][j].equals("*")) {
								map[starti][j]=".";
								break;
							}
							if(map[starti][j].equals("#")) {
								break;
							}
						}
						
					}
				}
				
			}
			
			System.out.print("#"+testcase+" ");
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[i].length; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
			

			
			
		}
	
		
	}//end of main
}//end of class
