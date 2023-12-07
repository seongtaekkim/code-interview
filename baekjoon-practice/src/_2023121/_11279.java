package _2023121;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * 11279 최대 힙
 * https://www.acmicpc.net/problem/11279
 */
public class _11279 {
    public static void main(String[] args) {
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(System.in))) {

            int N = Integer.parseInt(br.readLine());

            PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < N; i++) {
                int num = Integer.parseInt(br.readLine());
                if (num == 0)
                    sb.append(queue.isEmpty() ? 0 : queue.poll()).append('\n');
                else queue.add(num);
            }
            System.out.println(sb);
        } catch (IOException e) {
            // TODO
        }
    }
}
