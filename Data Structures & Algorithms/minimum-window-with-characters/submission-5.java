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

        int end  = ls;
        for(int i = ls-1; i >=0; i--){
            if(hs.containsKey(s.charAt(i))){
                end  = i+1;
                break;
            }
        }

        int right = 0; 
        int left = 0;
        String ans;
        if(compare(s, true)){
            ans = new String(s);
        }else{
            return "";
        }
        
        
        while(right <= ls && left < ls){
            
            //if compare -> left to right sliding window
            // new shortest -> left = starting of sub
            //increase right

            String sub1 = s.substring(left, right);
            // System.out.println(left+" "+right+" out sub1: "+sub1);
            if(compare(sub1, true)){
                int temp = left;
                // System.out.println(temp+" "+right+" sub1: "+sub1);
                if(sub1.length() <= ans.length()){
                    ans = new String(sub1); 
                }
                while(temp <= right){
                    String sub2 = s.substring(temp, right);
                    if(compare(sub2, true) && (sub2.length() <= ans.length())){
                        left  = temp;
                        ans  = new String(sub2);
                    }
                    temp++;
                }
            }
            right++;



            /* increase right 
            // substring (left, right)
            //compare substring with t
            //once right reaches last increase left
            // substring (left, right)
            // compare substring with t */
            /*if(right != end){
                String sub = s.substring(left, right);
                System.out.println(sub);
                if(compare(sub, false) && sub.length() < ans.length()){
                    
                    ans = new String(sub);
                }
                right++;
            }else{
                String sub = s.substring(left, right);
                System.out.println(sub);
                if(compare(sub, false) && sub.length() < ans.length()){
                    ans = new String(sub);
                }
                left++;
            } */
        }

        return ans;
    }

    private boolean compare(String str, boolean initial){
        HashMap<Character, Integer> temp = new HashMap<>(hs);

        for(int i = 0; i< str.length(); i++){
            char c = str.charAt(i);
            if(temp.containsKey(c)){
                temp.put(c, temp.get(c) - 1);
            }
        }

        for(int val: temp.values()){
            if(initial){
                if(val > 0){
                    return false;
                }
            }else{
                if(val != 0){
                    return false;
                }
            }
        }

        return true;
    }
}
