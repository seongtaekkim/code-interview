package _2023113;

import java.util.Scanner;

/**
 * 2164 카드2
 * https://www.acmicpc.net/problem/2164
 */
public class _10_2164 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

        Queue_2164 queue = new Queue_2164(num);
        for (int i=1; i<num+1 ; i++)
            queue.push(i);
        while (true) {
            if (queue.size() == 1) break ;
            queue.pop();
            queue.push(queue.pop());
        }
        System.out.println(queue.front());

    }
}

class Queue_2164 {
    private int[] resources;
    private int frontIdx;
    private int backIdx;
    public Queue_2164(int num) {
        resources = new int[num*2];
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
