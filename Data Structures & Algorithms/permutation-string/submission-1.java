class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int l1 = s1.length();
        int l2 = s2.length();

        if(l1>l2){
            return false;
        }
        HashMap<Character, Integer> hm = new HashMap<>();

        for(int i = 0; i<l1; i++){
            hm.put(s1.charAt(i), hm.getOrDefault(s1.charAt(i), 0)+1);
        }

        for(int i = 0; i<l1; i++){
            if(hm.containsKey(s2.charAt(i))){
                hm.put(s2.charAt(i), hm.get(s2.charAt(i))-1);
            }
        }

        boolean cond = true;
        for(int val: hm.values()){
            if(val != 0){
                cond = false;
            }
        }

        if(cond){
            return true;
        }

        for(int i = l1; i<l2; i++){
            char oldChar = s2.charAt(i-l1);
            char newChar = s2.charAt(i);
            cond = true;

            if(hm.containsKey(oldChar)){
                hm.put(oldChar, hm.get(oldChar)+1);
            }

            if(hm.containsKey(newChar)){
                hm.put(newChar, hm.get(newChar)-1);
            }


            for(int val: hm.values()){
                if(val != 0){
                    cond = false;
                }
            }

            if(cond){
                return true;
            }
        }

        return false;
    }
}
