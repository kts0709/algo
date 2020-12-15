package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class SWEA_Solution_1861_정사각형방_D4_김경재{
    public static int[] dx = {-1,1,0,0};
    public static int[] dy = {0,0,-1,1};
    public static int[][] room;
    public static int n;
    public static int startRoom;
    public static int maxMove;
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        st = new StringTokenizer(br.readLine());
        int tc = Integer.parseInt(st.nextToken());
         
        for (int testCase = 1; testCase <= tc; testCase++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
             
            room = new int[n+2][n+2];   
            maxMove = 0;    
            startRoom = Integer.MAX_VALUE;  
             
            for (int i = 1; i <= n; i++) {
                st = new StringTokenizer(br.readLine()," ");
                for (int j = 1; j <= n; j++) {
                    room[i][j] = Integer.parseInt(st.nextToken());                  
                }
            }   //input     
             
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    int curMove = DFS(i,j,1);
                    if(curMove > maxMove) {
                        maxMove = curMove;          
                        startRoom = room[i][j];
                    } else if(curMove == maxMove && startRoom > room[i][j]) {
                        startRoom = room[i][j];
                    }
                }
            }
            sb.append("#").append(testCase).append(" ").append(startRoom).append(" ").append(maxMove).append("\n");
        }//testcase
        System.out.println(sb);
    }//main
     
    public static int DFS(int i, int j, int move) {
//      System.out.println(room[i][j]);
        for (int k = 0; k < dx.length; k++) {
            int newI = i+dx[k];
            int newJ = j+dy[k];
            if(room[newI][newJ] == room[i][j] + 1) {
                return DFS(newI,newJ,move+1);
            }
        }
        return move;
    }
}