package backtracking;

import java.util.Scanner;

/**
 * 2661 좋은수열
 * https://www.acmicpc.net/problem/2661
 *
 *
 * 1. 1~3숫자를 하나씩 append 하면서 재귀한다.
 * 2. 재귀 함수에 입력된 문자열의 맨 뒤부터 1개, 2개 ... 절반까지의 패턴이 앞에도 있는 지 확인한다. (1212 => 맨뒤 12가 앞의 12와 같은 패턴이다)
 * 3. 2에서 패턴이 없는 경우만 재귀를 호출하도록 한다.
 */
public class _2661 {
    static int N;
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        bt("");

    }

    private static void bt(String str) {
        if (str.length() == N) {
            System.out.println(str);
            System.exit(0);
        }

        for (int i=1 ; i<=3 ; i++) {
            if (check(str+i))
                bt(str+i);
        }
    }

    private static boolean check(String s) {
        // 1212
        for (int i=1; i<=s.length()/2 ; i++) {
            String last = s.substring(s.length()-i);
            String nextto = s.substring(s.length() - i*2, s.length()-i);
            if (last.equals(nextto)) return false;
        }
        return true;
    }
}
