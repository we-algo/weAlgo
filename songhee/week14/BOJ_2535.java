import java.util.*;
import java.io.*;
class Solution{
	static int willBe[][], n, maxHappy;
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
	
		n = Integer.parseInt(br.readLine());
		willBe = new int[n][2];
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0;i<n;i++) {
			willBe[i][0] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0;i<n;i++) {
			willBe[i][1] = Integer.parseInt(st.nextToken());
		}
		
		find(0, 100, 0);
		
		System.out.println(maxHappy);
	}
	private static void find(int num, int health, int sum) {
		if(num == n) {
			maxHappy = Math.max(maxHappy, sum);
			return;
		}
		
		if(health - willBe[num][0] >0) {
			find(num+1, health-willBe[num][0], sum+willBe[num][1]);
		}
		find(num+1, health, sum);
		
	}
	
}
