import java.util.*;

public class Monday {
    
    public int[] solution(int[] array, int[][] commands) {
        return Arrays.stream(commands)
            .mapToInt(command -> {
                int[] tempArray = Arrays.copyOfRange(array, command[0] - 1, command[1]);
                Arrays.sort(tempArray);
                return tempArray[command[2] - 1];
            })
            .toArray();
    }
}