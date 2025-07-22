import java.io.*;
import java.util.*;

public class Main {

    static class Country {
        int id;
        int gold;
        int silver;
        int bronze;
        Country(int id, int gold, int silver, int bronze) {
            this.id = id;
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
        }
        boolean isSameMedals(Country other) {
            return this.gold == other.gold &&
                   this.silver == other.silver &&
                   this.bronze == other.bronze;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] first = br.readLine().split(" ");
        int N = Integer.parseInt(first[0]); 
        int K = Integer.parseInt(first[1]); 

        List<Country> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String[] data = br.readLine().split(" ");
            int id = Integer.parseInt(data[0]);
            int gold = Integer.parseInt(data[1]);
            int silver = Integer.parseInt(data[2]);
            int bronze = Integer.parseInt(data[3]);
            list.add(new Country(id, gold, silver, bronze));
        }


        list.sort((a, b) -> {
            if (b.gold != a.gold) return b.gold - a.gold;
            if (b.silver != a.silver) return b.silver - a.silver;
            return b.bronze - a.bronze;
        });

        int rank = 1;
        int realRank = 1; 
        Country prev = list.get(0);

        if (prev.id == K) {
            System.out.println(rank);
            return;
        }

        for (int i = 1; i < list.size(); i++) {
            Country curr = list.get(i);
            if (!curr.isSameMedals(prev)) {
                rank = i + 1;
            }

            if (curr.id == K) {
                realRank = rank;
                break;
            }

            prev = curr;
        }

        System.out.println(realRank);
    }
}
