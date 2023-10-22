import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String,Songs> genre = new HashMap<>();
        HashMap<String,Integer> numberCheck = new HashMap<>();
        

        for(int i = 0; i < genres.length; i++){
            if(genre.containsKey(genres[i])){
                Songs song = genre.get(genres[i]);
                song.addSong(i, plays[i]);
                genre.put(genres[i], song);
            }else{
                genre.put(genres[i],new Songs(i,plays[i]));
            }
            numberCheck.put(genres[i], numberCheck.getOrDefault(genres[i], 0) + plays[i]);
        }

        List<Integer> answer = new ArrayList<>();
        List<String> keySet = new ArrayList<>(numberCheck.keySet());
        Collections.sort(keySet,(i1,i2) -> (numberCheck.get(i2).compareTo(numberCheck.get(i1))));
        
        for(int j = 0; j < keySet.size(); j++){
            Songs song = genre.get(keySet.get(j));
            int count = 0;
            while(count < 2){
                if(song.playNumbers.isEmpty()) break;
                PriorityQueue<Integer> indexList = song.playIndex.get(song.playNumbers.poll());
                if(count < 1 && indexList.size() > 1){
                    answer.add(indexList.poll());
                    answer.add(indexList.poll());
                    break;
                }
                answer.add(indexList.poll());
                count++;
            }
        }

        return answer.stream().mapToInt(i->i).toArray();
    }

    private class Songs{
        
        HashMap<Integer,PriorityQueue<Integer>> playIndex = new HashMap<>();
        PriorityQueue<Integer> playNumbers = new PriorityQueue<>(Collections.reverseOrder());

        public Songs(int playIndex,int playNumbers){
            PriorityQueue<Integer> indexList = new PriorityQueue<>();
            if(this.playIndex.containsKey(playNumbers)){
                indexList = this.playIndex.get(playNumbers);
            }
            indexList.add(playIndex);
            this.playIndex.put(playNumbers, indexList);
            this.playNumbers.add(playNumbers);
        }
        
        public void addSong(int playIndex,int playNumbers){
            PriorityQueue<Integer> indexList = new PriorityQueue<>();
            if(this.playIndex.containsKey(playNumbers)){
                indexList = this.playIndex.get(playNumbers);
            }
            indexList.add(playIndex);
            this.playIndex.put(playNumbers, indexList);
            this.playNumbers.add(playNumbers);
        }

    }
}