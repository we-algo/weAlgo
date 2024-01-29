import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Solution5 {
	static long minNum = Long.MAX_VALUE, maxNum = 0;
	static String minString = "", maxString = "";
	static int k, num[];
	static boolean v[];
	static String[] relation;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		k = Integer.parseInt(br.readLine());
		relation = new String[k];
		num = new int[k+1];
		v = new boolean[10];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<k;i++) {
			relation[i] = st.nextToken();
		}
		
		find(0);
		sb.append(maxString).append("\n");
		sb.append(minString).append("\n");
		System.out.println(sb);
	}

	private static void find(int idx) {//StringBuilder 
		if(idx == k+1) {
			String sum = "";
			for(int i=0;i<k+1;i++) {
				sum += String.valueOf(num[i]);
			}
			Long result = Long.parseLong(sum);
			if(maxNum<result) {
				maxString = sum; maxNum = result;
			}
			if(minNum>result) {
				minString = sum; minNum = result;
			}
			return;
		}
		
		for(int i=0;i<10;i++) {
			if(!v[i]) {
				if(idx == 0) {
					check(i, idx);
				}else {
					// 0 1 2
					// < > 
					// 1 2 3
					String rel = relation[idx-1];
					if(rel.equals("<")) {
						if(num[idx-1] < i) {
							check(i, idx);
						}
					}else if(rel.equals(">")) {
						if(num[idx-1] > i) {
							check(i, idx);
						}
					}
				}
			}
		}
	}

	private static void check(int i, int idx) {
		v[i] = true;
		num[idx] = i;
		find(idx+1);
		v[i] = false;
	}
	

}
