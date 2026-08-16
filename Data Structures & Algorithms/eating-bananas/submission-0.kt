class Solution {
    fun minEatingSpeed(piles: IntArray, h: Int): Int {

        fun pileTimeTaken(k: Int): Int{
            var total = 0
            piles.forEach{
                val cur = (it.toLong() + k - 1) / k
                total += cur.toInt()
                if(total>h) return total
            }
            return total
        }

        val n = piles.size
        var maxi = piles.maxOrNull()?:1
        var mini = 1
        var lastPile = 1
        while(mini<maxi){
            val mid = (maxi+mini)/2
            val ptt = pileTimeTaken(mid)
            if(ptt>h){
                mini = mid+1
            } else {
                maxi = mid
                lastPile = mid
            }
        } 
        return mini
    }
}
