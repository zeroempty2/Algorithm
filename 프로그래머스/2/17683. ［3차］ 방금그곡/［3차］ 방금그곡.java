    import java.util.ArrayList;
    import java.util.List;
    import java.util.StringTokenizer;

    class Solution {
        public String solution(String m, String[] musicinfos) {
            String answer = "(None)";
            m = melodyRep(m);
            MusicInfo[] arr = new MusicInfo[musicinfos.length];
            List<MusicInfo> answerList = new ArrayList<>();
            for(int i = 0; i < musicinfos.length; i++){
                StringTokenizer st = new StringTokenizer(musicinfos[i], ",");
                arr[i] = new MusicInfo(st.nextToken(), st.nextToken(), st.nextToken(),melodyRep(st.nextToken()));
            }
            for(MusicInfo info : arr){
                if(info.melody.contains(m)) answerList.add(info);
            }

            if(answerList.isEmpty()) return answer;


            if (answerList.size() > 2) {
                answerList.sort((o1, o2) -> {
                    int c = o2.playMin - o1.playMin;
                    if (c == 0) {
                        return o1.playMin;
                    }
                    return c;
                });
    
            }
    
            return answerList.get(0).musicName;
        }

        public int calPlayTime(String startTime, String endTime){
            int start = Integer.valueOf(startTime.split(":")[0]) * 60 + Integer.valueOf(startTime.split(":")[1]);
            int end = Integer.valueOf(endTime.split(":")[0]) * 60 + Integer.valueOf(endTime.split(":")[1]);
            return end - start;
        }

        public String melodyRep(String melody){
            return melody.replace("C#", "c")
            .replace("D#", "d")
            .replace("F#", "f")
            .replace("G#", "g")
            .replace("A#", "a");
           
        }

        class MusicInfo{
            Integer playMin;
            String musicName;
            String melody;

            public MusicInfo(String startTime, String endTime, String musicName, String melody){
                int playtime = calPlayTime(startTime, endTime);
                this.playMin = playtime;
                this.musicName = musicName;
                this.melody = fixMelody(melody,playtime);
            }

            private String fixMelody(String melody,int playtime){
                if (melody.length() == playtime) {
                    return melody;
                }

                if (melody.length() < playtime) {
                    while (melody.length() < playtime) {
                        melody += melody;
                    }
                    if (melody.length() == playtime) {
                        return melody;
                    }
                }
                return melody.substring(0, playtime);
            }
        }

    }

