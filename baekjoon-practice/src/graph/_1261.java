package graph;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;


/**
 * 1261 알고스팟
 * https://www.acmicpc.net/problem/1261
 */
public class _1261 {
    public static void main(String[] args) throws Exception {

        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(System.in))) {

            String[] line = br.readLine().split(" ");
            int N = Integer.parseInt(line[1]);
            int M = Integer.parseInt(line[0]);

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

    static int bfs(int x, int y, int[][] mat) {
        Queue<Point> q = new PriorityQueue<>();
        int m = mat.length;
        int n = mat[0].length;
        boolean[][] check = new boolean[m][n];

        check[y][x] = true;
        q.add(new Point(x,y,0));
        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};

        while(!q.isEmpty()) {
            Point pos = q.poll();

            int px = pos.x;
            int py = pos.y;
            int pwall = pos.wall;

            // 도착
            if(px == n-1 && py == m-1) {
                return pwall;
            }

            for(int i=0; i<4 ; i++) {
                int nx = px+dx[i];
                int ny = py+dy[i];

                if(nx <0 || ny <0 || nx>n-1 || ny >m-1) continue;

                if(check[ny][nx]) continue;

                check[ny][nx] =true;
                if(mat[ny][nx]==0) {
                    q.add(new Point(nx,ny, pwall));
                }else {
                    q.add(new Point(nx,ny, pwall+1));
                }
            }

        }
        return 0;

    }


    static class Point implements Comparable<Point> {
        int x, y, wall;
        Point(int x, int y, int wall) {
            this.x = x;
            this.y = y;
            this.wall = wall;
        }

        @Override
        public int compareTo(Point o) {
            return wall-o.wall;
        }
    }
}
