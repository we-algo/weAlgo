import java.util.*;
import java.io.*;
class Solution{
	static Deque <Integer> deque;
	static int n, arr[];
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int tc = Integer.parseInt(br.readLine());
		for(int test_case=1;test_case<=tc;test_case++) {
			n = Integer.parseInt(br.readLine());
			
			arr = new int[n];
			st = new StringTokenizer(br.readLine(), " ");
			for(int i=0;i<n;i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			deque = new LinkedList<>();
			Arrays.sort(arr);
			for(int i=0;i<n;i++) {
				if(i%2 == 0) {
					deque.addFirst(arr[i]);
				}else deque.addLast(arr[i]);
			}
			
			for(int i=0;i<n;i++) {
				arr[i] = deque.poll();
			}
			
			int maxNanido = Integer.MIN_VALUE;
			for(int i=0;i<n-1;i++) {
				maxNanido = Math.max(maxNanido, Math.abs(arr[i]-arr[i+1]));
			}
			maxNanido = Math.max(maxNanido, Math.abs(arr[0]-arr[n-1]));
			
			sb.append(maxNanido).append("\n");
			
		}
		System.out.println(sb);
	}
	
}
