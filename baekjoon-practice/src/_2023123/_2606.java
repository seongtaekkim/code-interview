package _2023123;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 2606 바이러스
 * https://www.acmicpc.net/problem/2606
 */
public class _2606 {

    static int cnt = 0;
    static int[] result;
    static List<List<Integer>> list;
    public static void main(String[] args) {
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(System.in))) {

            int N = Integer.parseInt(br.readLine()); // vertex
            int M = Integer.parseInt(br.readLine()); // edge

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

            dfs(1);
            System.out.println(cnt);
        } catch (IOException e) {
            // TODO
        }
    }

    private static void dfs(int vertex) {
        result[vertex] = 1;
        for (int i=0 ; i<list.get(vertex).size() ; i++) {
            int tmp = list.get(vertex).get(i);
            if (result[tmp] == 0) {
                cnt++;
                dfs(tmp);
            }
        }
    }

}
