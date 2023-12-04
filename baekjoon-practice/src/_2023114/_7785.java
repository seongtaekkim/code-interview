package _2023114;

import java.io.*;
import java.util.*;

/**
 * 7785 회사에 있는 사람
 * https://www.acmicpc.net/problem/7785
 */
public class _7785 {
    public static void main(String[] args) {
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(System.in))) {

            String[] line = br.readLine().split(" ");
            int N = Integer.parseInt(line[0]);

            SortedSet<String> map = new TreeSet<>((s1, s2) -> s2.compareTo(s1));
            for (int i=0 ; i<N ; i++) {
                String[] input = br.readLine().split(" ");
                if ("enter".equals(input[1])) {
                    map.add(input[0]);
                } else {
                    map.remove(input[0]);
                }
            }

            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            for (String s : map)
                bw.write(s + "\n");
            bw.flush();

        } catch (IOException e) {
            // TODO
        }
    }
}
