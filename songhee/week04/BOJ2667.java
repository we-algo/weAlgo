import java.util.*;
import java.io.*;
class Solution{
	static class Element{
		int x;
		int y;
		Element(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	static int n, count = 0;
	static int arr[][], dx[] = {1,0,-1,0}, dy[] = {0,1,0,-1};
	static boolean v[][];
	static List<Integer> ans;
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		
		for(int i=0;i<n;i++) {
			String s = br.readLine();
			for(int j=0;j<n;j++) {
				arr[i][j] = Character.getNumericValue(s.charAt(j));
			}
		}
		ans = new ArrayList<>();
		v = new boolean[n][n];
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(arr[i][j] == 1 && !v[i][j]) {
					count = 0;
					find(i, j);
				}
			}
		}
		
		Collections.sort(ans);
		sb.append(ans.size()).append("\n");
		for(int i=0;i<ans.size();i++) {
			sb.append(ans.get(i)).append("\n");
		}
		
		System.out.println(sb);
	}
	
	public static void find(int x, int y) {
		Queue<Element> q = new LinkedList<>();
		q.add(new Element(x, y));
		v[x][y] = true;
		
		while(!q.isEmpty()) {
			Element e = q.poll();
			count++;
			
			for(int dir = 0;dir<dx.length;dir++) {
				int nx = e.x+dx[dir];
				int ny = e.y+dy[dir];
				
				if(nx<0 || nx>=n || ny<0 || ny>=n) continue;
				if(arr[nx][ny] == 1 && v[nx][ny] == false) {
					v[nx][ny] = true;
					q.add(new Element(nx, ny));
				}
			}
		}
		
		ans.add(count);
	}
}
