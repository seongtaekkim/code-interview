package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 1759 암호 만들기
 * https://www.acmicpc.net/problem/1759
 *
 */
public class _1759 {

    static int L, C;
    static boolean[] valid;
    static String[] arr;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(System.in))) {
            String[] input1 = br.readLine().split(" ");
            L = Integer.parseInt(input1[0]);
            C = Integer.parseInt(input1[1]);
            String[] input = br.readLine().split(" ");
            arr = new String[input.length];
            valid = new boolean[C];
            for (int i=0; i<input.length ; i++) {
                arr[i] = input[i];
            }
            Arrays.sort(arr);
            check(0,0);
            System.out.println(sb);

        } catch (IOException e) {
            //TODO
        }
    }

    private static void check(int start, int size) {
        if (L == size) {
            String word = "";
            int a = 0;
            int b = 0;
            for (int i = 0; i < C; i++) {
                if (valid[i]) {
                    word += arr[i];
                    if (arr[i].equals("a") || arr[i].equals("e") || arr[i].equals("i") || arr[i].equals("o") || arr[i].equals("u")) {
                        a++;
                    } else {
                        b++;
                    }
                }
            }

            if (a >= 1 && b >= 2) {
                System.out.println(word);
            }
        }

        for (int i=start ; i < C ; i++) {
            valid[i] = true;
            check(i+1, size+1);
            valid[i] = false;
        }
    }


}
