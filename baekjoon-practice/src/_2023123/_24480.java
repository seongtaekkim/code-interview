package _2023123;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 24480 알고리즘 수업 - 깊이 우선 탐색 2
 * https://www.acmicpc.net/problem/24480
 */
public class _24480 {

    static int order;
    static int[] result;
    static List<List<Integer>> list;
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

            for (int i=0; i<M ; i++) {
                String[] input = br.readLine().split(" ");
                int fromVertex = Integer.parseInt(input[0]);
                int toVertex = Integer.parseInt(input[1]);

                list.get(fromVertex).add(toVertex);
                list.get(toVertex).add(fromVertex);
            }

            for (int i=0; i<=N ; i++) {
                list.get(i).sort(Collections.reverseOrder());
            }
            order = 1;
            dfs(R);

            StringBuilder sb = new StringBuilder();
            for(int i = 1; i < result.length; i++) {
                sb.append(result[i]).append("\n");
            }
            System.out.println(sb);
        } catch (IOException e) {
            // TODO
        }
    }

    private static void dfs(int vertex) {
        result[vertex] = order;
        for (int i=0 ; i<list.get(vertex).size() ; i++) {
            int tmp = list.get(vertex).get(i);
            if (result[tmp] == 0) {
                order++;
                dfs(tmp);
            }
        }
    }

}
