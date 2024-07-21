class Solution {
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[V];
        q.add(0);

        while(!q.isEmpty()) {
            int currNode = q.remove();
            if(!vis[currNode]) {
                ans.add(currNode);
                vis[currNode] = true;
                for(int i = 0; i < adj.get(currNode).size(); i++) {
                    q.add(adj.get(currNode).get(i));
                }
            }
        }
        
        return ans;
    }
}