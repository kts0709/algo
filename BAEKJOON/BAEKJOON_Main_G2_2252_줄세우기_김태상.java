package BAEKJOON;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
 
public class BAEKJOON_Main_G2_2252_줄세우기_김태상 {
 
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        
        int[] indegree = new int[N+1];
        ArrayList<Integer>[] list = new ArrayList[N+1];
        for(int i=1; i<=N; i++){
            list[i] = new ArrayList<Integer>();
        }
        for(int i=0; i<M; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            list[x].add(y);
            indegree[y]++;
        }
        
        //-----------입력 부----------------------
        
        //Topological Sorting
        Queue<Integer> queue = new LinkedList<Integer>();
        //indegree가 0일때 큐에 넣는다. indegree는 자신을 가르키고 있는 화살표의 개수
        for(int i=1; i<=N; i++){
            if(indegree[i]==0){
                queue.add(i);
            }
        }
        while(!queue.isEmpty()){
            System.out.print(queue.peek()+" ");
            int current = queue.poll();
            
            //자신이 가르키고 있는 좌표들을 방문하여 indegree값을 -1 해주고 만약 0이라면 큐에 넣어준다.
            for(int i=0; i<list[current].size(); i++){
                int next = list[current].get(i);
                indegree[next]--;
                if(indegree[next]==0){
                    queue.add(next);
                }
            }
        }
        
    }
 
}
