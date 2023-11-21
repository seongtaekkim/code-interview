package _2023113;

import java.io.IOException;

/**
 * 10989 수 정렬하기 3
 * https://www.acmicpc.net/problem/10989
 */
public class _06_10989 {
    public static void main(String[] args) throws IOException {
        int maxNum = 10001;
        int num = readInt();
        int[] nums = new int[num];
        for (int i=0 ; i<num ; i++)
            nums[i] = readInt();

        int[] countArr = new int[maxNum];
        for (int i=0 ; i<num ; i++)
            countArr[nums[i]] += 1;

        int[] accCntArr = new int[maxNum];
        int before = 0;
        for (int i=0 ; i<maxNum ; i++) {
            accCntArr[i] = countArr[i] + before;
            before = accCntArr[i];
        }
        for (int i=0 ; i<maxNum ; i++)
            accCntArr[i]--;

        int[] sorted = new int[num];
        for (int i=num-1 ; i>=0 ; i--) {
            if (accCntArr[nums[i]] < 0) continue;
            sorted[accCntArr[nums[i]]] = nums[i];
            accCntArr[nums[i]]--;
        }

        StringBuilder sb =new StringBuilder();
        for(int s : sorted) {
            sb.append(s).append("\n");
        }
        System.out.print(sb);

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
