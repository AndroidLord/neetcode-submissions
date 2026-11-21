class Solution {
    fun validTree(n: Int, edges: Array<IntArray>): Boolean {
        // A tree with n nodes must have exactly n-1 edges
        if (edges.size != n - 1) return false

        val adjacencyList = HashMap<Int, MutableList<Int>>()

        // Build an undirected graph
        for (edge in edges) {
            val u = edge[0]
            val v = edge[1]

            adjacencyList.getOrPut(u) { mutableListOf() }.add(v)
            adjacencyList.getOrPut(v) { mutableListOf() }.add(u)
        }

        val visited = HashSet<Int>()

        fun dfs(node: Int, parent: Int): Boolean {
            if (node in visited) return false

            visited.add(node)

            for (neighbor in adjacencyList[node] ?: emptyList()) {
                if (neighbor == parent) continue

                if (!dfs(neighbor, node)) return false
            }

            return true
        }

        // Check for cycles and connectivity
        if (!dfs(0, -1)) return false

        return visited.size == n
    }
}