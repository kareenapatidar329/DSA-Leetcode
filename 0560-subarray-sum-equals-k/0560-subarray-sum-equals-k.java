//tc = O(n)  //sc = O(n)

class Solution {
    public int subarraySum(int[] nums, int k) {
    
    HashMap <Integer,Integer> map = new HashMap<>();
    int count = 0;
    int prefixSum = 0;

    map.put(0,1);

    for(int num : nums){
       prefixSum += num;
       int needed = prefixSum - k;
       if(map.containsKey(needed)){
        count += map.get(needed);
       }
       map.put(prefixSum , map.getOrDefault(prefixSum,0) +1);
    }
        return count;
    }
}