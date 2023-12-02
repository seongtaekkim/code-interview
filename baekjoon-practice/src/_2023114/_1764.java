package _2023114;

import java.io.*;
import java.util.*;

/**
 * 1764 듣보잡
 * https://www.acmicpc.net/problem/1764
 */
public class _1764 {
    public static void main(String[] args) {
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(System.in))) {

            String[] line = br.readLine().split(" ");
            int N = Integer.parseInt(line[0]);
            int M = Integer.parseInt(line[1]);

            Set<String> set = new HashSet<>();
            StringBuilder sb = new StringBuilder();
            for (int i=0 ; i<N ; i++) {
                set.add(br.readLine());
            }
            int cnt=0;

            List<String> result = new ArrayList<>();
            for (int i = 0; i<M ; i++) {
                String tmp = br.readLine();
                if (!set.add(tmp)) {
                    cnt++;
                    result.add(tmp);
                }
            }
            Collections.sort(result);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            bw.write(cnt+"\n");
            for (String s : result)
                bw.write(s + "\n");
            bw.flush();
        } catch (IOException e) {
            // TODO
        }
    }
}
