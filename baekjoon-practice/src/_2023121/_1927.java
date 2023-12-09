package _2023121;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * 1927 최소 힙
 * https://www.acmicpc.net/problem/1927
 */
public class _1927 {
    public static void main(String[] args) {
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(System.in))) {

            int N = Integer.parseInt(br.readLine());

            PriorityQueue<Integer> queue = new PriorityQueue<>();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < N; i++) {
                int num = Integer.parseInt(br.readLine());
                if (num == 0) {
                    if (!queue.isEmpty())
                        System.out.println(queue.poll());
                    else
                        System.out.println(0);
                    continue;
                }
                queue.add(num);
            }
        } catch (IOException e) {
            // TODO
        }
    }
}
