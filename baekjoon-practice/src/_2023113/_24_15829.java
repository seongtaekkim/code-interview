package _2023113;

import java.io.*;
import java.math.BigInteger;

/**
 * 15829 해싱
 * https://www.acmicpc.net/problem/15829
 */
public class _24_15829 {
    public static void main(String[] args) {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            StringBuilder sb = new StringBuilder();

            int length = Integer.parseInt(br.readLine());
            String line = br.readLine();

            BigInteger hash_value = new BigInteger("0");

            for ( int i = 0 ; i < length ; i++ )
                hash_value = hash_value.add( BigInteger.valueOf( line.charAt(i) - 96).multiply( BigInteger.valueOf(31).pow(i)));

            sb.append( hash_value.remainder(BigInteger.valueOf(1234567891)));
            bw.write(sb.toString());
            bw.flush();
        } catch (IOException e) {
            // TOOD
        }
    }
}
