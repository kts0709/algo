package SWEA;

//
import java.util.Scanner;

class Solution {
	public static int[] twoBaseArr;
	public static int[] threeBaseArr;

	public static int N, M;

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		
		for (int test_case = 1; test_case <= T; test_case++) {
			// 초기화
			int ans = 0;

			// 입력부
			String twoBase = sc.next();
			String threeBase = sc.next();

			N = twoBase.length();
			M = threeBase.length();

			// int형 배열에 넣어줌
			twoBaseArr = new int[N];
			threeBaseArr = new int[M];

			for (int i = 0; i < N; i++) {
				twoBaseArr[i] = (int) (twoBase.charAt(i) - '0');
			}

			for (int i = 0; i < M; i++) {
				threeBaseArr[i] = (int) (threeBase.charAt(i) - '0');
			}

			// for문을 중첩하는 방식을 이용하여 검색
			ans = algo();

			// 출력부
			System.out.println("#" + test_case + " " + ans);

		}
	}

	// baseType 에는 2진수인지 3진수인지
	// inputNum은 해당 문자
	public static int tenBase(int[] input, int baseType) {

		// 최종 반환값
		int ret = 0;

		for (int i = 0; i < input.length; i++) {
			ret += pow(baseType, input.length - 1 - i) * input[i];
		}
		return ret;

	}

	public static int algo() {

		// dp 방식의 알고리즘
		// 2진수 값의 변환값들 저장하는 배열과 3진수 저장배열 생성
		int[] value2 = new int[N];
		int[][] value3 = new int[M][2];

		// 2진수,3진수 변환 이전 숫자 저장


		// 2진수 문자열의 글자들을 하나씩 변경
		for (int i = 0; i < N; i++) {

			int[] change2 = twoBaseArr.clone();

			// 2진수는 0이면 1로 1이면 0으로 변환
			if (twoBaseArr[i] == 0) {
				change2[i] = 1;
			}

			else {
				change2[i] = 0;
			}

			value2[i] = tenBase(change2, 2);

		}

		// 3진수는 0은 1로, 1은 2로, 2는 0으로 변환
		// 3진수는 아래 알고리즘에서 두번 변환

		for (int j = 0; j < M; j++) {

			int[] change3 = threeBaseArr.clone();

			for (int changeCnt = 0; changeCnt < 2; changeCnt++) {

				if (change3[j] == 0) {
					
					change3[j] = 1;
				}

				else if (change3[j] == 1) {

					change3[j] = 2;
				}

				else {

					change3[j] = 0;
				}

				value3[j][changeCnt] = tenBase(change3, 3);
			}			
		}
		
		
		//같은게 있으면 송금금액		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++)
				for (int cnt = 0; cnt < 2; cnt++)
					if (value2[i] == value3[j][cnt])
						return value2[i];
			
			
		}
		
		//없으면 0 리턴, 잘못 코딩한 것
		return -1;
	}

	public static int pow(int a, int b) {

		int ret = 1;

		for (int i = 0; i < b; i++)
			ret *= a;

		return ret;
	}

}