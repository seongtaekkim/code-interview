package graph;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;


/**
 * 9019 DSLR
 * https://www.acmicpc.net/problem/9019
 */
public class _9019 {
    public static void main(String[] args) throws Exception {


        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(System.in))) {

            int N = Integer.parseInt(br.readLine());

            for (int i=0; i<N ; i++) {
                String[] s = br.readLine().split(" ");
                System.out.println(bfs(Integer.parseInt(s[0]), Integer.parseInt(s[1])));
            }

        } catch (IOException e) {
            // TODO
        }

    }
    static String bfs(int start, int end) {

        boolean[] seen = new boolean[10000];
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(start, ""));
        Point point = null;
        while (!q.isEmpty()) {
            point = q.poll();
            if (point.x == end) {
                return point.cmd;
            }

            int d = point.D();
            if (!seen[d]) {
                seen[d] = true;
                q.add(new Point(d, point.cmd + "D"));
            }
            int s = point.S();
            if (!seen[s]) {
                seen[s] = true;
                q.add(new Point(s, point.cmd + "S"));
            }
            int r = point.R();
            if (!seen[r]) {
                seen[r] = true;
                q.add(new Point(r, point.cmd + "R"));
            }
            int l = point.L();
            if (!seen[l]) {
                seen[l] = true;
                q.add(new Point(l, point.cmd + "L"));
            }

        }

        return point.cmd;
    }
    static class Point {
        int x;
        String cmd;

        Point(int x, String cmd) {
            this.x = x;
            this.cmd = cmd;
        }

        int D() {
            return (x * 2) % 10000;
        }

        int S() {
            return x == 0 ? 9999 : x - 1;
        }

        int L() {
            return x % 1000 * 10 + x / 1000;
        }

        int R() {
            return x % 10 * 1000 + x / 10;
        }
    }
    }
