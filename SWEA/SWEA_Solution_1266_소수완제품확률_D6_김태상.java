package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_Solution_1266_소수완제품확률_D6_김태상{

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int TC = Integer.parseInt(st.nextToken());
		int[] notSosu = { 0, 1, 4, 6, 8, 9, 10, 12, 14, 15, 16, 18 };

		for (int testCase = 1; testCase <= TC; testCase++) {
			st = new StringTokenizer(br.readLine(), " ");
			double skillOfMasterA = Integer.parseInt(st.nextToken());
			double skillOfMasterB = Integer.parseInt(st.nextToken());
			double sumA = 0;
			double sumB = 0;

			for (int i = 0; i < notSosu.length; i++) {
				sumA += Math.pow(skillOfMasterA / 100, notSosu[i])
						* Math.pow((100 - skillOfMasterA) / 100, 18 - notSosu[i]) * combi(notSosu[i]);
// System.out.println(sumA);
				sumB += Math.pow(skillOfMasterB / 100, notSosu[i])
						* Math.pow((100 - skillOfMasterB) / 100, 18 - notSosu[i]) * combi(notSosu[i]);
// System.out.println(sumB);
			}

			System.out.printf("#" + testCase + " %.6f\n", 1 - sumA * sumB);

		}

	}

	public static double combi(int x) {
		double a = 1;
		if (x == 0 || x == 18) {
// System.out.println(x+" "+a);
			return 1;
		} else {
			for (int i = 18, j = 1; j <= x; i--, j++) {
				a = a * i / j;
// System.out.println(x+" "+a);
			}
			return a;

		}
	}

}