import java.util.*;
import java.io.*;
class Main{
	static class Pair{
		int x;
		int y;
		Pair(int x, int y){
			this.x=x;
			this.y=y;
		}
	}
	
	public static int H, W;
	static int dx[]= {1,0,-1,0};
	static int dy[]= {0,1,0,-1}, count;
	static char arr[][];
	static boolean v[][];
	
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int test_case = Integer.parseInt(br.readLine());
		
		for(int tc = 1;tc<=test_case;tc++) {
			
			st = new StringTokenizer(br.readLine(), " ");
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			
			arr = new char [H][W];
			v = new boolean[H][W];
			
			for(int i=0;i<H;i++) {
				String s = br.readLine();
				for(int j=0;j<W;j++) {
					arr[i][j] = s.charAt(j);
				}
			}
			
			for(int i=0;i<H;i++) {
				for(int j=0;j<W;j++) {
					if(arr[i][j] == '#' && v[i][j] == false) {
						find(i, j);
					}
				}
			}
			
			sb.append(count).append("\n");
			count = 0;
		}
		
		System.out.print(sb);
	}
	public static void find(int xid, int yid) {
		Queue<Pair> q = new LinkedList<>();
		count++;
		q.add(new Pair(xid, yid));
		
		while(!q.isEmpty()) {
			Pair pick = q.poll();
			
			for(int i=0;i<dx.length;i++) {
				int nx = dx[i] + pick.x;
				int ny = dy[i] + pick.y;
				
				if(nx<0 || nx>=H || ny<0 || ny>=W) continue;
				if(arr[nx][ny] == '#' && v[nx][ny] == false) {
					v[nx][ny] = true;
					q.add(new Pair(nx, ny));
				}
			}
		}
		
	}
	
	
}
