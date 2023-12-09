package _2023121;

import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 11286 절댓값 힙
 * https://www.acmicpc.net/problem/11286
 */
public class _11286 {
    public static void main(String[] args) {
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(System.in))) {
            int N = Integer.parseInt(br.readLine());
            PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    if (Math.abs(o1) == Math.abs(o2)) return o1 - o2;
                    else return Math.abs(o1) - Math.abs(o2);
                }
            });
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < N; i++) {
                int x = Integer.parseInt(br.readLine());
                if (x == 0) {
                    int out = queue.isEmpty() ? 0 : queue.poll();
                    sb.append(out).append("\n");
                } else queue.offer(x);
            }

            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            bw.write(sb.toString());
            bw.flush();
        } catch (IOException e) {
            // TODO
        }
    }
}
