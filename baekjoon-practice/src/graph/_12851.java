package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Parameter;
import java.util.LinkedList;
import java.util.Queue;


/**
 * 12851 숨바꼭질 2
 * https://www.acmicpc.net/problem/12851
 *
 *
 * 방문한 배열위치에 counter비교로 seen 하도록 함
 */
public class _12851 {
    public static void main(String[] args) throws Exception {


        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(System.in))) {

            String[] line = br.readLine().split(" ");
            int N = Integer.parseInt(line[0]); // row num
            int M = Integer.parseInt(line[1]); // col num

            int[] mat = new int[100001];
            if (N == M ){
                System.out.println(0);
                System.out.println(1);
                return ;
            }

            Pair result = bfs(N, M, mat);
            System.out.println(result.cnt);
            System.out.println(result.sum);
        } catch (IOException e) {
            // TODO
        }

    }

    static class Pair {
        final int cnt;
        final int sum;

        Pair(int cnt, int sum) {
            this.cnt = cnt;
            this.sum = sum;
        }
    }

    static Pair bfs(int n, int m, int[] mat) {
        int[] dx = {-1, 1};

        Queue<Point> q = new LinkedList<>();
        q.add(new Point(n,  0));

        int cnt=0;
        Pair p = null;
        while (!q.isEmpty()) {
            Point point = q.poll();

            if (point.x == m) {
                cnt++;
                p = new Pair(point.count, cnt);
            }


            for (int i=0; i<2; i++) {
                int nx = point.x + dx[i];

                if (0 <= nx && nx < 100001) {
                    if (mat[nx] == 0 || mat[nx] >= point.count+1) {
                        mat[nx] = point.count+1;
                        q.add(new Point(nx, point.count + 1));
                    }
                }
            }

            for (int i=0; i<2; i++) {
                int nx = point.x * dx[i] * 2;

                if (0 <= nx && nx < 100001) {
                    if (mat[nx] == 0 || mat[nx] >= point.count+1) {
                        mat[nx] = point.count+1;
                        q.add(new Point(nx, point.count + 1));
                    }
                }
            }
        }

        return p;
    }

    static class Point {
        int x, count;

        Point(int x, int count) {
            this.x = x;
            this.count = count;
        }
    }
}
