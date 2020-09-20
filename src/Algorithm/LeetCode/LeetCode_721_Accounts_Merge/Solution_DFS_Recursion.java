package Algorithm.LeetCode.LeetCode_721_Accounts_Merge;

import java.util.*;

class Solution_DFS_Recursion {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        // 先创造一个索引，方便之后由邮箱查找用户名
        Map<String, String> mailToName = new HashMap<String, String>();
        // 尝试把每个有关联的邮箱之间连起来，形成一个无向图
        Map<String, ArrayList<String>> graph = new HashMap();

        for (List<String> account : accounts){
            //把第一个邮箱把之后的都连起来
            String name = account.get(0);
            String mail = account.get(1);

            for (int i = 1; i < account.size(); i++){
                // 每一个邮箱连到第一个邮箱，第一个邮箱连到每一个邮箱
                graph.computeIfAbsent(account.get(i), x -> new ArrayList<>()).add(mail);
                graph.computeIfAbsent(mail, x -> new ArrayList<>()).add(account.get(i));

                mailToName.put(account.get(i), name);
            }
        }

        // 创造一个set来存每一个邮箱
        Set<String> seen = new HashSet<>();
        List<List<String>> ans = new ArrayList<>();

        for (String email : graph.keySet()){
            // 对于每一个邮箱，如果set里面没有，就进行dfs
            if (!seen.contains(email)){
                seen.add(email);
                List<String> temp = new ArrayList<>();
                temp.add(email);

                dfs(temp, email, graph, seen);

                Collections.sort(temp);
                // 在0位加入用户名
                temp.add(0, mailToName.get(email));
                ans.add(temp);
            }
        }
        return ans;
    }

    private void dfs(List<String> temp, String email, Map<String, ArrayList<String>> graph, Set<String> seen) {
            for(String _email: graph.get(email)) {
                if (!seen.contains(_email)) {
                    seen.add(_email);
                    temp.add(_email);
                    dfs(temp, _email, graph, seen);
            }
        }
    }
}
