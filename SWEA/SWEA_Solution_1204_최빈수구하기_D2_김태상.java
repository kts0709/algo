package SWEA;

import java.util.Scanner;
 
public class SWEA_Solution_1204_최빈수구하기_D2_김태상{
    public static void main(String[] args) {
       
        Scanner sc = new Scanner(System.in);
        int T=sc.nextInt();
        int[] score = new int[1000];
 
         
        for (int testCase = 0; testCase < T; testCase++) {
            int test_num=sc.nextInt();
             
            for (int i = 0; i < 1000; i++) {
                score[i] =  sc.nextInt();
            }
            int max=0;
            int many=0;
            for (int i = 0; i < 1000; i++) {
                int cnt=0;
                for (int j = 0; j < 1000; j++) {
                    if(score[i]==score[j]) {
                        cnt++;
                        }
                    }
                if(max<cnt) {
                    max=cnt;
                    many=score[i];
                }

            }
            System.out.println("#"+test_num+" "+many);
        }
    }
}