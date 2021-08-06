package Algorithm.LeetCode.LeetCode_341_Flatten_Nested_List_Iterator;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class Solution_Stack implements Iterator<Integer> {
    Stack<NestedInteger> stack = new Stack<>();

    public Solution_Stack(List<NestedInteger> nestedList) {
        prepareStack(nestedList);
    }

    @Override
    public Integer next() {
        return stack.pop().getInteger();
    }

    @Override
    public boolean hasNext() {
        while (!stack.isEmpty() && !stack.peek().isInteger()) {
            List<NestedInteger> list = stack.pop().getList();
            prepareStack(list);
        }

        return !stack.isEmpty();
    }

    private void prepareStack(List<NestedInteger> nestedList) {
        for (int i = nestedList.size() - 1; i >= 0; i--) {
            stack.push(nestedList.get(i));
        }
    }
}
