//time complexity O(n)  //sc O(1)
import java.util.*;
class Solution {
    public String minWindow(String s, String t) {
        if(s.length() < t.length()){
            return "";
        }
         int needFreq [] = new int [128];
         int windowFreq [] = new int [128];

         //t ke char ki frequency store kro
        for(int i=0; i<t.length(); i++){
            needFreq[t.charAt(i)]++;
        }
        int left = 0;
        int count = 0;
        int minLength = Integer.MAX_VALUE;
        int start =0;

        for(int right = 0; right<s.length(); right++){
            char rightChar = s.charAt(right);
            //add right in window
            windowFreq[rightChar]++;
            if(needFreq[rightChar] > 0 && windowFreq [rightChar] <= needFreq[rightChar]){
                count++;
            }
            while(count == t.length()){
                int currLength = right - left +1;
                if(currLength < minLength){
                    minLength = currLength;
                    start = left;
                }
                char leftChar = s.charAt(left);

                if(needFreq[leftChar] > 0 && windowFreq[leftChar] <= needFreq[leftChar]){
                    count --;
                }
                windowFreq[leftChar]--;
                left++;
            }

        }
        if(minLength == Integer.MAX_VALUE){
            return "";
        }
        return s.substring(start, start + minLength);
    }
}