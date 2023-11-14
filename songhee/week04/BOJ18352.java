import java.util.*;
import java.io.*;
class Solution{
	static class Pair{
		int node;
		int dist;
		Pair(int node, int dist){
			this.node = node;
			this.dist = dist;
		}
	}
	static ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
	static int n, m, k, x;
	static boolean v[];
	static int dist[];
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		v = new boolean[n+1];
		dist = new int[n+1];
		
		for(int i=0;i<n+1;i++) {
			list.add(new ArrayList<>());
			dist[i] = -1;
		}
		
		while(m-- >0) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			list.get(a).add(b);
		}
		
		find();
		
		boolean check = false;
		for(int i=1;i<n+1;i++) {
			if(dist[i] == k) {
				sb.append(i).append("\n");
				check = true;
			}
		}
		
		if(!check) sb.append(-1);
		
		System.out.println(sb);
		
	}
	public static void find() {
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(x, 0));
		dist[x] = 0;
		
		while(!q.isEmpty()) {
			Pair now = q.poll();
			
			List<Integer> sub = list.get(now.node);
			for(int i=0;i<sub.size();i++) {
				int a = sub.get(i);
				if(dist[a] == -1) {
					dist[a] = now.dist+1;
					if(dist[a] != k)
						q.add(new Pair(a, now.dist+1));
				}
			}
		}
	}
	
}
