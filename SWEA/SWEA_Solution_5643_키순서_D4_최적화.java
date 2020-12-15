package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_Solution_5643_키순서_D4_최적화 {
    private static int[][] a;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine().trim()); // 1 <= TC <= 15
        for (int testCase = 1; testCase <= TC; testCase++) {
            int N = Integer.parseInt(br.readLine().trim()); // 학생들수, 2 <= N <= 500
            int M = Integer.parseInt(br.readLine().trim()); // 비교횟수, 0 <= M <= N*(N-1)/2
            a = new int[N+1][N+1]; // 0번 안씀, 인접행렬

            for (int i = 0; i < M; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                int small = Integer.parseInt(st.nextToken());
                int tall  = Integer.parseInt(st.nextToken());
                a[small][tall] = 1; // 단방향
            }

            for (int i = 1; i < a.length; i++) {
                up(i);
            }
            // up 연산 하면서 큰 친구들을 인접행렬에 정리하고 나면, 진입차수를 계산하면 나보다 작은 학생 수를 알수 있음 
            int totalN = 0; // 자신의 순위를 정확히 알 수 있는 학생 수
            for (int i = 1; i < a.length; i++) {
                int sum = 0;
                for (int j = 1; j < a.length; j++) {
                    sum += a[i][j] + a[j][i]; // i보다 큰 학생(진출), i보다 작은 학생(진입) 수를 누적
                }
                if (sum == N-1) { // 자신의 순위를 정확히 알 수 있으면 N-1
                    totalN++;
                }
            }
            System.out.println("#"+testCase+" "+totalN);
        } // end of for testCase
    } // end of main

public static void up(int v) {
    if (a[v][0] == -1) return; // 메모이제이션, 0번 열의 값이 -1이면 연산했다는 의미
    for (int i = 1; i < a.length; i++) {
        if (a[v][i] == 1) { // v 보다 i 가 큼
            up(i);
            for (int j = 1; j < a.length; j++) {
                a[v][j] |= a[i][j]; // 나보다 큰 학생의 인접행렬 행을 나의 행에 덮어 씀 (or 연산)
            }
        }
    }
    a[v][0] = -1; // 연산했음 표시
}
} // end of class
/*
1    
6     
7
1 2
1 4
2 3
2 4
5 2
6 1
6 5
*/