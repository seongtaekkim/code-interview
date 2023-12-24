package _2023123;

import java.util.*;
import java.io.*;


/**
 * 2178  미로 탐색
 * https://www.acmicpc.net/problem/2178
 */
public class _2178 {
    public static void main(String[] args) throws Exception {


        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(System.in))) {

            String[] line = br.readLine().split(" ");
            int N = Integer.parseInt(line[0]); // row num
            int M = Integer.parseInt(line[1]); // col num

            int[][] mat = new int[N][M];
            for (int i=0 ;i<N ; i++) {
                char[] charArray = br.readLine().toCharArray();
                for (int j=0; j<charArray.length ; j++)
                    mat[i][j] = charArray[j] - '0';
            }

            int result = bfs(N, M, mat);
            System.out.println(result);
        } catch (IOException e) {
            // TODO
        }

    }

    static int bfs(int n, int m, int[][] mat) {
        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};

        Queue<Point> q = new LinkedList<>();
        mat[0][0] = 0;
        q.add(new Point(0, 0, 1));

        while (!q.isEmpty()) {
            Point point = q.poll();

            if (point.x == n-1 && point.y == m-1) {
                return point.count;
            }

            for (int i=0; i<4; i++) {
                int nx = point.x + dx[i];
                int ny = point.y + dy[i];

                if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                    if (mat[nx][ny] == 1) {
                        mat[nx][ny] = 0;
                        q.add(new Point(nx, ny, point.count + 1));
                    }
                }
            }
        }

        return 0;
    }

    static class Point {
        int x, y, count;

        Point(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
}