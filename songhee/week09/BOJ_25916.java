import java.util.*;
import java.io.*;
class Solution{
	static int arr[], N, M;
	static long sum[], max;
	
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N+1];
		sum = new long[N+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i=1;i<N+1;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			sum[i] = sum[i-1]+arr[i];
		}
		
		int right = 1;
		int left = 1;
		
		while(right<=N) {
			if(sum[right]-sum[left-1]<=M) {
				max = Math.max(max, sum[right]-sum[left-1]);
				right++;
			}else {
				if(left == right) {
					left++; right++;
				}else {
					left++;
				}
			}
		}
		
		System.out.println(max);
		
	}
}
