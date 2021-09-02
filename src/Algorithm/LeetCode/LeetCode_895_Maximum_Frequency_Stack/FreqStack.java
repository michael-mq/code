package Algorithm.LeetCode.LeetCode_895_Maximum_Frequency_Stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class FreqStack {
    int maxFreq;
    Map<Integer, Integer> valToFreq;
    Map<Integer, Stack<Integer>> freqToVals;

    public FreqStack() {
        maxFreq = 0;
        valToFreq = new HashMap<>();
        freqToVals = new HashMap<>();
    }

    public void push(int val) {
        int freq = valToFreq.getOrDefault(val, 0) + 1;
        valToFreq.put(val, freq);

        Stack<Integer> stack = freqToVals.computeIfAbsent(freq, k -> new Stack<>());
        stack.push(val);
        freqToVals.put(freq, stack);

        maxFreq = Math.max(maxFreq, freq);
    }

    public int pop() {
        int val = freqToVals.get(maxFreq).pop();

        valToFreq.put(val, valToFreq.get(val) - 1);

        if (freqToVals.get(maxFreq).empty()) {
            maxFreq--;
        }

        return val;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */
