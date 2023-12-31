package _2023124;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


/**
 * 16928 뱀과 사다리 게임
 * https://www.acmicpc.net/problem/16928
 */
public class _16928 {
    public static void main(String[] args) throws Exception {


        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(System.in))) {

            String[] line = br.readLine().split(" ");
            int N = Integer.parseInt(line[0]); // 사다리
            int M = Integer.parseInt(line[1]); // 뱀

            List<Pair> list = new ArrayList<>();
            int[] board = new int[101];
            for (int i=0; i<(M+N) ; i++) {
                String[] str = br.readLine().split(" ");
                list.add(new Pair(Integer.parseInt(str[0]), Integer.parseInt(str[1])));
            }
            int bfs = bfs(board, list);
            System.out.println(bfs);

        } catch (IOException e) {
            // TODO
        }

    }

    static int bfs(int[] board, List<Pair> list) {

        Queue<Point> q = new LinkedList<>();
        board[0] = 1;
        board[1] = 1;
        q.add(new Point(1, 0)); // 1칸부터 시작.

        Point point = null;
        while (!q.isEmpty()) {
            point = q.poll();

            if (point.x == 100) {
                return point.count;
            }
            boolean flag = false;
            for (Pair p : list) {
                if (point.x == p.x) {
                    q.add(new Point(p.y, point.count ));
                    flag = true;
                }
            }

            if (!flag) {
                for (int i=1 ; i<=6 ; i++) {
                    int x = point.x + i;
                    if (x >= 1 && x <= 100) {
                        for (Pair p : list) {
                            if (x == p.x) {
                                q.add(new Point(p.y, point.count+1));
                                board[x] = 1;
                            }
                        }

                    }
                }
                for (int i = 1; i <= 6; i++) {
                    int x = point.x + i;
                    if (x >= 1 && x <= 100) {
                        if (board[x] == 0) {
                            board[x] = 1;
                            q.add(new Point(x, point.count + 1));
                        }
                    }
                }
            }
        }

        return point.count;
    }
    static class Pair {
        int x, y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static class Point {
        int x, count;

        Point(int x, int count) {
            this.x = x;
            this.count = count;
        }
    }
}
