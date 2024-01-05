package datastructure.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 7662 이중 우선순위 큐
 * https://www.acmicpc.net/problem/7662
 */
public class _7662 {
    public static void main(String[] args) {
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(System.in))) {

            int T = Integer.parseInt(br.readLine());
            for (int i=0 ; i<T ; i++) {
                Map<Integer, Integer> map = new HashMap<>();
                PriorityQueue<Integer> minQ = new PriorityQueue<>();
                PriorityQueue<Integer> maxQ = new PriorityQueue<>(Collections.reverseOrder());

                int N = Integer.parseInt(br.readLine());
                for (int j=0 ;j<N ; j++) {
                    String[] line = br.readLine().split(" ");
                    if ("I".equals(line[0])) {
                        int n = Integer.parseInt(line[1]);
                        minQ.add(n);
                        maxQ.add(n);
                        map.put(n,map.getOrDefault(n,0)+1);
                    } else if ("D".equals(line[0])){
                        if (Integer.parseInt(line[1]) == 1) {
                            if (maxQ.isEmpty()) continue;
                            delAndReturn(maxQ, map);
                        } else {
                            if (minQ.isEmpty()) continue;
                            delAndReturn(minQ, map);
                        }
                    } else {
                        throw new RuntimeException("invalid input data");
                    }
                }

                if (map.size() == 0)
                    System.out.println("EMPTY");
                else {
                    if (map.size() == 1) {
                        Integer next = map.keySet().iterator().next();
                        System.out.println(next + " " + next);
                    } else {
                        System.out.println(delAndReturn(maxQ, map) + " " + delAndReturn(minQ, map));
                    }

                }
            }

        } catch (IOException e) {
            // TODO
        }
    }

    public static int delAndReturn(PriorityQueue<Integer> queue, Map<Integer, Integer> map) {
        Integer poll =0;
        while (true) {
            if (queue.isEmpty()) break;
            poll = queue.poll();
            Integer cnt = map.getOrDefault(poll, 0);
            if (cnt == 1) {
                map.remove(poll);
            } else if (cnt == 0) {
                continue;
            } else {
                map.replace(poll, map.get(poll)-1);
            }
            break;
        }
        return poll;
    }
}
