//tc = O(n) //sc = O(1)

class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int sum = 0;
        int count = 0;

        for(int i=0; i<k; i++){
            sum += arr[i];

        }
        if(sum >= threshold *k){
            count++;
        }
        for(int i=k; i<arr.length; i++){
            sum += arr[i] - arr[i-k];
            if(sum >= k * threshold){
                count ++;
            }
        }
         return count;
    }
}