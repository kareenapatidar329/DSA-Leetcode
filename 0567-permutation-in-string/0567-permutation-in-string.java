//tc = O(n) //sc=O(1)

import java.util.*;
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()){
            return false;
        }
        int [] s1freq = new int[26];
        int [] windowfreq = new int [26];
        
        //first window frequency
        for(int i=0; i<s1.length(); i++){
            s1freq[s1.charAt(i)-'a']++;
            windowfreq[s2.charAt(i)-'a']++;

        }
        if(Arrays.equals(s1freq,windowfreq)){
            return true;
        }

        //slide window
        for(int i=s1.length(); i<s2.length(); i++){
            char removeChar= s2.charAt(i-s1.length());
            char addChar = s2.charAt(i);

            windowfreq[removeChar - 'a']--;
            windowfreq[addChar - 'a']++;

            if(Arrays.equals(s1freq,windowfreq)){
                return true;
            }

        }
        return false;
    }
}