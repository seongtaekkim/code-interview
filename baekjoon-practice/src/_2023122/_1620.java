package _2023122;

import java.io.*;
import java.util.*;

/**
 * 1620 나는야 포켓몬 마스터 이다솜
 * https://www.acmicpc.net/problem/1620
 */
public class _1620 {
    public static void main(String[] args) {
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(System.in))) {
            String[] line = br.readLine().split(" ");
            int N = Integer.parseInt(line[0]);
            int M = Integer.parseInt(line[1]);
            Map<String, Integer> map = new HashMap<>();
            String[] arr = new String[N+1];
            StringBuilder sb = new StringBuilder();
            for (int i=0; i<N ; i++) {
                String read = br.readLine();
                map.put(read, i + 1);
                arr[i+1] = read;
            }
            for (int i=0; i<M ; i++) {
                String read = br.readLine();
                Integer value = map.get(read);
                if (value == null) {
                    sb.append(arr[Integer.parseInt(read)]).append("\n");
                } else
                    sb.append(value).append("\n");
            }
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            bw.write(sb.toString());
            bw.flush();
        } catch (IOException e) {
            // TODO
        }
    }
}
