package BAEKJOON;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;

public class BAEKJOON_Main_G4_1062_가르침_김태상 {
	public static char charSet[]; //후보군 배열
	public static boolean visit[]; //백트래킹 방문 여부 체크
	public static int n, k, wordSetSize, max = 0, candidateSize;
	public static String wordSet[]; //단어저장소

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		String line[] = in.readLine().split(" "), word;
		int i, j, w = 0, wordSize, preCount = 0;
		n = Integer.parseInt(line[0]);
		k = Integer.parseInt(line[1]);
		wordSet = new String[n]; // 추후 탐색을 위한 단어저장소
		// 후보군 해시셋(중복방지 보장)
		HashSet<Character> candidate = new HashSet<>();

		for (i = 0; i < n; i++) {
			word = in.readLine();
			/** 1번 남극어 글자들(a,n,t,i,c)을 모두 제거 **/
			word = word.replaceAll("[antic]", "");
			wordSize = word.length();
			/** 1-1번 제거 후 남은 단어의 길이가 0이면 preCount+1 **/
			if (wordSize == 0)
				preCount++;
			else {
				/** 1-2번 길이가 0보다 크다면 추후 탐색을 위한 단어저장소에 저장 **/
				wordSet[w++] = word;
				/** 1-3번 남은 단어들을 탐색 후보군에 저장 **/
				for (j = 0; j < wordSize; j++)
					candidate.add(word.charAt(j));
			}
		}
		/** 2번 만약 k < 5라면 0을 출력하고 종료 **/
		if (k < 5)
			preCount = max = 0;
		else {
			k -= 5; // 3번 k-=5. 제거한 남극어 글자만큼 가감.
			wordSetSize = w;
			candidateSize = candidate.size();
			charSet = new char[candidateSize];
			visit = new boolean[candidateSize];
			i = 0;
			/** 4번 후보군 단어들의 인덱스 접근을 위해 옮김 **/
			for (char ch : candidate)
				charSet[i++] = ch;
			/** 5번 후보군의 개수(candidateSize) < 글자의 개수(k) **/
			if (candidateSize < k)
				k = candidateSize;
			/** 6번 후보군에 있는 단어들을 하나씩 선택해가며 재귀를 이용한 백트래킹 **/
			dfs(new HashSet<>(), 0, 0);
		}
		out.write(String.valueOf(preCount + max));// 8번 최대값+preCount 출력
		out.close();
		in.close();
	}
	
	private static void dfs(HashSet<Character> picked, int idx, int pick) {
		int i, j, count = 0, wordSize;
		/**
		 * 7번 "여태까지 선택한 글자의 개수 == k"를 만족하면 단어저장소에 저장된 단어들과 비교를 해서 배울 수 있는 단어의 최대값 구함
		 **/
		if (pick == k) {
			boolean impossible;
			for (i = 0; i < wordSetSize; i++) {
				impossible = false;
				wordSize = wordSet[i].length();
				for (j = 0; j < wordSize; j++)
					if (!picked.contains(wordSet[i].charAt(j))) {
						impossible = true;
						break;
					}
				if (!impossible)
					count++;
			}
			if (max < count)
				max = count;
			return;
		}
		for (i = idx; i < candidateSize; i++)
			if (!visit[i]) {
				visit[i] = true;
				picked.add(charSet[i]);

				dfs(picked, i, pick + 1);

				visit[i] = false;
				picked.remove(charSet[i]);
			}
	}
}

/*
3 6
antarctica
antahellotica
antacartica
 */