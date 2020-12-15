package SWEA;

import java.util.Scanner;
 
public class SWEA_Solution_2063_중간값찾기_D1_김태상{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N=sc.nextInt();
         
        int[] score = new int[N];
        for (int testCase = 0; testCase < score.length; testCase++) {
            score[testCase]=sc.nextInt();
        }
         
        int temp;
         
        for (int i = 0; i < score.length; i++) {
            for (int j = 0; j < score.length-i-1; j++) {
                if(score[j]>score[j+1]) {
                    temp=score[j];
                    score[j]=score[j+1];
                    score[j+1]=temp;
                }
            }
        }
         
 
        int result= score[(N-1)/2];
        System.out.println(result);
 
         
    }
}