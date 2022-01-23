package leetcode;

import java.util.*;

/**
 * 2021-11-4
 */
public class P200 {
    public static void main(String[] args) {
        char[][] grid = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        System.out.println(numIslands1(grid));
    }

    public static int numIslands1(char[][] grid) {
        Map<List<Integer>,Integer> map = new HashMap<>();
        for (int i=0;i<grid.length;i++){
            for (int j = 0;j < grid[0].length;j++){
                if (grid[i][j]=='1'){
//                    int[] temp = {i,j};
                    map.put(Collections.unmodifiableList(Arrays.asList(i,j)),0);
                }
            }
        }
        /*System.out.println(map.get(Arrays.asList(0, 1)));
        return -1;*/
        /*for (Map.Entry<int[], Integer> integerEntry : map.entrySet()) {
            System.out.println(integerEntry.getKey()[0] + " " + integerEntry.getKey()[1] + "--" + integerEntry.getValue());
        }
        int[] a = {0,1};
        System.out.println(map.get(a)); // 取不出来的原因是因为，a和map中相应的int数组不是同一个对象；
        return -1;*/
        /*for (Map.Entry<int[], Integer> integerEntry : map.entrySet()) {
            System.out.println(integerEntry.getKey()[0] + " " + integerEntry.getKey()[1] + "--" + integerEntry.getValue());
        }
        return -1;*/
        int res = 0;
        for (Map.Entry<List<Integer>, Integer> integerEntry : map.entrySet()) {
            if (integerEntry.getValue()==0){
                Queue<List<Integer>> que = new LinkedList<>();
                que.add(Arrays.asList(integerEntry.getKey().get(0),integerEntry.getKey().get(1)));
                integerEntry.setValue(1);
                while(!que.isEmpty()){
                    List<Integer> poll = que.poll();
                    /*if (map.get(poll)==1){
                        continue;
                    }*/
                    List<Integer> list = new ArrayList<>();

                    int hang = poll.get(0)-1;
                    int lie = poll.get(1);
                    if (hang>=0 && grid[hang][lie]=='1' && map.get(Arrays.asList(hang,lie))==0){
                        que.add(Arrays.asList(hang,lie)); // 加进某个岛屿中
                        map.put(Arrays.asList(hang,lie),1); // 已访问
                    }

                    // 往下找
                    hang = poll.get(0)+1;
                    lie = poll.get(1);
                    if (hang<grid.length && grid[hang][lie]=='1' && map.get(Arrays.asList(hang,lie))==0){
                        que.add(Arrays.asList(hang,lie)); // 加进某个岛屿中
                        map.put(Arrays.asList(hang,lie),1); // 已访问
                    }

                    // 往左找
                    hang = poll.get(0);
                    lie = poll.get(1)-1;
                    if (lie>=0 && grid[hang][lie]=='1' && map.get(Arrays.asList(hang,lie))==0){
                        que.add(Arrays.asList(hang,lie)); // 加进某个岛屿中
                        map.put(Arrays.asList(hang,lie),1); // 已访问
                    }

                    // 往右找
                    hang = poll.get(0);
                    lie = poll.get(1)+1;
                    if (lie<grid[0].length && grid[hang][lie]=='1' && map.get(Arrays.asList(hang,lie))==0){
                        que.add(Arrays.asList(hang,lie)); // 加进某个岛屿中
                        map.put(Arrays.asList(hang,lie),1); // 已访问
                    }
                }
                res++;
            }
        }
        return res;
    }
}
