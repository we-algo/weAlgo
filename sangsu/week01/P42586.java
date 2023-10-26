static int[] solution(int[] progresses, int[] speeds){

        int day = 1;
        int[] dayCount = new int[100];

        for(int i = 0; i < progresses.length; i++){
            while(progresses[i] + speeds[i]*day < 100){
                day++;
            }
            dayCount[day]++;
        }

        return Arrays.stream(dayCount)
                .filter((n) -> n > 0).toArray();
    }
