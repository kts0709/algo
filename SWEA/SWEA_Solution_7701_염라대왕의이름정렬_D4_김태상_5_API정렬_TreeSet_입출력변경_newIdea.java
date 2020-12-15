package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * 
 * 정렬 - 우선순위 중복을 제거 시간이 터짐
 * API 정렬 O[NlogN]
 * 중복제거를 TreeSet  O[NlogN]
 * 
 * 
 * 아이디어 : 글자 개수에 해당하는 배열에  글자가 동일한 이름들을 TreeSet으로 사전순 정렬해보자
 * 		     글자 개수가 작은 TreeSet부터 출력하면됨
 * 		    글자의 개수가 골고루 포진되어 있을 때 시간을 많이 줄일 수 있다.
 *
 */

public class SWEA_Solution_7701_염라대왕의이름정렬_D4_김태상_5_API정렬_TreeSet_입출력변경_newIdea {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for (int testcase = 1; testcase <= TC; testcase++) {
			int N = Integer.parseInt(br.readLine());// 이름의 개수 1~20000
			
			TreeSet<String>[] tsrr = new TreeSet[51];
			for (int i = 0; i < tsrr.length; i++) {
				tsrr[i]=new TreeSet<String>(); //배열 각 칸에 생성해서 넣기
			}
			
			
			
			
			for (int i = 0; i < N; i++) {
				String str = br.readLine();
				tsrr[str.length()].add(str);
			}
			
			
			sb.append("#").append(testcase).append('\n');
			for (int i = 1; i < tsrr.length; i++) {
				for (String string : tsrr[i]) {
					sb.append(string).append('\n');
				}
			}
			

	

		} // end of testCase
		System.out.println(sb);
	}// end of main


}// end of class

/*
2
5
my
name
is
ho
seok
12
s
a
m
s
u
n
g
j
j
a
n
g
 
 * 
 */