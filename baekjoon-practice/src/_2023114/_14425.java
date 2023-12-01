package _2023114;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/**
 * 14425 문자열 집합
 * https://www.acmicpc.net/problem/14425
 */
public class _14425 {
    public static void main(String[] args) {
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(System.in))) {

             String[] line = br.readLine().split(" ");
             int N = Integer.parseInt(line[0]);
             int M = Integer.parseInt(line[1]);

            Set<String> set = new HashSet<>();
            for (int i=0 ; i<N ; i++)
                 set.add(br.readLine());

            String[] arr2 = new String[M];
            for (int i=0 ; i<M ; i++)
                arr2[i] = br.readLine();

            int cnt=0;
            for (int i=0 ; i< arr2.length ; i++) {
                if (set.contains(arr2[i]))
                    cnt++;
            }
            System.out.println(cnt);

        } catch (IOException e) {
            // TODO
        }
    }
}
