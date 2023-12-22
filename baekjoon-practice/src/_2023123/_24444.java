package _2023123;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 24444 알고리즘 수업 - 너비 우선 탐색 1
 * https://www.acmicpc.net/problem/24444
 */
public class _24444 {
    static int order;
    static int[] result;
    static List<List<Integer>> list;
    static Queue<Integer> queue;
    public static void main(String[] args) {
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(System.in))) {

            String[] line = br.readLine().split(" ");
            int N = Integer.parseInt(line[0]); // vertex
            int M = Integer.parseInt(line[1]); // edge
            int R = Integer.parseInt(line[2]); // start vertex

            result = new int[N+1];
            list = new ArrayList<>();
            for (int i=0; i<=N ; i++) {
                list.add(new ArrayList<>());
            }
            queue = new LinkedList<>();

            for (int i=0; i<M ; i++) {
                String[] input = br.readLine().split(" ");
                int fromVertex = Integer.parseInt(input[0]);
                int toVertex = Integer.parseInt(input[1]);

                list.get(fromVertex).add(toVertex);
                list.get(toVertex).add(fromVertex);
            }

            for (int i=0; i<=N ; i++) {
                Collections.sort(list.get(i));
            }
            order = 1;
            result[R] = order++;
            bfs(R);

            StringBuilder sb = new StringBuilder();
            for(int i = 1; i < result.length; i++) {
                sb.append(result[i]).append("\n");
            }
            System.out.println(sb);
        } catch (IOException e) {
            // TODO
        }
    }

    private static void bfs(int vertex) {
        for (int i=0 ; i<list.get(vertex).size() ; i++) {
            int tmp = list.get(vertex).get(i);
            if (result[tmp] == 0) {
                queue.add(tmp);
                result[tmp] = order++;
            }
        }
        if (!queue.isEmpty()) {
            bfs(queue.poll());
        }
    }
}
