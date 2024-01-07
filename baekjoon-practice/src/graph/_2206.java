package graph;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;


/**
 * 2206 벽 부수고 이동하기
 * https://www.acmicpc.net/problem/2206
 */
public class _2206 {
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
                char[] charArray = br.readLine().toCharArray();
                for (int j=0 ; j<charArray.length ; j++) {
                    mat[i][j] = charArray[j] - '0';
                }
            }

            System.out.println(bfs(startY, startX, mat));;
        } catch (IOException e) {
            // TODO
        }

    }
    static int bfs(int rowid, int colid, int[][] mat) {
        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};

        Queue<Point> q = new LinkedList<>();
        q.add(new Point(colid, rowid, 0, 1));
        Point point = null;
        int[][][] seen = new int[2][mat.length][mat[0].length];
        seen[0][rowid][colid] = 1;
        while (!q.isEmpty()) {
            point = q.poll();
            if (point.y == mat.length-1 && point.x == mat[0].length-1) {
                return point.count;
            }
            for (int i=0; i<4; i++) {
                int nx = point.x + dx[i];
                int ny = point.y + dy[i];
                if (0 <= nx && nx < mat[0].length && 0 <= ny && ny < mat.length) {

                    if (mat[ny][nx] == 0) {
                        if (seen[point.wall][ny][nx] == 0) {
                            q.add(new Point(nx, ny, point.wall ,point.count + 1));
                            seen[point.wall][ny][nx] = seen[point.wall][point.y][point.x] + 1;
                        }

                    } else {
                        if (point.wall == 0) {
                            q.add(new Point(nx, ny, point.wall+1 ,point.count + 1));
                            seen[point.wall+1][ny][nx] = seen[point.wall][point.y][point.x] + 1;
                        }
                    }
                }
            }
        }
        return -1;
    }

    static class Point {
        int x, y, wall, count;
        Point(int x, int y, int wall, int count) {
            this.x = x;
            this.y = y;
            this.wall = wall;
            this.count = count;
        }
    }
}
