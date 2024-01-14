package graph;

import _2023124._1697;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 13549 숨바꼭질 3
 * https://www.acmicpc.net/problem/13549
 */
public class _13549 {
    public static void main(String[] args) throws Exception {


        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(System.in))) {

            String[] line = br.readLine().split(" ");
            int N = Integer.parseInt(line[0]); // row num
            int M = Integer.parseInt(line[1]); // col num

            int[] mat = new int[100001];

            int result = bfs(N, M, mat);
            System.out.println(result);
        } catch (IOException e) {
            // TODO
        }

    }

    static int bfs(int n, int m, int[] mat) {
        int[] dx = {-1, 1};

        Queue<Point> q = new LinkedList<>();
        q.add(new Point(n,  0));

        while (!q.isEmpty()) {
            Point point = q.poll();

            if (point.x == m) {
                return point.count;
            }

            for (int i=0; i<2; i++) {
                int nx = point.x * dx[i] * 2;

                if (0 <= nx && nx < 100001) {
                    if (mat[nx] == 0) {
                        mat[nx] = 1;
                        q.add(new Point(nx, point.count));
                    }
                }
            }


            for (int i=0; i<2; i++) {
                int nx = point.x + dx[i];

                if (0 <= nx && nx < 100001) {
                    if (mat[nx] == 0) {
                        mat[nx] = 1;
                        q.add(new Point(nx, point.count + 1));
                    }
                }
            }
        }

        return 0;
    }

    static class Point {
        int x, count;

        Point(int x, int count) {
            this.x = x;
            this.count = count;
        }
    }
}
