class Solution {
    fun foreignDictionary(words: Array<String>): String {
        val map = HashMap<Char,MutableSet<Char>>()

        val n = words.size

        var i = 0

        for (word in words) {
                for (ch in word) {
                    map.getOrPut(ch) { mutableSetOf() }
                }
            }

        while(i<n-1){
            val word1 = words[i].toCharArray()
            val word2 = words[i+1].toCharArray()

            var j = 0
            val w1 = word1.size
            var k = 0
            val w2 = word2.size
            var found = false

            val mlen = minOf(w1,w2)
            
            while (j < mlen) {
                if (word1[j] != word2[j]) {
                    map.getOrPut(word1[j]) { mutableSetOf() }.add(word2[j])
                    break
                }
                j++
            }

            if (j == mlen && w1 > w2) return ""
                        i++
            }

        
        val visited = HashSet<Char>()
        val visiting = HashSet<Char>()
        val result = mutableListOf<Char>()

        fun dfs(node: Char): Boolean{
            if(visiting.contains(node)) return false
            if(visited.contains(node)) return true
            visiting.add(node)
            map[node]?.forEach{
                 if (!dfs(it)) return false
            }
            result.add(node)
            visited.add(node)
            visiting.remove(node)
            return true
        }
        
        for(key in map.keys){
            if(!dfs(key)) return ""
        }

        return result.reversed().joinToString("")
    }
}
