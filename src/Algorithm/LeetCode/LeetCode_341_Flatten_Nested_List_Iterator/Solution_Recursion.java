package Algorithm.LeetCode.LeetCode_341_Flatten_Nested_List_Iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Solution_Recursion implements Iterator<Integer> {
    List<Integer> list = new ArrayList<>();
    ListIterator<Integer> it;

    public Solution_Recursion(List<NestedInteger> nestedList) {
        dfs(nestedList);
        it = list.listIterator();
    }

    @Override
    public Integer next() {
        return it.next();
    }

    @Override
    public boolean hasNext() {
        return it.hasNext();
    }

    private void dfs(List<NestedInteger> nestedList) {
        for (NestedInteger nestedInteger : nestedList) {
            if (nestedInteger.isInteger()) {
                list.add(nestedInteger.getInteger());
            } else {
                dfs(nestedInteger.getList());
            }
        }
    }
}
