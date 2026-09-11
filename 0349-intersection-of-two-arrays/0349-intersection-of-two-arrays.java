//tc = O(m+n) //sc = O(m+n)

import java.util.*;

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();

        for(int i=0; i<nums1.length; i++){
            set1.add(nums1[i]);
        }
        for(int j=0; j<nums2.length; j++){
            if(set1.contains(nums2[j])){
            set2.add(nums2[j]);
            }
        
    }
    int[]ans = new int[set2.size()];
    int k = 0;

    for( int num : set2){
        ans[k] = num;
        k++;
    }
    
    return ans;
    }
}