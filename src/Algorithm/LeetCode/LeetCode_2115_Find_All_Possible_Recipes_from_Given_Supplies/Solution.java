package Algorithm.LeetCode.LeetCode_2115_Find_All_Possible_Recipes_from_Given_Supplies;

import java.util.*;

class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        /**
         * 将原材料也看成是一个菜，这样才可以用一个图来描述 ingredients
         * 所以，真正的菜是 recipes + supplies ????
         */
        /**
         * 将菜也看成原材料，这样才可以用一个图来描述 ingredients
         * 所以，真正的原材料是 recipes + supplies
         */
        List<String> allRecipes = new ArrayList<>();
        allRecipes.addAll(Arrays.asList(recipes));
        allRecipes.addAll(Arrays.asList(supplies));
        /**
         * degree 记录每个菜的入度
         * graph 将 ingredients 转化成图
         */
        int[] inDegree = new int[allRecipes.size()];
        Map<String, List<String>> graph = new HashMap<>();

        for (int i = 0; i < ingredients.size(); i++) {
            /**
             * to 就是根据这些材料，可以制作的菜
             */
            String to = recipes[i];
            /**
             * 将这些原材料，和 可以制作的菜，制作成图
             *
             * graph.put(from, list) 原因：
             * 我们之后在 BFS 的时候，需要根据原材料，得到对应的菜，然后将对应菜的入度 - 1
             * 因为需要根据原材料得到菜，就需要 key 是原材料，value 是各个原材料可以制作的菜
             */
            for (int j = 0; j < ingredients.get(i).size(); j++) {
                String from = ingredients.get(i).get(j);
                List<String> list = graph.getOrDefault(from, new ArrayList<>());
                list.add(to);
                graph.put(from, list);
            }
            /**
             * 这个菜的入度，就是 ingredients 中这个菜的大小
             */
            inDegree[i] = ingredients.get(i).size();
        }
        /**
         * map 存储各个菜 和 对应在 allRecipes 中的下标
         * 因为下面的 BFS 用到了(先写 BFS，然后发现需要用这个，才在这儿补的)
         */
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < allRecipes.size(); i++) {
            map.put(allRecipes.get(i), i);
        }
        /**
         * set 存储真正的菜
         */
        Set<String> set = new HashSet<>(Arrays.asList(recipes));
        /**
         * 将入度为 0 的菜先放入队列，说明这些菜可以直接使用
         */
        Queue<String> queue = new LinkedList<>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                queue.offer(allRecipes.get(i));
            }
        }

        List<String> result = new ArrayList<>();
        /**
         * 每次从队列中获取一个元素(加入队列的元素说明是可以直接使用的)，判断这个元素是否在真正的菜谱中，是的话，就加入 result
         * 然后得到这个菜作为原材料的话，可以扩展到哪些菜，将对应菜的入度 - 1，如果这个菜的入度为 0 了，说明可以直接使用了，就加入队列
         */
        while (!queue.isEmpty()) {
            String poll = queue.poll();
            if (set.contains(poll)) {
                result.add(poll);
            }

            if (graph.containsKey(poll)) {
                for (String next : graph.get(poll)) {
                    int nextIndex = map.get(next);
                    inDegree[nextIndex]--;
                    if (inDegree[nextIndex] == 0) {
                        queue.offer(next);
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String[] recipes = new String[]{"bread", "sandwich", "burger"};
        List<List<String>> ingredients = List.of(List.of("yeast", "flour"), List.of("bread", "meat"), List.of("sandwich", "meat", "bread"));
        String[] supplies = new String[]{"yeast", "flour", "meat"};

        Solution solution = new Solution();

        System.out.println(solution.findAllRecipes(recipes, ingredients, supplies));
    }
}