import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        //입, 출차 기록(HashSet)
        //들어온 시간(HashMap<차량번호,시간>)
        //주차요금(HashMap<차량번호,요금>)
        //들어온 차량 기록
    //메서드
        //요금계산 메서드
        //시간 -> 분 변환 메서드
        HashSet<String> innerSet = new HashSet<>();
        HashMap<String,String> inTime = new HashMap<>();
        HashMap<String,Integer> useTimeMap = new HashMap<>();
        List<String> carList = new ArrayList<>();

        for(String record : records){

            String[] recordArr = record.split(" ");
            String carNum = recordArr[1];

            if(recordArr[2].equals("IN")){
                innerSet.add(carNum);
                inTime.put(carNum, recordArr[0]);
                if(!carList.contains(carNum)){
                carList.add(carNum);
                }
            }

            if(recordArr[2].equals("OUT")){
                innerSet.remove(carNum);
                int useTime = conversionUseTime(inTime.get(carNum), recordArr[0]);
                useTimeMap.put(carNum, useTimeMap.getOrDefault(carNum, 0) + useTime);
            }

        }

        if(innerSet.size() > 0){
            for(String carNum : innerSet){
                int useTime = conversionUseTime(inTime.get(carNum), "23:59");
                useTimeMap.put(carNum, useTimeMap.getOrDefault(carNum, 0) + useTime);
            }
        }

        carList.sort(Comparator.naturalOrder());

        int[] answer = new int[useTimeMap.size()];

        for(int i = 0; i < answer.length; i++){
            String carNum = carList.get(i);
            int fee = cal(fees[0], fees[1], fees[2], fees[3], useTimeMap.get(carNum));
            answer[i] = fee;
        }
        
        return answer;
    }
    public int cal(int defaultTime, int defaultFee, int unitTime, int unitFee, int useTime){
        if(useTime <= defaultTime) return defaultFee;
        double a = (double) (useTime - defaultTime) / unitTime < 1 ? 1 : (double) (useTime - defaultTime) / unitTime;
        double fee = defaultFee + Math.ceil(a) * unitFee;
        return (int) fee;
    }

    public int conversionUseTime(String inTime, String outTime){
        String[] in = inTime.split(":");
        String[] out = outTime.split(":");
        return (Integer.parseInt(out[0]) * 60 +  Integer.parseInt(out[1])) - (Integer.parseInt(in[0]) * 60 + Integer.parseInt(in[1]));
    }
}