package BAEKJOON;

import java.util.ArrayList;
import java.util.List;

public class BAEKJOON_Main_G5_17471_게리멘더링_김태상 {
	public static void main(String[] args) {
		for (int i = 0; i < Math.pow(2,5); i++) {
            List<Integer> g1 = new ArrayList<>();
            List<Integer> g2 = new ArrayList<>();
            for (int j = 0; j < 6; j++) {
            	System.out.print(i+", "+j+" : (1 << j)"+" : "+(i & 1 << j)+"   ");
            	System.out.println(i+", "+j+" : (i & 1 << j)"+" : "+(i & 1 << j));
            	if ((i & (1 << j))>0) {
                    g1.add(j);
                } else {
                    g2.add(j);
                }
            }
            System.out.println("׷ : " + g1 + ", " + g2);
		}
	}

}//end of class
