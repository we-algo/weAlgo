import java.util.*;
import java.io.*;
class Main{
	static String arr[][], copyArr[][];
	static int N;
	static boolean v[];
	static int dx[] = {-1,0,1,0};
	static int dy[] = {0, 1,0,-1};
	static List<Pair> xList, teacherList;
	static boolean findSagak, initialValue = true;
	static class Pair{
		int x;
		int y;
		Pair(int x, int y){
			this.x=x;
			this.y=y;
		}
	}
	
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		
		xList = new ArrayList<>();
		teacherList = new ArrayList<>();
		arr = new String[N][N];
		copyArr = new String[N][N];
		
		for(int i=0;i<N;i++) {
			String []s = br.readLine().split(" ");
			for(int j=0;j<N;j++) {
				arr[i][j] = s[j];
				if(arr[i][j].equals("X")) {
					xList.add(new Pair(i, j));
				}else if(arr[i][j].equals("T")) {
					teacherList.add(new Pair(i, j));
				}
			}
		}
		v = new boolean[xList.size()];
		
		find(0, 0, new ArrayList<>());
		
		if(findSagak)
			System.out.println("YES");
		else
			System.out.println("NO");
		
	}
	public static void find(int cnt, int idx, List<Pair> subList) {
		if(findSagak) {
			return;
		}
		if(cnt == 3 ) {
			initialValue = true;
			for(int i=0;i<N;i++) {
				copyArr[i] = arr[i].clone();
			}
			
			for(int i=0;i<3;i++) {
				copyArr[subList.get(i).x][subList.get(i).y] = "O";
			}
	
			for(int i=0;i<teacherList.size();i++) {
				
				find(teacherList.get(i), 0);
				find(teacherList.get(i), 1);
				find(teacherList.get(i), 2);
				find(teacherList.get(i), 3);
				
				if(!initialValue) {
					findSagak = false;
				}
				
				
			}
			
			if(initialValue) {
				findSagak = true;
			}
			
			return;
		}
		
		for(int i=0;i<xList.size();i++) { // 상우하좌 결정
			if(!v[i]) {
				v[i] = true;
				subList.add(xList.get(i));
				find(cnt+1, i+1, subList);
				subList.remove(subList.size()-1);
				v[i] = false;
			}
		}
	}
	

	public static void find(Pair pair, int direc) {
		int nx = pair.x+dx[direc];
		int ny = pair.y+dy[direc];
		
		if(nx<0 || nx>=N || ny<0 || ny>=N) return;
		if(copyArr[nx][ny].equals("O")) return;
		
		if(copyArr[nx][ny].equals("S")) {
			initialValue = false;
		}
		
		find(new Pair(nx, ny), direc);
			
	}
	
}
