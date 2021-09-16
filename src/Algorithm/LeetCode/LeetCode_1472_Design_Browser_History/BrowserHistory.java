package Algorithm.LeetCode.LeetCode_1472_Design_Browser_History;

import java.util.LinkedList;
import java.util.List;

class BrowserHistory {
    private LinkedList<String> history;
    private int pointer;

    public BrowserHistory(String homepage) {
        history = new LinkedList<String>(List.of(homepage));
        pointer = 0;
    }

    public void visit(String url) {
        int size = history.size();
        for (int i = pointer + 1; i < size; i++) {
            history.removeLast();
        }

        history.add(url);
        pointer += 1;
    }

    public String back(int steps) {
        pointer -= steps;

        if (pointer < 0) {
            pointer = 0;
        }

        return history.get(pointer);
    }

    public String forward(int steps) {
        pointer += steps;

        if (pointer > history.size() - 1) {
            pointer = history.size() - 1;
        }

        return history.get(pointer);
    }

    public static void main(String[] args) {
        BrowserHistory obj = new BrowserHistory("jrbilt.com");
        obj.visit("uiza.com");
        obj.forward(3);
        obj.forward(3);
        obj.visit("fveyl.com");
        obj.visit("hyhqfqf.com");
        obj.back(3);
        obj.visit("cccs.com");
        obj.visit("bivz.com");
        obj.forward(6);
        obj.back(1);
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */
