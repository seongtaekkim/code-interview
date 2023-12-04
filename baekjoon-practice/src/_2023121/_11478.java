package _2023121;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/**
 * 11478 서로 다른 부분 문자열의 개수
 * https://www.acmicpc.net/problem/11478
 */
public class _11478 {
    public static void main(String[] args) {
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(System.in))) {

            String line = br.readLine();
            Set<String> set = new HashSet<>();
            int wcnt = 1;
            while (true) {
                if (wcnt > line.length()) break ;
                for (int i = 0; i < line.length() - wcnt + 1; i++) {
                    set.add(line.substring(i, i + wcnt));
                }
                wcnt++;
            }
            System.out.println(set.size());
        } catch (IOException e) {
            // TODO
        }
    }
}
