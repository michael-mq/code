package Algorithm.LeetCode.LeetCode_2115_Find_All_Possible_Recipes_from_Given_Supplies;

import java.util.*;

class Solution_2 {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        List<String> allRecipes = new ArrayList<>();
        allRecipes.addAll(Arrays.asList(recipes));
        allRecipes.addAll(Arrays.asList(supplies));

        Map<String, Integer> inDegree = new HashMap<>();

        for (String recipe : allRecipes) {
            inDegree.put(recipe, 0);
        }

        Map<String, List<String>> graph = new HashMap<>();

        for (int i = 0; i < ingredients.size(); i++) {
            String recipe = recipes[i];
            List<String> ingredient = ingredients.get(i);

            for (String from : ingredient) {
                List<String> list = graph.computeIfAbsent(from, x -> new ArrayList<>());
                list.add(recipe);
            }

            inDegree.put(recipe, ingredients.get(i).size());
        }

        Set<String> realRecipes = new HashSet<>(Arrays.asList(recipes));
        Queue<String> queue = new LinkedList<>();
        List<String> result = new ArrayList<>();

        for (String key : inDegree.keySet()) {
            if (inDegree.get(key) == 0) {
                queue.offer(key);
            }
        }

        while (!queue.isEmpty()) {
            String ingredient = queue.poll();

            if (realRecipes.contains(ingredient)) {
                result.add(ingredient);
            }

            if (graph.containsKey(ingredient)) {
                for (String _recipe : graph.get(ingredient)) {
                    inDegree.put(_recipe, inDegree.get(_recipe) - 1);

                    if (inDegree.get(_recipe) == 0) {
                        inDegree.put(_recipe, 0);
                        queue.offer(_recipe);
                    }
                }
            }
        }

        return result;
    }
}