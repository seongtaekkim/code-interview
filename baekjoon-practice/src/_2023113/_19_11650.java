package _2023113;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * 11650 좌표 정렬하기
 * https://www.acmicpc.net/problem/11650
 */
public class _19_11650 {
    public static void main(String[] args) throws IOException {

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int num = Integer.parseInt(br.readLine());

            List<Point> list = new ArrayList<>();
            for (int i=0 ; i<num ; i++) {
                String[] line = br.readLine().split(" ");
                list.add(new Point(Integer.parseInt(line[0]), Integer.parseInt(line[1])));
            }
            Collections.sort(list);
            for (Point p : list)
                bw.write(p.toString() + "\n");
            bw.flush();
        }
    }
}

class Point implements Comparable<Point> {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return x + " " + y;
    }

    @Override
    public int compareTo(Point o) {
        if (this.x > o.x)
            return 1;
        else if (this.x == o.x) {
            if (this.y > o.y) return 1;
        }
        return -1;
    }
}
