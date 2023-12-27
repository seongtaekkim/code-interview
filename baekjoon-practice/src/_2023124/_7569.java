package _2023124;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


/**
 * 7569 토마토
 * https://www.acmicpc.net/problem/7562
 */
public class _7569 {
    public static void main(String[] args) throws Exception {


        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(System.in))) {

            String[] line = br.readLine().split(" ");
            int N = Integer.parseInt(line[0]); // 가로 개수
            int M = Integer.parseInt(line[1]); // 세로 개수
            int H = Integer.parseInt(line[2]); // 높이 개수

            List<Integer> startX = new ArrayList<>();
            List<Integer> startY = new ArrayList<>();
            List<Integer> startH = new ArrayList<>();
            int[][][] mat = new int[H][M][N];
            for (int h=0; h<H ; h++) {
                for (int i = 0; i < M; i++) {
                    String[] str = br.readLine().split(" ");
                    for (int j = 0; j < str.length; j++) {
                        if (Integer.parseInt(str[j]) == 1) {
                            startX.add(j);
                            startY.add(i);
                            startH.add(h);
                        }
                        mat[h][i][j] = Integer.parseInt(str[j]);
                    }
                }
            }
            if (startX.size() == 0) {
                System.out.println(-1);
                return ;
            }
            int bfs = bfs(startX, startY, startH, mat);
            for (int h=0 ; h<mat.length ; h++) {
                for (int i = 0; i < mat[0].length; i++) {
                    for (int j = 0; j < mat[0][0].length; j++) {
                        if (mat[h][i][j] == 0) {
                            System.out.println(-1);
                            return;
                        }
                    }
                }
            }
            System.out.println(bfs);

        } catch (IOException e) {
            // TODO
        }

    }
    static int bfs(List<Integer> n, List<Integer> m, List<Integer> h, int[][][] mat) {
        int[] dx = {0,0,1,0,0,-1};
        int[] dy = {0,1,0,0,-1,0};
        int[] dh = {1,0,0,-1,0,0};

        Queue<Point> q = new LinkedList<>();
        for (int i=0; i<n.size() ; i++)
            q.add(new Point(n.get(i), m.get(i), h.get(i), 0));

        Point point = null;
        while (!q.isEmpty()) {
            point = q.poll();

            for (int i=0; i<6; i++) {
                int nx = point.x + dx[i];
                int ny = point.y + dy[i];
                int nh = point.z + dh[i];
                if (0 <= nx && nx < mat[0][0].length
                            && 0 <= ny && ny < mat[0].length
                            && 0 <= nh && nh < mat.length) {
                    if (mat[nh][ny][nx] == 0) {
                        mat[nh][ny][nx] = 1;
                        q.add(new Point(nx, ny, nh, point.count + 1));
                    }
                }
            }
        }

        return point.count;
    }

    static class Point {
        int x, y, z, count;

        Point(int x, int y, int z, int count) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.count = count;
        }
    }
}