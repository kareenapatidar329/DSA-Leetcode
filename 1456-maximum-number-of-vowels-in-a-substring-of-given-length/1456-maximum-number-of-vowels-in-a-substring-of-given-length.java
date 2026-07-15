//tc = O(n) //sc = O(1)

class Solution {
    public int maxVowels(String s, int k) {
        int count = 0;
        for(int i=0; i<k; i++){
            if(isVowel(s.charAt(i))){
                count++;
            }
        }
            int maxCount = count;

            for(int i=k; i<s.length(); i++){
                char removeChar = s.charAt(i-k);
                char addChar = s.charAt(i);

                if(isVowel(removeChar)){
                    count --;
                }
                if(isVowel(addChar)){
                    count++;
                }
                maxCount = Math.max(maxCount,count);
            }
            return maxCount;
        }
        private boolean isVowel(char ch){
            return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
        
    }
}