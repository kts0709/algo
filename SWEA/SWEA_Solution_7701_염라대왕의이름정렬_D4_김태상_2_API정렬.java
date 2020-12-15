package SWEA;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * 
 * 정렬 - 우선순위 중복을 제거 시간이 터짐
 * API 정렬 O[NlogN]
 *
 */

public class SWEA_Solution_7701_염라대왕의이름정렬_D4_김태상_2_API정렬 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		for (int testcase = 1; testcase <= TC; testcase++) {
			int N = sc.nextInt();// 이름의 개수 1~20000

			String[] name = new String[N];

			for (int i = 0; i < N; i++) {
				name[i] = sc.next();
			}
			
			Arrays.sort(name,new Comparator<String>() {
				public int compare(String pre, String next) {
					if (pre.length() != next.length()) {// 글자의 길이 짧은 순서
						return pre.length() - next.length();
					} else {// 길이가 같으면 사전순
						return pre.compareTo(next); // 오름차순
					}
				}
				
			});
			
			System.out.println("#"+testcase);
			
			String temp = null;
			for (int i = 0; i < name.length; i++) {
				if(!name[i].equals(temp)) {
					System.out.println(name[i]);
				}
				temp=name[i];
			}

	

		} // end of testCase

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