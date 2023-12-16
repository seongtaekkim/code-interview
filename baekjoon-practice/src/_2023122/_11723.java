package _2023122;

import java.io.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 11723 집합
 * https://www.acmicpc.net/problem/11723
 */
public class _11723 {
    public static void main(String[] args) {
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(System.in))) {

            int M = Integer.parseInt(br.readLine());
            Set<Integer> set = new HashSet<>();
            StringBuilder sb = new StringBuilder();
            for (int i=0; i<M ; i++) {
                String[] line = br.readLine().split(" ");
                int n = line.length > 1 ? Integer.parseInt(line[1]) : -1;
                if ("add".equals(line[0])) {
                    set.add(n);
                } else if ("remove".equals(line[0])) {
                    set.remove(n);
                } else if ("check".equals(line[0])) {
                    sb.append(set.contains(n) ? 1 : 0).append("\n");
                } else if ("toggle".equals(line[0])) {
                    boolean b = set.contains(n) ? set.remove(n) : set.add(n);
                } else if ("all".equals(line[0])) {
                    Integer[] ints = {1, 2, 3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
                    set.addAll(List.of(ints));
                } else if ("empty".equals(line[0])) {
                    set.clear();
                }
            }

            System.out.println(sb);
        } catch (IOException e) {
            // TODO
        }
    }
}
