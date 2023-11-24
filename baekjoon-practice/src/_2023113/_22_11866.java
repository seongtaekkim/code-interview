package _2023113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 11866 요세푸스 문제 0
 * https://www.acmicpc.net/problem/11866
 */
public class _22_11866 {
    public static void main(String[] args) {
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(System.in))) {

            String[] line = br.readLine().split(" ");
            int num = Integer.parseInt(line[0]);
            int k = Integer.parseInt(line[1]);
            Queue_11866 queue = new Queue_11866(num);
            Queue_11866 result = new Queue_11866(num);

            for (int i = 1; i < num+1; i++)
                queue.push(i);

            int inc = 0;
            while (result.size() != num) {
                inc++;
                if (inc == k) {
                    result.push(queue.pop());
                    inc = 0;
                } else {
                    queue.push(queue.pop());
                }
            }
            System.out.print("<");
            while (result.size() != 0) {
                if (result.size() == 1)
                    System.out.print(result.pop() + ">");
                else
                    System.out.print(result.pop() + ", ");
            }

        } catch (IOException e) {
            // TODO
        }
    }
}

class Queue_11866 {
    private int[] resources;
    private int frontIdx;
    private int backIdx;
    public Queue_11866(int num) {
        resources = new int[num * num];
        frontIdx = 0;
        backIdx = 0;
    }
    public void push(int data) {
        resources[frontIdx] = data;
        frontIdx++;
    }
    public int pop() {
        if (this.frontIdx-this.backIdx == 0)
            return -1;
        return this.resources[this.backIdx++];
    }
    public int front() {
        if (this.frontIdx-this.backIdx == 0)
            return -1;
        return this.resources[this.backIdx];
    }
    public int back() {
        if (this.frontIdx-this.backIdx == 0)
            return -1;
        return this.resources[this.frontIdx-1];
    }
    public int size() {
        return frontIdx-backIdx;
    }
    public int empty() {
        if (frontIdx-backIdx > 0)
            return 0;
        return 1;
    }
}