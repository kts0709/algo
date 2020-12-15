package BAEKJOON;

import java.util.Scanner;

public class BAEKJOON_Main_G4_17135_캐슬디펜스_김태상 {
	public static int N;//행
	public static int M;//열
	public static int[] archerPoint;
	public static int [][] map;
	public static int D;//공격거리제한
	public static int die=0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N=sc.nextInt();//행
		M=sc.nextInt();//열
		archerPoint = new int[3];
		map = new int[N+1][M];
		D=sc.nextInt();//공격거리제한
		
		for (int i = 0; i < map.length-1; i++) {
			for (int j = 0; j < map[i].length; j++) {
				map[i][j]=sc.nextInt();
			}
		}
		
		func(0);
		System.out.println(die);
		
	}//end of main
	public static void func(int cnt) {
		if(cnt==3) {
			int[][] nmap=new int[N+1][M];
			for (int i = 0; i < nmap.length; i++) {
					nmap[i]=map[i].clone();
			}
			
			//궁수 배치//
			for (int i = 0; i < nmap[1].length; i++) {
				nmap[N][i]=0;
			}
			for (int i = 0; i < cnt; i++) {
				nmap[N][archerPoint[i]]=2;
			}
			
			int dieNum=0;
			for (int down = 0; down < nmap.length; down++) {
				int attackindex[][]=new int[3][2];
				int aindex=0;
				for (int i = 0; i < M; i++) {
					if(nmap[N][i]==2) {
						
						int minD=999999;
						int mj=0;
						int mk=0;
						for (int j = 0; j < nmap.length-1; j++) {
							for (int k = 0; k < nmap[j].length; k++) {
								if(nmap[j][k]==1) {
									int x = Math.abs(N-j);
									int y= Math.abs(i-k);
									if(minD>x+y) {
										minD=x+y;
										mj=j;
										mk=k;
									}else if(minD==x+y&&k<mk) {
										minD=x+y;
										mj=j;
										mk=k;
									}
								}
							}
						}
						
						if(minD<=D) {
							
							attackindex[aindex][0]=mj;
							attackindex[aindex][1]=mk;
							aindex++;
						}
						
					}
				}
				for (int j = 0; j < aindex; j++) {
					if(nmap[attackindex[j][0]][attackindex[j][1]]==1) {
						nmap[attackindex[j][0]][attackindex[j][1]]=0;
						dieNum++;
					}
					
				}

				
				int[] tmp= nmap[N-1];
				for (int i = N-1; i > 0; i--) {
					nmap[i]=nmap[i-1];
				}
				nmap[0]=tmp;
				
				
				
			}
			if(die<dieNum)die=dieNum;


			return;
		}
		for (int i = (cnt==0?0:archerPoint[cnt-1]); i < M; i++) {
			archerPoint[cnt]=i;
			int j=0;
			for (j = 0; j < cnt; j++) {
				if(archerPoint[j]==archerPoint[cnt]) {
					break;
				}
			}
			
			if(j==cnt) func(cnt+1);
			
		}
	}
	
	
	
}//end of class
