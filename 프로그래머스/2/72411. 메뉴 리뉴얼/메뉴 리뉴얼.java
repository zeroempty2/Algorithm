import java.util.*;

class Solution {
    int maxValue = 0;
    public String[] solution(String[] orders, int[] courses) {
        List<String> answer = new ArrayList<>();

        for (int course : courses) {
            Map<String, Integer> map = new HashMap<>();

            for (String order : orders) {
                int length = order.length();

                if (length < course) continue;

                char[] charArray = order.toCharArray();
                boolean[] visited = new boolean[length];
                combination(map, charArray, visited, 0, length, course);
            }

            if (map.isEmpty()) continue;
            if (maxValue < 2) continue;

            for (String key : map.keySet()) {
                if (map.get(key) == maxValue) {
                    answer.add(key);
                }
            }

            maxValue = 0;
        }

        return answer.stream().sorted().toArray(String[]::new);
    }

    private void combination(Map<String, Integer> map, char[] charArray, boolean[] visited, int start, int length, int course) {
        if (course == 0) {
            refactorMap(map, charArray, visited, length);
            return;
        }

        for (int i = start; i < length; i++) {
            visited[i] = true;
            combination(map, charArray, visited, i + 1, length, course - 1);
            visited[i] = false;
        }
    }

    private void refactorMap(Map<String, Integer> map, char[] charArray, boolean[] visited, int length) {
        String s = combineString(charArray, visited, length);

        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        s = String.valueOf(arr);

        int value = map.getOrDefault(s, 0) + 1;
        map.put(s,value);

        maxValue = Math.max(maxValue, value);
    }

    private String combineString(char[] charArray, boolean[] visited, int length) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            if (visited[i]) {
                stringBuilder.append(charArray[i]);
            }
        }
        return stringBuilder.toString();
    }
}