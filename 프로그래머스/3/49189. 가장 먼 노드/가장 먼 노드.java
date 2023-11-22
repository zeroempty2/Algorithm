import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        List<List<Integer>> graph = new ArrayList<>();
        Map<Integer, Integer> hashDistance = new HashMap<>();
        for(int i = 0; i <= n; i++){
            graph.add(new ArrayList<>());
            hashDistance.put(i,Integer.MAX_VALUE);
        }

        hashDistance.put(0,0);

        for(int i = 0; i < edge.length; i++){
            graph.get(edge[i][0]).add(edge[i][1]);
            graph.get(edge[i][1]).add(edge[i][0]);
        }

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(1,0));

        while(!q.isEmpty()){
            Pair pair = q.poll();
            if(hashDistance.get(pair.node) > pair.distance){
                hashDistance.put(pair.node, pair.distance);
            }
            else{
                continue;
            }
            for(int i = 0; i < graph.get(pair.node).size(); i++){
                int next = graph.get(pair.node).get(i);
                Pair p = new Pair(next, pair.distance+1);
                q.add(p);
            }
        }

        List<Map.Entry<Integer, Integer>> lists = new ArrayList<>();
        for(Map.Entry<Integer, Integer> e:hashDistance.entrySet()){
            lists.add(e);
        }

        Collections.sort(lists, (a,b)->{
            return Integer.compare(a.getValue(),b.getValue());
        });

        int lastValue = (int)lists.get(lists.size() - 1).getValue();
        
        for(int i = lists.size() - 1; i >= 0; i--){
            if(lastValue != lists.get(i).getValue()) break;
            answer++;
        }
        return answer;
    }
}

class Pair{
    int node;
    int distance;
    public Pair(int node, int distance){
        this.node = node;
        this.distance = distance;
    }
}