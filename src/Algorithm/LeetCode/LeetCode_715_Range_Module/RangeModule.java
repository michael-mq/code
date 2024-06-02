package Algorithm.LeetCode.LeetCode_715_Range_Module;

import java.util.TreeMap;

// revisit
// https://www.youtube.com/watch?v=tGhX-ZAKlls
class RangeModule {
    private TreeMap<Integer, Integer> map;

    public RangeModule() {
        map = new TreeMap<>();
    }

    public void addRange(int left, int right) {
        Integer start = map.floorKey(left);

        if (start == null) {
            start = map.ceilingKey(left);
        }

        while (start != null && start <= right) {
            int end = map.get(start);

            // Overlapped
            if (end >= left) {
                map.remove(start);

                if (start < left) {
                    left = start;
                }

                if (end > right) {
                    right = end;
                }
            }

            // Move to the next entry
            start = map.ceilingKey(end);
        }

        map.put(left, right);
    }

    public boolean queryRange(int left, int right) {
        Integer start = map.floorKey(left);

        if (start == null) {
            return false;
        }

        return map.get(start) >= right;
    }

    public void removeRange(int left, int right) {
        Integer start = map.floorKey(left);

        if (start == null) {
            start = map.ceilingKey(left);
        }

        while (start != null && start <= right) {
            int end = map.get(start);

            if (end >= left) {
                map.remove(start);

                if (start < left) {
                    map.put(start, left);
                }

                if (end > right) {
                    map.put(right, end);
                }
            }

            // Move to the next entry
            start = map.ceilingKey(end);
        }


    }
}

/**
 * Your RangeModule object will be instantiated and called as such:
 * RangeModule obj = new RangeModule();
 * obj.addRange(left,right);
 * boolean param_2 = obj.queryRange(left,right);
 * obj.removeRange(left,right);
 */