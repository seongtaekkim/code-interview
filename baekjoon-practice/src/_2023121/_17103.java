package _2023121;
import java.io.*;
import java.math.BigInteger;

/**
 * 17103 골드바흐 파티션
 * https://www.acmicpc.net/problem/17103
 */
public class _17103 {

    public static boolean[] prime = new boolean[2000001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        get_prime();

        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++){
            int N = Integer.parseInt(br.readLine());

            int A = 0, B = N, cnt=0;
            for(int j=0; j<=(N/2); j++){
                if(!prime[A] && !prime[B]){
                    cnt ++;
                }
                A++;
                B--;
            }

            sb.append(cnt);
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
    public static void get_prime() {
        prime[0] = prime[1] = true;

        for(int i = 2; i <= Math.sqrt(prime.length); i++) {
            if(prime[i]) continue;
            for(int j = i * i; j < prime.length; j += i) {
                prime[j] = true;
            }
        }
    }
}
