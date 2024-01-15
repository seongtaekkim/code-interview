package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;


/**
 * 17071 숨바꼭질 5
 * https://www.acmicpc.net/problem/17071
 */
public class _17071 {
    public static void main(String[] args) throws Exception {


        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(System.in))) {

            String[] line = br.readLine().split(" ");
            int N = Integer.parseInt(line[0]); // row num
            int M = Integer.parseInt(line[1]); // col num

            int[] mat = new int[500001];

            if(N == M){
                System.out.println(0);
            }else {
                System.out.println(bfs(N, M, mat));
            }
        } catch (IOException e) {
            // TODO
        }

    }

    static int bfs(int n, int m, int[] mat) {
        int[] dx = {-1, 1};

        boolean[][] visited = new boolean[500001][2];
        Queue<Integer> q = new LinkedList<>();
        q.offer(n);
        int time = 0;
        while (!q.isEmpty()) {
            if(m > 500000) {
                return -1;
            }

            int newTime = time % 2;

            if(visited[m][newTime]) {
                return time;
            }

            for(int j = 0, size = q.size(); j < size; j++) {
                int now = q.poll();
                int nextTime = (time + 1) % 2;
                int next;

                next = now - 1;
                if(next >= 0 && !visited[next][nextTime]) {
                    visited[next][nextTime] = true;
                    q.offer(next);
                }

                next = now + 1;
                if(next < 500001 && !visited[next][nextTime]) {
                    visited[next][nextTime] = true;
                    q.offer(next);
                }

                next = now * 2;
                if(next < 500001 && !visited[next][nextTime]) {
                    visited[next][nextTime] = true;
                    q.offer(next);
                }
            }
            time++;
            m += time;
        }
        return -1;
    }

}
