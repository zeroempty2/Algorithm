import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        List<HashMap<String,Integer>> reportList = new ArrayList<>();
        HashMap<String,Integer> nameMap = new HashMap<>();
        int[] answer = new int[id_list.length];
        for(int i = 0; i < id_list.length; i++){
           HashMap<String,Integer> reportMap = new HashMap<>();
           nameMap.put(id_list[i],i);
           reportList.add(reportMap);
        }
        for(int j = 0; j < report.length; j++){
            int reportedManIndex = nameMap.get(report[j].split(" ")[1]);
            int reportManIndex = nameMap.get(report[j].split(" ")[0]);
            String reportMan = report[j].split(" ")[0];
            HashMap<String,Integer> reportMap = reportList.get(reportedManIndex);
            if(!reportMap.containsKey(reportMan)){
                reportMap.put(reportMan, reportManIndex);
                reportList.set(reportedManIndex, reportMap);
            }
        }
        for(int n = 0; n < reportList.size(); n++){
            HashMap<String,Integer> reportMap = reportList.get(n);
            if(reportMap.size() >= k){
                for(String key : reportMap.keySet()){
                    answer[reportMap.get(key)] += 1;
                }
            }
        }
        
        return answer;
    }
}