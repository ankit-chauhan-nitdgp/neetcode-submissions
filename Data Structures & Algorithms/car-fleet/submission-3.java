class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        double[][] time = new double[n][2];

        for(int i = 0; i<n; i++){
            time[i][0] = position[i];
            time[i][1] = (double) (target-position[i])/speed[i];
        }

        Arrays.sort(time, (a,b) -> Double.compare(b[0],a[0]));

        int count  = 0;
        double prevTime = 0;
        for(int i = 0; i<n;i++){
            if(time[i][1] > prevTime){
                prevTime = time[i][1];
                count++;
            }
        }

        return count;
    }
}
