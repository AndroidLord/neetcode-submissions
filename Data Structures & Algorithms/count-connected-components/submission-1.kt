class Solution {
    fun countComponents(n: Int, edges: Array<IntArray>): Int {
        val r = edges.size
        var c = edges[0].size

        val map = HashMap<Int,MutableList<Int>>()

        for(edge in edges){
            val node1 = edge[0]
            val node2 = edge[1]
            map.getOrPut(node1) { mutableListOf() }.add(node2)
            map.getOrPut(node2) { mutableListOf() }.add(node1)
        }

        val visited = HashSet<Int>()
        var ans = 0

        fun dfs(i: Int){
            if(visited.contains(i)) return
            visited.add(i)
            for(num in map[i]?: mutableListOf()){
                dfs(num)
            }
        }

        for(i in 0 until n){
            if(visited.contains(i)) continue
            ans++
            dfs(i)
        }
        return ans 
    }
}
