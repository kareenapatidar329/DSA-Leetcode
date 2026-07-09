//tc = O(n)  //sc = O(n)

import java.util.*;
class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[]words = s.split(" ");
        if(words.length != pattern.length()){
            return false;
        }
        HashMap<Character, String> map1 = new HashMap<>();
        HashMap<String,Character> map2 = new HashMap<>();
        for(int i=0; i<pattern.length(); i++){
            char ch = pattern.charAt(i);
            String word = words[i];
            if(map1.containsKey(ch)){
                if(!map1.get(ch).equals(word)){  //ch me jo words hai dono k stored and curr vo equal nhi h
                    return false;
                }
            }
            if(map2.containsKey(word)){
                if(map2.get(word)!=ch){   //words me jo ch h like dog - a and dog - b so dono k ch not equals
                    return false;
                }
            }
            map1.put(ch,word);
            map2.put(word,ch);
        }
        return true;
    }
}