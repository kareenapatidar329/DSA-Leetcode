//tc O(n log maxPile)  //sc(1)

class Solution {

    public int minEatingSpeed(int[] piles, int h) {

        int maxPile = 0;
        for(int pile : piles){
            maxPile = Math.max(maxPile,pile);
        }

        int low = 1;
        int high = maxPile;
        int ans = maxPile;

        while(low <= high){
            int mid = low + (high - low)/2;

            if(canEat( piles, h , mid)){
               ans = mid;
               high = mid -1;
            }
            else{
                low = mid +1;
            }
        }
        return ans;

    }
    private boolean canEat(int[] piles, int h , int k){
        long totalHour = 0;

        for(int pile:piles){
            totalHour += (pile + k -1) / k;

        }
        return totalHour <= h;
    }
}