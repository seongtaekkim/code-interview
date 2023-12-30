package graph;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;


/**
 * 14940 쉬운 최단거리
 * https://www.acmicpc.net/problem/14940
 */
public class _14940 {
    public static void main(String[] args) throws Exception {

        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(System.in))) {

            String[] line = br.readLine().split(" ");
            int N = Integer.parseInt(line[0]);
            int M = Integer.parseInt(line[1]);

            int[][] mat = new int[N][M];
            int startX = 0;
            int startY = 0;

            for (int i=0; i<N ; i++) {
                String[] data = br.readLine().split(" ");
                for (int j=0 ;j<data.length ; j++) {
                    mat[i][j] = Integer.parseInt(data[j]);
                    if (mat[i][j] == 2) {
                        startX = j;
                        startY = i;
                    }
                }
            }

            bfs(startY, startX, mat);
            for (int i=0; i<N ; i++) {
                for (int j=0 ;j<M; j++) {
                    System.out.print(mat[i][j] + " ");
                }
                System.out.println();
            }
        } catch (IOException e) {
            // TODO
        }

    }
    static int bfs(int rowid, int colid, int[][] mat) {
        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};

        Queue<Point> q = new LinkedList<>();
        q.add(new Point(colid, rowid, 0));
        Point point = null;
        boolean[][] seen = new boolean[mat.length][mat[0].length];
        seen[rowid][colid] = true;
        mat[rowid][colid] = 0;
        while (!q.isEmpty()) {
            point = q.poll();
            for (int i=0; i<4; i++) {
                int nx = point.x + dx[i];
                int ny = point.y + dy[i];
                if (0 <= nx && nx < mat[0].length && 0 <= ny && ny < mat.length) {
                    if (!seen[ny][nx] && mat[ny][nx] == 1) {
                        seen[ny][nx] = true;
                        mat[ny][nx] = point.count + 1;
                        q.add(new Point(nx, ny, point.count + 1));
                    }
                }
            }
        }
        for (int i=0 ; i<seen.length ; i++) {
            for (int j=0; j<seen[0].length ; j++){
                if (seen[i][j] == false && mat[i][j] != 0) {
                    mat[i][j] = -1;
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
