package datastructure.queue;

import java.util.*;

/**
 * @author xuyong
 * @since 2019-02-26 16:42
 **/
public class NumIslands {

    Queue<String> queue = new LinkedList<>();
    Set<String> hashSet = new HashSet<>();

    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    if (handle(i, j, grid)) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    private boolean handle(int i, int j, char[][] grid) {
        if(hashSet.contains(getKey(i, j))){
            return false;
        }

        queue.offer(getKey(i, j));

        while (!queue.isEmpty()) {
            int size = queue.size();
            String key = queue.peek();
            for (int k = 0; k < size; k++) {
                int x = Integer.parseInt(key.split("_")[0]);
                int y = Integer.parseInt(key.split("_")[1]);

                if (x - 1 >= 0 && grid[x - 1][y] == '1' && !hashSet.contains(getKey(x - 1, y))) {
                    queue.offer(getKey(x - 1, y));
                    hashSet.add(getKey(x - 1, y));
                }
                if (x + 1 < grid.length && grid[x + 1][y] == '1' && !hashSet.contains(getKey(x + 1, y))) {
                    queue.offer(getKey(x + 1, y));
                    hashSet.add(getKey(x + 1, y));
                }
                if (y - 1 >= 0 && grid[x][y - 1] == '1' && !hashSet.contains(getKey(x, y - 1))) {
                    queue.offer(getKey(x, y - 1));
                    hashSet.add(getKey(x, y - 1));
                }
                if (y + 1 < grid[x].length && grid[x][y + 1] == '1' && !hashSet.contains(getKey(x, y + 1))) {
                    queue.offer(getKey(x, y + 1));
                    hashSet.add(getKey(x, y + 1));
                }
            }
            queue.poll();
        }
        return true;
    }

    private String getKey(int i, int j) {
        return i + "_" + j;
    }

    public static void main(String[] args) {
//        char[][] grid = new char[4][5];
//        grid[0] = new char[]{'1', '1', '1', '1', '0'};
//        grid[1] = new char[]{'1', '1', '0', '1', '0'};
//        grid[2] = new char[]{'1', '1', '0', '0', '0'};
//        grid[3] = new char[]{'0', '0', '0', '0', '0'};

        char[][] grid = new char[3][3];
        grid[0] = new char[]{'1', '1', '1'};
        grid[1] = new char[]{'0', '1', '0'};
        grid[2] = new char[]{'1', '1', '1'};
        System.out.println(new NumIslands().numIslands(grid));
    }

}
