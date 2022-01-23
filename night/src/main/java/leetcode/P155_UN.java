package leetcode;

import java.util.*;

/**
 * 2021-11-2
 * 设计栈
 *
 * 需要重新做，使用双栈，加一个minStack，跟另一个stack一块puah和pop，就是push的时候，要push minStavk.peek()和当前要push的值中的最小值才剋
 * 这样即使另一个stack pop掉了当前最小值的话，minstack pop之后的栈顶就是最小值了；
 */
public class P155_UN {
    // private int min;
    private List<Integer> list;
    private Set<Integer> set;
    public P155_UN() {
        list = new ArrayList<>();
        set = new TreeSet<>();
        // min = Integer.MAX_VALUE;
    }

    public void push(int val) {
        list.add(val);
        set.add(val);
        // if (val<min){
        //     min = val;
        // }
    }

    public void pop() {
        if (list.size()>0){
            set.remove(list.get(list.size())-1);
            list.remove(list.size()-1);
        }
    }

    public int top() {
        if (list.size()>0){
            return list.get(list.size()-1);
        }
        return -1;
    }

    public int getMin() {
        for (Integer integer : set) {
            return integer;
        }
        int min = Integer.MAX_VALUE;
        for(int i : list){
            min = i<min?i:min;
        }
        return min;
    }
}
