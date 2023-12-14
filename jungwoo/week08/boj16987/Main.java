package week08.boj16987;

import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static List<Egg> eggs;
    static int answer;

    static class Egg {
        int S;
        int W;

        public Egg(int S, int W) {
            this.S = S;
            this.W = W;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        eggs = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            eggs.add(new Egg(S, W));
        }

        dfs(0);

        System.out.println(answer);
    }

    private static void dfs(int idx) {
        if (idx == N) {
            int brokenEggCount = 0;
            for (Egg egg : eggs) {
                if (egg.S <= 0) {
                    brokenEggCount++;
                }
            }
            answer = Math.max(answer, brokenEggCount);
            return;
        }

        if (eggs.get(idx).S <= 0) {
            dfs(idx + 1);
            return;
        }

        boolean isBroken = false;
        for (int i = 0; i < N; i++) {
            if (i != idx && eggs.get(i).S > 0) {
                isBroken = true;
                eggs.get(i).S -= eggs.get(idx).W;
                eggs.get(idx).S -= eggs.get(i).W;

                dfs(idx + 1);

                eggs.get(i).S += eggs.get(idx).W;
                eggs.get(idx).S += eggs.get(i).W;
            }
        }

        if (!isBroken) {
            dfs(idx + 1);
        }
    }
}