package _2023112;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 1181 단어 정렬
 * https://www.acmicpc.net/problem/1181
 *
 * Arrays.sort 활용해서 변경
 */
public class _20_1181 {
    public static void main(String[] args) {
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(System.in))) {

            int nums = Integer.parseInt(br.readLine());
            List<String> list = new ArrayList<>();
            boolean flag = false;
            list.add(br.readLine());
            for (int i=1; i<nums ; i++) {
                String line = br.readLine();
                flag = false;
                for (int j=0; j < list.size() ; j++) {
                    if (line.length() < list.get(j).length()) {
                        list.add(j, line);
                        flag = true;
                        break;
                    }
                    if (line.length() == list.get(j).length()) {
                        if (list.get(j).compareTo(line) > 0) {
                            list.add(j, line);
                            flag = true;
                            break;
                        }
                        if (list.get(j).compareTo(line) == 0) {
                            flag = true;
                            break;
                        }
                    }
                }
                if (!flag)
                    list.add(line);
            }

            list.stream().forEach(System.out::println);
        } catch (IOException e) {
            //TODO
        }
    }
}
