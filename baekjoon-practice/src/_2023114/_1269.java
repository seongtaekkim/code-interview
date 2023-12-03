package _2023114;

import java.io.*;
import java.util.*;

/**
 * 1269 대칭 차집합
 * https://www.acmicpc.net/problem/1269
 */
public class _1269 {
    public static void main(String[] args) {
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(System.in))) {

            String[] line = br.readLine().split(" ");
            int N = Integer.parseInt(line[0]);
            int M = Integer.parseInt(line[1]);

            Set<String> A = new HashSet<>();

            String[] input1 = br.readLine().split(" ");

            for (int i=0 ; i<input1.length ; i++)
                A.add(input1[i]);

            String[] input2 = br.readLine().split(" ");
            int cnt=0;
            for (int i=0 ; i<input2.length ; i++) {
                if (!A.add(input2[i])) {
                    cnt++;
                }
            }
            System.out.println(A.size()-cnt);

        } catch (IOException e) {
            // TODO
        }
    }
}
