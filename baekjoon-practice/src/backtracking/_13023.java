package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 13023 ABCDE
 * https://www.acmicpc.net/problem/13023
 *
 * 1. 양방향 인접 리스트를 만든다.
 * 2. Vertex 만큼 반복하며 깊은탐색을 한다.
 * 3. 깊은탐색 4회이상 성공한 경우 1을 출력하고 종료한다. 그렇지 않으면 0을 출력하고 종료한다.
 */
public class _13023 {

    static int V, E;
    static List<List<Integer>> list;
    static int[] result;
    static int ret;

    public static void main(String[] args) {
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(System.in))) {
            String[] line = br.readLine().split(" ");
            V = Integer.parseInt(line[0]);
            E = Integer.parseInt(line[1]);
            list = new ArrayList<>();
            result = new int[V+1];
            for (int i=0 ;i<=V ; i++)
                list.add(new ArrayList<>());
            for (int i=0 ;i<E ; i++) {
                String[] input = br.readLine().split(" ");
                int fromVertex = Integer.parseInt(input[0]);
                int toVertex = Integer.parseInt(input[1]);

                list.get(fromVertex).add(toVertex);
                list.get(toVertex).add(fromVertex);
            }
            for (int i=0 ;i<V ; i++) {
                result[i] = 1;
                dfs(i, 0);
                result[i] = 0;
                if (ret == 1)
                    break ;
            }

            System.out.println(ret == 1 ? 1 : 0);
        } catch (IOException e) {
            // TODO
        }
    }

    private static void dfs(int vertex, int cnt) {
        if (cnt >= 4) {
            ret = 1;
            return ;
        }
        for (int i=0 ; i<list.get(vertex).size() ; i++) {
            int tmp = list.get(vertex).get(i);
            if (result[tmp] == 0) {
                result[tmp] = 1;
                dfs(tmp, cnt+1);
                result[tmp] = 0;
            }
        }
    }
}
