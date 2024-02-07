package backtracking;

import java.util.*;

/**
 * 1405 미친 로봇
 * https://www.acmicpc.net/problem/1405
 */
public class _1405 {

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static double[] percent;
    static boolean[][] visit;
    static double result;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        percent = new double[4];
        for(int i = 0; i < 4; i++)
            percent[i] = scan.nextInt() * 0.01;

        visit = new boolean[30][30]; // start : (15,15)
        dfs(15, 15, 0, n, 1);
        System.out.println(result);
    }

    public static void dfs(int x, int y, int idx, int n, double total) {
        if(idx == n) {
            result += total;
            return;
        }
        visit[x][y] = true;
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= 0 && ny >= 0 && nx < 30 && ny < 30) {
                if(!visit[nx][ny]) {
                    visit[nx][ny] = true;
                    dfs(nx, ny, idx + 1, n, total * percent[i]);
                    visit[nx][ny] = false;
                }
            }
        }
    }
}
