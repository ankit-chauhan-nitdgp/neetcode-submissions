class Solution {
    public double myPow(double x, int n) {
       if(x == 0 && n > 0){
         return 0;
       }

       if(n < 0){
         return 1/helper(x,-1*n);
       }

       return helper(x,n);
    }

    public double helper(double x, int n) {
        if(n == 0){
            return 1;
        }
        if(n == 1){
            return x;
        }

        double res = helper(x, n-1);
        return res*x;
    }
}
