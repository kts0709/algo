package SWEA;

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
 */

public class SWEA_Solution_7701_염라대왕의이름정렬_D4_김태상_3_API정렬_TreeSet {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		for (int testcase = 1; testcase <= TC; testcase++) {
			int N = sc.nextInt();// 이름의 개수 1~20000

			TreeSet<String> name = new TreeSet<String>(new Comparator<String>() {

				public int compare(String pre, String next) {
					if (pre.length() != next.length()) {// 글자의 길이 짧은 순서
						return pre.length() - next.length();
					} else {// 길이가 같으면 사전순
						return pre.compareTo(next); // 오름차순
					}
				}
				
			});
			for (int i = 0; i < N; i++) {
				name.add(sc.next()); //중복 자동 제거
			}
			
			
			System.out.println("#"+testcase);
			for (String string : name) {
				System.out.println(string);
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