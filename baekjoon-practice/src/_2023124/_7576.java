package _2023124;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


/**
 * 7576 토마토
 * https://www.acmicpc.net/problem/7576
 */
public class _7576 {
    public static void main(String[] args) throws Exception {


        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(System.in))) {

            String[] line = br.readLine().split(" ");
            int N = Integer.parseInt(line[0]); // 가로 개수
            int M = Integer.parseInt(line[1]); // 세로 개수

            List<Integer> startX = new ArrayList<>();
            List<Integer> startY = new ArrayList<>();
            int[][] mat = new int[M][N];
            for (int i=0; i<M ; i++) {
                String[] str = br.readLine().split(" ");
                for (int j=0; j<str.length ; j++) {
                    if (Integer.parseInt(str[j]) == 1) {
                        startX.add(j);
                        startY.add(i);
                    }
                    mat[i][j] = Integer.parseInt(str[j]);
                }
            }
            if (startX.size() == 0) {
                System.out.println(-1);
                return ;
            }
            int bfs = bfs(startX, startY, mat);
            for (int i=0 ; i<mat.length ; i++) {
                for (int j=0 ; j<mat[0].length ; j++) {
                    if (mat[i][j] == 0) {
                        System.out.println(-1);
                        return ;
                    }
                }
            }
            System.out.println(bfs);

        } catch (IOException e) {
            // TODO
        }

    }
    static int bfs(List<Integer> n, List<Integer> m, int[][] mat) {
        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};

        Queue<_7562.Point> q = new LinkedList<>();
        for (int i=0; i<n.size() ; i++)
            q.add(new _7562.Point(n.get(i), m.get(i), 0));

        _7562.Point point = null;
        while (!q.isEmpty()) {
            point = q.poll();

            for (int i=0; i<4; i++) {
                int nx = point.x + dx[i];
                int ny = point.y + dy[i];
                if (0 <= nx && nx < mat[0].length && 0 <= ny && ny < mat.length) {
                    if (mat[ny][nx] == 0) {
                        mat[ny][nx] = 1;
                        q.add(new _7562.Point(nx, ny, point.count + 1));
                    }
                }
            }
        }

        return point.count;
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