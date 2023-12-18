import java.io.*;
import java.util.*;

public class p16987 {

    static int n;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        ArrayList<Egg> eggList = new ArrayList<>();
        StringTokenizer st;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            eggList.add(
                    new Egg(
                            Integer.parseInt(st.nextToken()),
                            Integer.parseInt(st.nextToken())
                    )
            );
        }

        if (n == 1) {
            System.out.println(0);
            return;
        }
        boolean[] visited = new boolean[n];
        dfs(eggList, 0, 0);

        System.out.println(max);

    }

    public static void dfs(List<Egg> prevEggList, int index, int depth) {
        if (depth == n) {
            //전체 브로큰 횟수 출력
            max = Integer.max(brokenCount(prevEggList), max);
            return;
        }

        for (int i = 0; i < n; i++) {
            List<Egg> nowEggList = deepCopy(prevEggList);
            Egg nowEgg = nowEggList.get(depth);
            if (i != depth) {
                nowEgg.breakEgg(nowEggList.get(i));
                dfs(nowEggList, 0, depth + 1);
            }
        }

    }

    static int brokenCount(List<Egg> eggList) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (eggList.get(i).isBroken()) {
                count++;
            }
        }
        return count;
    }

    static class Egg {
        int durability;
        int weight;

        Egg(int durability, int weight) {
            this.durability = durability;
            this.weight = weight;
        }

        public void breakEgg(Egg egg) {
            if (!egg.isBroken() && !this.isBroken()) {
                attackEgg(egg);
            }
        }

        private void attackEgg(Egg egg) {
            int a = this.weight;
            int b = egg.weight;
            this.durability -= b;
            egg.durability -= a;
        }

        private boolean isBroken() {
            if (durability <= 0) {
                return true;
            }
            return false;
        }

    }

    public static List<Egg> deepCopy(List<Egg> eggList) {
        ArrayList<Egg> tempList = new ArrayList<>();
        for (int i = 0; i < eggList.size(); i++) {
            Egg temp = eggList.get(i);
            tempList.add(new Egg(temp.durability, temp.weight));
        }
        return tempList;
    }
}
