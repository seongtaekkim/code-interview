package _2023122;

import java.io.*;
import java.util.*;

/**
 * 17219 비밀번호 찾기
 * https://www.acmicpc.net/problem/17219
 */
public class _17219 {
    public static void main(String[] args) {
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(System.in))) {

            StringBuilder sb = new StringBuilder();
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            String[] line = br.readLine().split(" ");
            int N = Integer.parseInt(line[0]);
            int M = Integer.parseInt(line[1]);

            Map<String, String> map = new HashMap<>();
            for (int i=0; i<N ; i++) {
                String[] data = br.readLine().split(" ");
                map.put(data[0], data[1]);
            }
            for (int i=0; i<M ; i++) {
                sb.append(map.get(br.readLine())).append("\n");
            }

            System.out.println(sb);
        } catch (IOException e) {
            // TODO
        }
    }
}
