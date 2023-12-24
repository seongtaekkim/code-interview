package _2023123;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 1260 DFS와 BFS
 * https://www.acmicpc.net/problem/1260
 */
public class _1260 {
    static int order;
    static int[] result1;
    static int[] result2;
    static List<List<Integer>> list;
    static Queue<Integer> queue;

    static List<Integer> bfsList = new ArrayList<>();
    static List<Integer> dfsList = new ArrayList<>();
    public static void main(String[] args) {
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(System.in))) {

            String[] line = br.readLine().split(" ");
            int N = Integer.parseInt(line[0]); // vertex
            int M = Integer.parseInt(line[1]); // edge
            int R = Integer.parseInt(line[2]); // start vertex

            result1 = new int[N+1];
            result2 = new int[N+1];
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
            result1[R] = order++;
            bfsList.add(R);
            bfs(R);

            order = 1;
            dfs(R);

            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < dfsList.size() ; i++) {
                sb.append(dfsList.get(i)).append(" ");
            }
            sb.append("\n");
            for(int i = 0; i < bfsList.size() ; i++) {
                sb.append(bfsList.get(i)).append(" ");
            }
            System.out.println(sb);
        } catch (IOException e) {
            // TODO
        }
    }

    private static void bfs(int vertex) {
        for (int i=0 ; i<list.get(vertex).size() ; i++) {
            int tmp = list.get(vertex).get(i);
            if (result1[tmp] == 0) {
                queue.add(tmp);
                result1[tmp] = order++;
                bfsList.add(tmp);
            }
        }
        if (!queue.isEmpty()) {
            bfs(queue.poll());
        }
    }

    private static void dfs(int vertex) {
        result2[vertex] = order;
        dfsList.add(vertex);
        for (int i=0 ; i<list.get(vertex).size() ; i++) {
            int tmp = list.get(vertex).get(i);
            if (result2[tmp] == 0) {
                order++;
                dfs(tmp);
            }
        }
    }
}
