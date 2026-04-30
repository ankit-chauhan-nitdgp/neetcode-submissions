class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        if(s.length() <= 1){
            return s.length();
        }
        int i=0;
        int j = 0;
        HashMap<Character, Integer> hm = new HashMap<>();
        int ans = 0;

        while(i<s.length()){
            
            int temp = j;
            for(int k = temp; k<i; k++){
                if(hm.getOrDefault(s.charAt(i), 0) > 0){
                    hm.put(s.charAt(k), hm.get(s.charAt(k))-1);
                }
                if(s.charAt(i) == s.charAt(k)){
                    j = k+1;
                }
            }

            ans = Math.max(i-j+1, ans);
            
            hm.put(s.charAt(i), hm.getOrDefault(s.charAt(i), 0)+1);
            i++;
        }

        return ans;
    }
}
