import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Solution3 {
	static int totalNums = 0, questionNum;
	static int minHyeok[][], score[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		questionNum = Integer.parseInt(br.readLine());
		
		minHyeok = new int[questionNum][3];
		score = new int[questionNum][2];
		
		for(int i=0;i<questionNum;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int threeNums = Integer.parseInt(st.nextToken());
			int strike = Integer.parseInt(st.nextToken());
			int ball = Integer.parseInt(st.nextToken());
			score[i][0] = strike; score[i][1] = ball;
			int idx = 2;
			while(threeNums != 0) {
				minHyeok[i][idx--] = threeNums%10;//123 1 2 3
				threeNums /= 10;
			}
		}
		
		find();
		
		
		System.out.println(totalNums); 
	}

	public static void find() {
		for(int i=1;i<10;i++) {
			for(int j=1;j<10;j++) {
				for(int k=1;k<10;k++) {
					if(i == j || j== k || i==k) continue; 
					if(check(i,j,k)) {
						totalNums++;
					}
				}
			}
		}
	}

	private static boolean check(int a, int b, int c) {		
		for(int i=0;i<questionNum;i++) {
			int n1 = minHyeok[i][0];
			int n2 = minHyeok[i][1];
			int n3 = minHyeok[i][2];
			
			int strike = score[i][0];
			int ball = score[i][1];
			
			int totalStrike=0; int totalBall = 0;
			if(a == n1) totalStrike++;
			else if(a == n2 || a == n3) totalBall++;
			
			if(b == n2) totalStrike++;
			else if(b == n1 || b == n3) totalBall++;
			
			if(c == n3) totalStrike++;
			else if(c == n1 || c == n2) totalBall++;
			
			if(totalStrike != strike || totalBall != ball) {
				return false;
			}
		}
		return true;
	}
}
