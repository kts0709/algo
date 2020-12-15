package SWEA;
import java.util.Scanner;

public class SWEA_Solution_1210_Ladder1_D4_김태상{
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int tc = 1; tc <= 10; tc++) {
            int t = sc.nextInt();
            int[][] map = new int[100][100];
            for (int i = 0; i < map.length; i++) { 
                for (int j = 0; j < map.length; j++) {
                    map[i][j] = sc.nextInt();
                }
            }
            
            
            int index = 0;
            int start = 0; 
            
            for (int j = 0; j < map.length; j++) {
                if(map[99][j] == 2)
                    start = j;
            } 
            
            for(int i = 98; i > 0; i--) { 
                if(start-1 >= 0) {  
                    if(map[i][start-1] == 1) { 
                        while(true) {
                            if(start >= 0 && map[i][start] == 1) { 
                                start--;
                            }
                            else {
                                index = start+1; 
                                break;
                            }
                        }
                        start = index; 
                        continue;
                    }
                }
                
                if(start+1 <= 99) {
                    if(map[i][start+1] == 1) { 
                        while(true) {
                            if(start <= 99 && map[i][start] == 1) {
                                start++;
                            }
                            else {
                                index = start-1;
                                break;
                            }
                        }
                        start = index;
                        continue;
                    }
                }
            }
            System.out.println("#" + tc + " " + start);
        }
    }
}
