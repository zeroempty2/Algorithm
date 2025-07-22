import java.io.*;
import java.util.*;

public class Main {

    static class Country {
        int id;
        int gold, silver, bronze;

        Country(int id, int gold, int silver, int bronze) {
            this.id = id;
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] firstLine = br.readLine().split(" ");
        int N = Integer.parseInt(firstLine[0]);
        int K = Integer.parseInt(firstLine[1]);

        List<Country> countries = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            int id = Integer.parseInt(input[0]);
            int gold = Integer.parseInt(input[1]);
            int silver = Integer.parseInt(input[2]);
            int bronze = Integer.parseInt(input[3]);
            countries.add(new Country(id, gold, silver, bronze));
        }

        countries.sort((a, b) -> {
            if (b.gold != a.gold) return b.gold - a.gold;
            if (b.silver != a.silver) return b.silver - a.silver;
            return b.bronze - a.bronze;
        });

        int rank = 1;
        int sameRank = 1;

        Country prev = countries.get(0);

        if (prev.id == K) {
            System.out.println(rank);
            return;
        }

        for (int i = 1; i < N; i++) {
            Country curr = countries.get(i);
            if (curr.gold == prev.gold && curr.silver == prev.silver && curr.bronze == prev.bronze) {
                sameRank++;
            } else {
                rank = i + 1;
                sameRank = rank;
            }

            if (curr.id == K) {
                System.out.println(sameRank);
                return;
            }

            prev = curr;
        }
    }
}
