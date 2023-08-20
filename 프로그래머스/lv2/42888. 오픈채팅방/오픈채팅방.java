import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {
    public String[] solution(String[] record) {
        HashMap<String,String> map = new HashMap<>();
        List<String> list= new ArrayList<>();

        for(int i = record.length - 1; i >= 0; i--){
            String[] arr = record[i].split(" ");
            if(!map.containsKey(arr[1]) && !arr[0].equals("Leave")){
                map.put(arr[1], arr[2]);
            }
        }

        for(String temp : record){
            String[] arr = temp.split(" ");
            if(arr[0].equals("Enter")){
                list.add(map.get(arr[1]) + "님이 들어왔습니다.");
            }
            else if(arr[0].equals("Leave")){
                list.add(map.get(arr[1]) + "님이 나갔습니다.");
            }
            else{
                continue;
            }
            
        }
        return list.toArray(new String[list.size()]);
    }
}