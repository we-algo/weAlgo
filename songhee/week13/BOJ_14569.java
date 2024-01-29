import java.util.*;
import java.io.*;
class Solution2{
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
	
		int N = Integer.parseInt(br.readLine());
		Long []tutorials = new Long[N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			tutorials[i] = 0L;
			while(k-->0) {
				int a =Integer.parseInt(st.nextToken());
				tutorials[i] |= (1L<<a);
				System.out.println("tutorials"+i+" : "+tutorials[i]);
			}
		}
		//1 2 3 4 => 2, 4, 8, 16
		//000011110
		//111111110
		//000000001
		
		int studentNum = Integer.parseInt(br.readLine());
		
		for(int i=0;i<studentNum;i++) {
			st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			Long student = 0L;
			while(k-->0) {
				student |= 1L<<Integer.parseInt(st.nextToken());
			}
			student = ~student;
			int sum = 0;
			for(int j=0;j<N;j++) {
				if((student&tutorials[j]) ==0) {
					sum++;
				}
			}
			
			sb.append(sum).append("\n");
		}
		System.out.println(sb);
	}
	
}
