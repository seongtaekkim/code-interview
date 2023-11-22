package _2023113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 18258 큐 2
 * https://www.acmicpc.net/problem/18258
 */
public class _09_18258 {
    public static void main(String[] args) {
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(System.in))) {

            int num = Integer.parseInt(br.readLine());
            StringBuilder sb = new StringBuilder();
            Queue queue = new Queue(num);
            for (int i=0 ; i<num ; i++) {
                String[] line = br.readLine().split(" ");
                if ("push".equals(line[0]))
                    queue.push(Integer.parseInt(line[1]));
                else if ("pop".equals(line[0]))
                    sb.append(queue.pop()).append("\n");
                else if ("size".equals(line[0]))
                    sb.append(queue.size()).append("\n");
                else if ("empty".equals(line[0]))
                    sb.append(queue.empty()).append("\n");
                else if ("front".equals(line[0]))
                    sb.append(queue.front()).append("\n");
                else if ("back".equals(line[0]))
                    sb.append(queue.back()).append("\n");
            }
            System.out.println(sb);
        } catch (IOException e) {
            //TODO
        }
    }
}

class Queue {
    int[] resources;
    int frontIdx;
    int backIdx;
    public Queue(int num) {
        resources = new int[num];
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
