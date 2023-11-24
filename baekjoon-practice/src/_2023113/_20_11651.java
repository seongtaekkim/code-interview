package _2023113;

import java.io.*;
import java.util.*;

/**
 * 11651 좌표 정렬하기 2
 * https://www.acmicpc.net/problem/11651
 */
public class _20_11651 {
    public static void main(String[] args) throws IOException {

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            int num = Integer.parseInt(br.readLine());

            Point2[] arr = new Point2[num];
            for (int i=0 ; i<num ; i++) {
                String[] line = br.readLine().split(" ");
                arr[i] = new Point2(Integer.parseInt(line[0]), Integer.parseInt(line[1]));
            }

            Arrays.sort(arr, new Comparator<Point2>() {
                @Override
                public int compare(Point2 o1, Point2 o2) {
                    if (o1.getY() == o2.getY()) return o1.getX() - o2.getX();
                    else return o1.getY() - o2.getY();
                }
            });
            for (Point2 p : arr)
                bw.write(p.toString() + "\n");
            bw.flush();
        }
    }
}

class Point2 {
    private int x;
    private int y;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Point2(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return x + " " + y;
    }

}
