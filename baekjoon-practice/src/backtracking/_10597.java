package backtracking;

import java.util.Scanner;

/**
 * 10597 순열장난
 * https://www.acmicpc.net/problem/10597
 *
 * 1. 숫자를 하나씩 잘라서 재귀하면 순열결과를 하나씩 추가하였따.
 * 2. 2번재 재귀 조건에 숫자 두개씩 잘라서 다시 재귀로 돌렸따.
 * 3. 제한 숫자가 50까지여서 위의 두 조건만 적용함
 */
public class _10597 {
    static String input;
    static int N;
    static boolean[] valid = new boolean[51];

    static void bt(int idx, int max, String ans){
        if(idx == N) {
            for(int i=1; i<=max; i++)
                if(!valid[i]) return;
            System.out.println(ans);
            System.exit(0);
        }

        String s = input.substring(idx, idx+1);
        int num = Integer.parseInt(s);
        if(!valid[num]) {
            valid[num] = true;
            bt(idx+1, Math.max(num, max), ans+" "+s);
            valid[num] = false;
        }

        if(idx < N-1){
            s = input.substring(idx, idx+2);
            num = Integer.parseInt(input.substring(idx, idx+2));
            if(num<51 && !valid[num]){
                valid[num] = true;
                bt(idx+2, Math.max(num, max), ans+" "+s);
                valid[num] = false;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        input = scanner.next();
        N = input.length();
        bt(0,0,"");
    }
}
