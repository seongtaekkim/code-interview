package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 9663 N-Queen
 * https://www.acmicpc.net/problem/9663
 */
public class _9663 {
    static boolean[] flag_a;
    static boolean[] flag_b;
    static boolean[] flag_c;
    static int[] pos;

    static int cnt =0;
    static int N;
    static void set(int i) {
        for (int j=0; j<N ; j++) {
            if (flag_a[j] == false && flag_b[i + j] == false && flag_c[i-j+N-1] == false ) {
                pos[i] = j;
                if (i == (N-1))
                    cnt++;
                else {
                    flag_a[j] = flag_b[i+j] =flag_c[i-j+N-1] = true;
                    set(i + 1);
                    flag_a[j] = flag_b[i+j] =flag_c[i-j+N-1] = false;
                }
            }
        }
    }
    public static void main(String[] args) {
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(System.in))) {

            N = Integer.parseInt(br.readLine());
            pos = new int[N];
            flag_a = new boolean[N];
            flag_b = new boolean[2*N-1];
            flag_c = new boolean[2*N-1];
            set(0);
            System.out.println(cnt);
        } catch (IOException e) {
            // TODO
        }
    }
}
