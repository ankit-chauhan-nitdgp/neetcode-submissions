class Solution {
    fun isAnagram(s: String, t: String): Boolean {
        if(s.length != t.length){
            return false;
        }
        val hm = HashMap<Char, Int>();

        s.forEach{c ->
            hm.put(c, hm.getOrDefault(c, 0)+1);
        } 

        t.forEach{c ->
            hm.put(c, hm.getOrDefault(c, 0)-1);
        }

        hm.forEach{ (_,value) ->
            if(value != 0) return false;
        } 

        return true;
    }
}
