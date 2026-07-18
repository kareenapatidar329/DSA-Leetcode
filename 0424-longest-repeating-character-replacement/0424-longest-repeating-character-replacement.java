//tc = O(n) //sc O(1)

class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0;
        int maxLength = 0;
        int maxfreq = 0;
        int [] freq = new int [26];

        for(int right = 0; right < s.length(); right++){
            char ch = s.charAt(right);
            freq [ch - 'A']  ++;
            maxfreq = Math.max(maxfreq, freq [ch-'A']);
            while((right -left + 1) - maxfreq > k){
                char leftChar = s.charAt(left);
                freq[leftChar - 'A']--;
                left ++;
            }
            int currentLength = right - left + 1;
            maxLength = Math.max(maxLength , currentLength);
        }
        return maxLength;
    }
}