//tc = O(n)  //sc = O(min(n,k))

import java.util.*;

class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {

        HashMap<Integer,Integer> map = new HashMap<>();
        int prefixSum = 0;
        map.put(0,-1);

        for(int i=0; i<nums.length; i++){
            prefixSum += nums[i];
            int rem = ((prefixSum % k)+ k) % k;
            if(map.containsKey(rem)){
                int length = i-map.get(rem);

                if(length >= 2){
                    return true;
                }
                }else{
                    map.put(rem , i);
                }
            }
            return false;
        }
    }
