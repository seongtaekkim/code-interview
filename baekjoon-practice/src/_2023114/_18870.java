package _2023114;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 18870 좌표 압축
 * https://www.acmicpc.net/problem/18870
 */
public class _18870 {
    public static void main(String[] args) {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(System.in))) {

            int num = Integer.parseInt(br.readLine());
            String[] line = br.readLine().split(" ");
            List<Point_118870> list = new ArrayList<>(num);
            for (int i=0 ; i<num ; i++)
                list.add(new Point_118870(Integer.parseInt(line[i]), i));

            Collections.sort(list);


            StringBuilder sb = new StringBuilder();
            int[] result = new int[num];
            int rank = 0;
            for (int i=1; i<num ; i++) {
                if (list.get(i-1).getData() < list.get(i).getData()) {
                    rank++;
                }
                list.get(i).setRank(rank);
            }

            for (int i=0; i<num ; i++)
                result[list.get(i).getIndex()] = list.get(i).getRank();

            for (int i : result)
                bw.write(i + " ");
            bw.flush();

        } catch (IOException e) {
            // TODO
        }
    }
}

class Point_118870 implements Comparable<Point_118870> {

    private int data;
    private int index;

    private int rank;

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getData() {
        return data;
    }

    public int getIndex() {
        return index;
    }

    public Point_118870(int data, int index) {
        this.data = data;
        this.index = index;
    }

    @Override
    public int compareTo(Point_118870 o) {
        if (this.data > o.data)
            return 1;
        return -1;
    }

    @Override
    public String toString() {
        return "Point_118870{" +
                "data=" + data +
                ", index=" + index +
                ", rank=" + rank +
                '}';
    }
}
