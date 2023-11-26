package _2023113;

import java.io.IOException;

/**
 * 2108 통계학
 * https://www.acmicpc.net/problem/2108
 */
public class _23_2108 {
    public static void main(String[] args) throws IOException {
        int num = readInt();
        int[] arr = new int[8001];
        int OFFSET = 4000;
        for (int i=0 ; i<num ; i++) {
            arr[readInt() + OFFSET] += 1;
        }

        int sum = 0;
        for (int i=0 ; i<arr.length ; i++) {
            if (arr[i] != 0)
                sum = sum + (i-OFFSET) * arr[i]; // 값 * 개수
        }

        int median = 0;
        int medianIdx = 0;
        boolean flag = false;
        for (int i=0 ; i < arr.length ; i++) {
            for (int j=0 ; j<arr[i] ; j++) {
                medianIdx += 1;
                if (medianIdx == (num/2+1)) {
                    median = i;
                    flag = true;
                    break ;
                }
            }
            if (flag)
                break ;
        }


        int max = 0;
        int sndMax = 0;
        for (int i=0 ; i<arr.length ; i++) {
            if (arr[i] > arr[max])
                max = i;
        }
        sndMax = max;
        for (int i=max+1 ; i<arr.length ; i++) {
            if (arr[i] == arr[sndMax]) {
                sndMax = i;
                break;
            }
        }

        int minIdx = 0;
        int maxIdx = 0;
        for (int i=0 ; i<arr.length ; i++) {
            if (arr[i] != 0) {
                minIdx = i;
                break;
            }
        }
        for (int i=arr.length-1 ; i>=0 ; i--) {
            if (arr[i] != 0) {
                maxIdx = i;
                break;
            }
        }
        System.out.println(Math.round((float) sum/num));
        System.out.println(median - OFFSET);
        System.out.println(sndMax - 4000);
        System.out.println(maxIdx-minIdx);
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
