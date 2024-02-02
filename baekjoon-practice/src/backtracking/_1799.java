package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 1799 비숍
 * https://www.acmicpc.net/problem/1799
 *
 *
 10
 1 1 0 0 0 0 0 1 0 1
 1 1 0 0 0 0 1 1 1 0
 1 0 0 0 0 0 0 1 0 0
 0 0 0 1 1 0 1 1 1 0
 0 1 0 0 0 1 0 0 1 0
 1 0 1 0 1 0 1 1 1 1
 0 0 0 0 0 1 0 1 1 1
 1 1 0 1 1 1 1 1 1 0
 0 0 0 0 1 0 1 1 0 1
 1 1 1 1 1 0 1 0 0 0

 3
 0 1 1
 1 1 1
 1 1 1
 */
public class _1799 {
//    static boolean[] flag_a;
    static boolean[] flag_b;
    static boolean[] flag_c;
    static int[] pos;

    static int max =0;
    static int N;
    static void set(int i, int cnt) {
        if (i == 2 * N -1) {
//            System.out.println(cnt);
            max = Math.max(max, cnt);
            return;
        }
        boolean isExist = false;
        for (int j=0; j<=i ; j++) {
//            System.out.println(j + " " + i);
            if (j >= N || i - j >= N || map[j][i - j] != 1) continue;;
//            if (flag_b[j] == false && flag_c[-j+N-1] == false ) {
            if (isAvailable(j, i - j, i)) {
//                    pos[i] = j;
//                System.out.println(i + " " + (i-2*j+N-1));
                    flag_b[j] =flag_c[-j+N-1] = true;
//                System.out.println("row:" + i + " col: " + j);
                cache[i] = j;
                    set(i + 1, cnt+1);
//                flag_b[i] =flag_c[i-2*j+N-1] = false;
//                    flag_b[i+j] =flag_c[i-j+N-1] = false;
                isExist = true;
            }
        }
        if (!isExist) {
            cache[i] = -1;
            set(i + 1, cnt);
        }
    }
    static int[] cache;
    private static boolean isAvailable(int x, int y, int idx) {
        while(idx >= 2 && x >= 1 && y >= 1) {
            idx -= 2;
            x -= 1;
            y -= 1;
            if (cache[idx] == x) return false;
        }
        return true;
    }

    static int[][] map;
    public static void main(String[] args) {
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(System.in))) {

            N = Integer.parseInt(br.readLine());

            map = new int[N][N];
            for (int i=0; i <N ; i++) {
                String[] tmp = br.readLine().split(" ");
                for (int j=0 ; j<tmp.length; j++)
                    map[i][j] = Integer.parseInt(tmp[j]);
            }

            pos = new int[N];
//            flag_a = new boolean[N];
            flag_b = new boolean[2*N-1];
            flag_c = new boolean[2*N-1];
            cache = new int[2 * N - 1];
            set(0,0);
            System.out.println(max);
//            Arrays.stream(pos).forEach(System.out::println);

        } catch (IOException e) {
            // TODO
        }
    }
}
