package Algorithm.LeetCode.LeetCode_120_Triangle;

import java.util.List;

class Solution_DFS_TimeOut {
    public int minimumTotal(List<List<Integer>> triangle) {
        return dfs(triangle, 0, 0);
    }

    private int dfs(List<List<Integer>> triangle, int i, int j) {
        int len = triangle.size();

        if (i < len - 1) {
            return Math.min(dfs(triangle, i + 1, j), dfs(triangle, i + 1, j + 1)) + triangle.get(i).get(j);
        }

        return triangle.get(i).get(j);
    }
}

//class Solution {
//    public int minimumTotal(List<List<Integer>> triangle) {
//        return  dfs(triangle, 0, 0);
//    }
//
//    private int dfs(List<List<Integer>> triangle, int i, int j) {
//        if (i == triangle.size()) {
//            return 0;
//        }
//        return Math.min(dfs(triangle, i + 1, j), dfs(triangle, i + 1, j + 1)) + triangle.get(i).get(j);
//    }
//}
//
//作者：Sweetiee 🍬
//链接：https://leetcode.cn/problems/triangle/solutions/329394/di-gui-ji-yi-hua-dp-bi-xu-miao-dong-by-sweetiee/
//来源：力扣（LeetCode）
//著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
