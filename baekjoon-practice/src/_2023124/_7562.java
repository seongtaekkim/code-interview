package _2023124;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;


/**
 * 7562 나이트의 이동
 * https://www.acmicpc.net/problem/7562
 */
public class _7562 {
    public static void main(String[] args) throws Exception {


        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(System.in))) {

            int N = Integer.parseInt(br.readLine());

            int[][] mat = null;
            for (int i=0; i<N ; i++) {
                int M = Integer.parseInt(br.readLine()); // row * col
                mat = new int[M][M];
                String[] input1 = br.readLine().split(" ");
                int startX = Integer.parseInt(input1[1]);
                int startY = Integer.parseInt(input1[0]);
                String[] input2 = br.readLine().split(" ");
                endX = Integer.parseInt(input2[1]);
                endY = Integer.parseInt(input2[0]);
                int result = bfs(startX, startY, mat);
                System.out.println(result);
            }

        } catch (IOException e) {
            // TODO
        }

    }
    static int endX;
    static int endY;
    static int bfs(int n, int m, int[][] mat) {
        int[] dx = {1,2,2,1,-1,-2,-2,-1};
        int[] dy = {2,1,-1,-2,-2,-1,1,2};

        Queue<Point> q = new LinkedList<>();
        q.add(new Point(n, m, 0));

        while (!q.isEmpty()) {
            Point point = q.poll();

            if (point.x == endX && point.y == endY) {
                return point.count;
            }

            for (int i=0; i<8; i++) {
                int nx = point.x + dx[i];
                int ny = point.y + dy[i];
                if (0 <= nx && nx < mat.length && 0 <= ny && ny < mat.length) {
                    if (mat[ny][nx] == 0) {
                        mat[ny][nx] = 1;
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