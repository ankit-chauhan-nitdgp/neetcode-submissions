class Solution {
    HashMap<Character, Integer> hs = new HashMap<>();
    public String minWindow(String s, String t) {
        
        int ls = s.length();
        int lt = t.length();

        if(ls<lt){
            return "";
        }

        for(int i = 0; i< lt; i++){
            hs.put(t.charAt(i), hs.getOrDefault(t.charAt(i), 0)+1);
        }

        int right = 0; 
        int left = 0;
        String ans;
        if(compare(s)){
            ans = new String(s);
        }else{
            return "";
        }
        
        
        while(right <= ls && left < ls){
            
            //if compare -> left to right sliding window
            // new shortest -> left = starting of sub
            //increase right

            String sub1 = s.substring(left, right);
            if(compare(sub1)){
                int temp = left;
                if(sub1.length() <= ans.length()){
                    ans = new String(sub1); 
                }
                while(temp <= right){
                    String sub2 = s.substring(temp, right);
                    if(compare(sub2) && (sub2.length() <= ans.length())){
                        left  = temp;
                        ans  = new String(sub2);
                    }
                    temp++;
                }
            }
            right++;
        }

        return ans;
    }

    private boolean compare(String str){
        HashMap<Character, Integer> temp = new HashMap<>(hs);

        for(int i = 0; i< str.length(); i++){
            char c = str.charAt(i);
            if(temp.containsKey(c)){
                temp.put(c, temp.get(c) - 1);
            }
        }

        for(int val: temp.values()){
            if(val > 0){
                return false;
            }
        }

        return true;
    }
}
