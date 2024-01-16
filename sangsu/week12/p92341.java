package Programmers.lv2;

import java.util.*;

public class p92341 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{180, 5000, 10, 600},
                new String[]{"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"})));
    }

    //1시간 47분 소요, IDE 디버그의 힘을 빌림..
    public static int[] solution(int[] fees, String[] records) {
        int[] answer = {};

        Set<String> carIdList = new HashSet<>();
        Map<Car, Integer> carFeeMap = new TreeMap<>(Comparator.comparing(s -> s.carId));
        List<Car> carList = new ArrayList<>();
        List<String> carIndexList = new ArrayList<>();

        for(String record : records){
            StringTokenizer st = new StringTokenizer(record);
            int time = timeToMinute(st.nextToken());
            String carId = st.nextToken();
            String place = st.nextToken();


            if(carIdList.add(carId)){
                if(carIndexList.indexOf(carId) >= 0){
                    Car car = carList.get(carIndexList.indexOf(carId));
                    car.time = time;
                    continue;
                }
                Car car = new Car(carId, time, place);
                carIndexList.add(carId);
                carList.add(car);

            }else{
                //입차되어있기 때문에 요금정산 후 추가
                carIdList.remove(carId);
                Car car = carList.get(carIndexList.indexOf(carId));
                car.parkExit(time);
            }

        }

        carIdList.forEach(carId ->{
            Car car = carList.get(carIndexList.indexOf(carId));
            car.parkExit(timeToMinute("23:59"));
        });

        carList.forEach(car -> {
            carFeeMap.put(car, car.parkExit(fees));
        });

        ArrayList<Integer> result = new ArrayList<>(carFeeMap.values());

        return result.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }




    private static int timeToMinute(String s){
        int minute = 0;
        minute += Character.getNumericValue(s.charAt(0))*600;
        minute += Character.getNumericValue(s.charAt(1))*60;
        minute += Character.getNumericValue(s.charAt(3))*10;
        minute += Character.getNumericValue(s.charAt(4));
        return minute;
    }
}
class Car{
    String carId;
    int time;
    String place;
    int sumTime = 0;

    Car(String carId, int time, String place){
        this.carId = carId;
        this.time = time;
        this.place = place;
    }
    public void parkExit(int time){
        sumTime += time - this.time;
    }
    public int parkExit(int[] fees){
        if(fees[0] >= sumTime){//34
            return fees[1];
        }
        return fees[1] + fees[3] * (int)Math.ceil((double) (sumTime - fees[0]) /fees[2]);
    }
}
