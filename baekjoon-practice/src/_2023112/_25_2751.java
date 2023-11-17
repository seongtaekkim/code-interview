package _2023112;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.*;

/**
 * 2751 수 정렬하기 2
 * https://www.acmicpc.net/problem/2751
 *
 * Arrays.sort -> Collections.sort
 * System.out.println -> BufferedWriter
 * 참고: https://www.acmicpc.net/board/view/31887
 */
public class _25_2751 {
    public static void main(String[] args) throws IOException {
        int num = readInt();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        List<Integer> nums = new ArrayList<>(num);
        for (int i =0 ; i<num ; i++)
            nums.add(readInt());

        Collections.sort(nums, new Comparator<>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
        for (Integer i : nums)
            bw.write(i + "\n");
        bw.flush();
    }

    static int readInt() throws IOException {
        int sum = 0;
        boolean isNegative = false;
        while (true) {
          int input = System.in.read();
          if (input == '\n' || input == ' ')
              return isNegative ? sum * -1 : sum;
          else if (input == '-')
              isNegative = true;
          else
              sum = (sum * 10) + input - '0';
        }
    }
}
