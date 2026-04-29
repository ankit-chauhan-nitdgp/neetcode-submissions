class Solution {
    public boolean isAnagram(String s, String t) {

        if(s.length() != t.length()){
            return false;
        }
        HashMap<Character, Integer> hm = new HashMap<>();

        for(int i = 0; i< s.length(); i++){
            hm.put(s.charAt(i), hm.getOrDefault(s.charAt(i), 0)+1);
        }

        for(int i = 0; i< t.length(); i++){
            hm.put(t.charAt(i), hm.getOrDefault(t.charAt(i), 0)-1);
        }

        for(Integer value: hm.values()){
            if(value != 0){
                return false;
            }
        }

        return true;
    }
}
