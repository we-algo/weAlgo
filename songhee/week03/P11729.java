package com.edu.test;
import java.io.*;
import java.util.*;
public class PGS_하노이의탑 {
	public static List<List<Integer>> list = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		
		honoi(n, 1, 3, 2);
		
		int answer[][] = new int[list.size()][2];
		
		for(int i=0;i<list.size();i++) {
			for(int j=0;j<2;j++) {
				answer[i][j] = list.get(i).get(j);
			}
		}
		
		for(int i=0;i<answer.length;i++) {
			for(int j=0;j<2;j++) {
				System.out.print(answer[i][j]+", ");
			}
			System.out.println();
		}
	}
	public static void honoi(int numOfPan, int from, int to, int other) {
		if(numOfPan == 0) {
			return;
		}
		
		honoi(numOfPan-1, from, other, to);
		List<Integer> aList = new ArrayList<>();
		aList.add(from);
		aList.add(to);
		list.add(aList);
		
		honoi(numOfPan-1, other, to, from);
		
		
	}

}
