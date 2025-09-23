import java.util.*;

public class Main {
    static double dist(double x1, double y1, double x2, double y2) {
        return Math.sqrt((x1 - x2)*(x1 - x2) + (y1 - y2)*(y1 - y2));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double x1 = sc.nextDouble(), y1 = sc.nextDouble();
        double x2 = sc.nextDouble(), y2 = sc.nextDouble();
        double x3 = sc.nextDouble(), y3 = sc.nextDouble();

        // 세 점이 일직선인지 확인
        if ((x2 - x1)*(y3 - y1) == (y2 - y1)*(x3 - x1)) {
            System.out.println(-1.0);
            return;
        }

        double[] perimeters = new double[3];

        //D = A + B - C 
        perimeters[0] = 2 * (dist(x1,y1,x2,y2) + dist(x1,y1,x3,y3));

        //D = A + C - B 
        perimeters[1] = 2 * (dist(x1,y1,x3,y3) + dist(x2,y2,x3,y3));

        //D = B + C - A
        perimeters[2] = 2 * (dist(x1,y1,x2,y2) + dist(x2,y2,x3,y3));

        double max = Math.max(perimeters[0], Math.max(perimeters[1], perimeters[2]));
        double min = Math.min(perimeters[0], Math.min(perimeters[1], perimeters[2]));

        System.out.println(max - min);
    }
}
