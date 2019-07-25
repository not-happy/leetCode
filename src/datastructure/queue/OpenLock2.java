package datastructure.queue;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author xuyong
 * @since 2019-02-28 14:53
 **/
public class OpenLock2 {

    public int openLock(String[] deadends, String target) {
        boolean[] isVisit = new boolean[10000];
        boolean[] isDead = new boolean[10000];
        for (String deadEnd : deadends) {
            int deadNum = Integer.parseInt(deadEnd);
            isDead[deadNum] = true;
        }
        //如果"0000"在deadEnds中，返回-1
        if (isDead[0]) {
            return -1;
        }
        if ("0000".equals(target)) {
            return 0;
        }

        int step = 0;


        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(Integer.parseInt(target));
        isVisit[Integer.parseInt(target)] = true;
        int last = Integer.parseInt(target);
        int cenglast = last;
        while (!queue.isEmpty()) {
            while (true) {
                int head = queue.poll();
                if (head == 0) {
                    return step;
                }
                int[] nei = neighbor(head);
                for (int i = 0; i < 8; i++) {
                    int trans = nei[i];
                    if (isVisit[trans] || isDead[trans]) {
                        continue;
                    }
                    queue.offer(trans);
                    last = trans;
                    isVisit[trans] = true;
                }
                if (head == cenglast) {
                    break;
                }
            }
            step++;
            cenglast = last;
        }
        return -1;


    }

    private int[] neighbor(int code) {
        int[] res = new int[8];
        int a = code % 10;
        int b = (code / 10) % 10;
        int c = (code / 100) % 10;
        int d = (code / 1000) % 10;
        res[0] = d * 1000 + c * 100 + b * 10 + (a + 10 - 1) % 10;
        res[1] = d * 1000 + c * 100 + b * 10 + (a + 1) % 10;
        res[2] = d * 1000 + c * 100 + ((b + 10 - 1) % 10) * 10 + a;
        res[3] = d * 1000 + c * 100 + ((b + 1) % 10) * 10 + a;
        res[4] = d * 1000 + ((c + 10 - 1) % 10) * 100 + b * 10 + a;
        res[5] = d * 1000 + ((c + 1) % 10) * 100 + b * 10 + a;
        res[6] = ((d + 10 - 1) % 10) * 1000 + c * 100 + b * 10 + a;
        res[7] = ((d + 1) % 10) * 1000 + c * 100 + b * 10 + a;
        return res;
    }

    public static void main(String[] args) {
        int code = 2348;
        int a = code % 10;
        int b = (code / 10) % 10;
        int c = (code / 100) % 10;
        int d = (code / 1000) % 10;

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);

        System.out.println();

    }




}
