class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean vis[] = new boolean[V+1];
        ArrayList<Integer> ls = new ArrayList<>();
        dfs(0, vis, adj, ls); 
        return ls;
    }
    public static void dfs(int node, boolean vis[], ArrayList<ArrayList<Integer>> adj, 
    ArrayList<Integer> ls) {
        
        //marking current node as visited
        vis[node] = true;
        ls.add(node);
        
        //getting neighbour nodes
        for(Integer it: adj.get(node)) {
            if(vis[it] == false) {
                dfs(it, vis, adj, ls);
            }
        }
    }
}