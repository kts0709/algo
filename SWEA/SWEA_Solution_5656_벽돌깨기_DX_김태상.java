package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
/**
 * SW Expert 5656 벽돌깨기
 * W*H 크기 맵, 구슬을 N번 쏠 수 있음 
 * 벽돌 1~9로 입력, 벽돌이 맞으면 숫자만큼 십자 형태의 벽돌이 깨짐 
 *      깨지는 범위 안에 있는 벽돌의 숫자도 영향을 줌 -> 연쇄 폭발
 * 항상 맨위에 있는 벽돌만 깰 수 있음
 * 빈공간이 있을 경우 벽돌이 밑으로 떨어짐
 * 최대한 많은 벽돌을 제거했을때  남은 벽돌의 갯수(output)
 * 
 * 예제 순서가 226 -> 그럼 622도 동일? -> 아님 => 순열 
 * 서로 다른 r개 가 아니라 중복이 가능하므로 중복 순열 -> visited 안씀
 * 
 * 1. 중복 순열을 이용하여 구슬의 위치 결정 
 * 2. 위치가 결정되면 설명대로 simulation(실행) 
 * 3. 남은 벽돌의 최소값 찾는다
 * 
 * 최적화 : 중간에 더이상 구슬을 던질 필요가 없을 경우 
 *      - 벽돌이 전부 깨졌을 경우
 */
 
public class SWEA_Solution_5656_벽돌깨기_DX_김태상 {
    static StringBuilder sb = new StringBuilder();
    static int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
     
    static int T, N, C, R;
    static int brickCnt; // 현재 맵에서 가지고 있는 벽돌의 개수
    static int answer;
    static int[][] map;
     
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
         
        for (int TC = 1; TC <= T; TC++) {
            sb.append("#").append(TC).append(" ");
            //////////////////////////////////////////////
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            map = new int[R][C];
            brickCnt = 0;
            for (int r = 0; r < R; r++) {
                st = new StringTokenizer(br.readLine());
                for (int c = 0; c < C; c++) {
                    map[r][c] = Integer.parseInt(st.nextToken());
                    if(map[r][c] != 0) brickCnt++;
                }
            }
            answer = brickCnt;
             
            // 구슬을 하나씩 떨어트려 보자!!!
            // 좌표가 달라져야 한다. -> 중복 순열로 좌표 고르자
            // 벽돌의 개수 + map 전달
            dropMarble(N, brickCnt, map);
             
            sb.append(answer);
            //////////////////////////////////////////////
            sb.append("\n");
        }
        System.out.println(sb);
    }
 
    // 중복순열을 구해서 벽돌을 떨어트림
    private static void dropMarble(int r, int brickCnt, int[][] map) {
        if(r==0) {
            // 솔루션 사용
            answer = Math.min(answer, brickCnt);
            return;
        }
        for (int c = 0; c < C; c++) { // 중복 순열 
            // 1. map의 복제 
            int[][] cloned = cloneMap(map);
            // 2. 해당 칼럼의 맨 위의 벽돌 가져오기 
            Brick first = getFirstBrick(c, cloned);
            // 2-1 벽돌이 없을 경우 continue
            if(first == null) continue;
            // 3. 구슬을 떨어뜨려서 벽돌을 깬다.  -> 깨진 벽돌 개수??? 
            int broken = crash(first, cloned); // 깨진 벽돌의 수 return 받음 
            // 3-1. 벽돌이 다 깨짐 -> 정답 = 0, 종료
            if(broken >= brickCnt) {
                answer = 0;
                return;
            }
            // 4. 화면 정리
            cleanMap(cloned);
             
            // 5. 다음 샷 발사!!! 
            dropMarble(r-1, brickCnt - broken, cloned);
        }
    }
 
    // nr 과 r을 두고 r을 증가시키며 탐색해서 벽돌이면 nr과 swap
    private static void cleanMap(int[][] map) {
        for (int c = 0; c < C; c++) {
            for (int r = R-1, nr=R-1; r >= 0; r--) { // 밑에서부터 탐색
                if(map[r][c] != 0) {
                    int temp = map[r][c];
                    map[r][c] = 0;
                    map[nr--][c] = temp; // swap하고 nr을 한칸 올림 
                }
            }
        }
    }
 
    private static int crash(Brick first, int[][] map) {
        int broken = 0;
        // 얻어맞은 벽돌 삭제
        map[first.row][first.col] = 0;
        broken++;
         
        // 주변 벽돌에 영향 주기
        for (int p = 0; p < first.pow; p++) {
            // 사방 탐색 
            for (int d = 0; d < dirs.length; d++) {
                int nr = first.row + dirs[d][0] * p; // 벽돌의 숫자만큼 깸
                int nc = first.col + dirs[d][1] * p;
                 
                if(isIn(nr, nc) && map[nr][nc] != 0) {
                    broken += crash(new Brick(nr, nc, map[nr][nc]), map);
                }
            }
        }
        return broken;
    }
 
    private static boolean isIn(int r, int c) {
        return 0 <= r && 0 <= c && r < R && c < C;
    }
 
    private static Brick getFirstBrick(int c, int[][] map) {
        for (int r = 0; r < R; r++) {
            if(map[r][c] != 0) // 찾았으면 
                return new Brick(r,c,map[r][c]);
        }
        return null;
    }
 
    private static int[][] cloneMap(int[][] map) {
        int [][] temp = new int[R][C];
        for (int r = 0; r < R; r++) {
            temp[r] = map[r].clone(); // deep copy : 내용 복사, 새 객체 
            // temp[r] = map[r];  // swallow copy : 단순 레퍼런스 복사
        }
        return temp;
    }
     
    static class Brick{
        int row, col, pow;

		public Brick(int row, int col, int pow) {
			super();
			this.row = row;
			this.col = col;
			this.pow = pow;
		}

		@Override
		public String toString() {
			return "Brick [row=" + row + ", col=" + col + ", pow=" + pow + "]";
		}
        
        	
    }
}