package graph;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;


/**
 * 10026 적록색약
 * https://www.acmicpc.net/problem/10026
 */
public class _10026 {
    public static void main(String[] args) throws Exception {


        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(System.in))) {

            int N = Integer.parseInt(br.readLine());

            char[][] mat = new char[N][N];
            for (int i=0; i<N ; i++) {
                char[] charArray = br.readLine().toCharArray();
                for (int j=0; j<charArray.length ; j++) {
                    mat[i][j] = charArray[j];
                }
            }
            System.out.print(iso(mat) + " ");
            for (int i=0; i<mat.length ; i++) {
                for (int j=0; j<mat[0].length ; j++) {
                    if (mat[i][j] == 'R')
                        mat[i][j] = 'G';
                }
            }
            System.out.println(iso(mat));

        } catch (IOException e) {
            // TODO
        }

    }
    static int bfs(int rowid, int colid, char[][] mat, boolean[][] seen) {
        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};

        Queue<Point> q = new LinkedList<>();
        q.add(new Point(colid,rowid, 1));
        Point point = null;
        while (!q.isEmpty()) {
            point = q.poll();
            for (int i=0; i<4; i++) {
                int nx = point.x + dx[i];
                int ny = point.y + dy[i];
                if (0 <= nx && nx < mat[0].length && 0 <= ny && ny < mat.length) {
                    if (!seen[ny][nx]) {
                        if (mat[ny][nx] == mat[rowid][colid]) {
                            seen[ny][nx] = true;
                            q.add(new Point(nx, ny, point.count + 1));
                        }
                    }
                }
            }
        }

        return point.count;
    }
    static int iso(char[][] mat) {
        int count = 0;
        boolean[][] seen = new boolean[mat.length][mat[0].length];
        for (int i=0 ;i<mat.length ; i++) {
            for (int j=0 ; j<mat[0].length ; j++) {
                if (!seen[i][j]) {
                    bfs(i, j, mat, seen);
                    count++;
                }
            }
        }
        return count;
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
