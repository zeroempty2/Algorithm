public class Main {
    static final int LIMIT = 10000;
    static boolean[] isGenerated = new boolean[LIMIT + 1];

    public static void main(String[] args) {
        for (int i = 1; i <= LIMIT; i++) {
            int dn = d(i);
            if (dn <= LIMIT) {
                isGenerated[dn] = true;
            }
        }

        for (int i = 1; i <= LIMIT; i++) {
            if (!isGenerated[i]) {
                System.out.println(i);
            }
        }
    }

    public static int d(int n) {
        int sum = n;
        while (n > 0) {
            sum += n % 10; 
            n /= 10;     
        }
        return sum;
    }
}
