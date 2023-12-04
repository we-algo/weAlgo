import java.util.*;
import java.io.*;
class Solution{
	static int arr[], M, N;
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		arr = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for(int i=1;i<N+1;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			//갱신  Math.max
		}
		
		Arrays.sort(arr);
		int start = 1; //최솟값 --- 과자길이
		int end = arr[N-1]; //최댓값
		int maxLen = 0;
		
		while (true) { //start>=end start>end ->탈출조건
			//탈출조건에 맞지않게 돌아갈수도 있는데 true -> 무한 문제 => 명확하게 작성할 필요가 있겠다는 
			int cnt = 0;
			if (start > end) {
				break;
			}
			// /zero -> 문제없었음..
			int mid = (start + end) / 2;
			
			for (int i = 0; i < arr.length; i++) {
				cnt += arr[i] / mid;//배열의 원소/중간값
			}
			
			if (cnt >= M) {
				start = mid+1;
				maxLen = Math.max(maxLen, mid);
				// 우측탐색하면 계속 갱신되므로 불필요한 연산이 된다 -> 시간초과가 만약에 들수도 있으니깐
				// 값만 초기화해서 사용하면 더 좋다!! 
				// 작은값이 나올 수 없으니깐 Math.max는 유의
			} else {
				end = mid-1;
			}
		}
		System.out.println(maxLen);
		
	}
}
