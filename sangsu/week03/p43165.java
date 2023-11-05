public class p43165 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{4, 1, 2, 1}, 4));
    }

    static boolean[] visited;
    static int[] numArrays;
    static int count = 0;
    static int targetNum;

    public static int solution(int[] numbers, int target) {
        visited = new boolean[numbers.length];
        numArrays = numbers;
        targetNum = target;

        dfs(0, 0);

        return count;
    }

    public static void dfs(int index, int sum){
        if(index == numArrays.length && sum == targetNum){
            count++;
        }

        if(index == numArrays.length){
            return;
        }

        dfs(index+1, sum+numArrays[index]);
        dfs(index+1, sum-numArrays[index]);

    }
}
