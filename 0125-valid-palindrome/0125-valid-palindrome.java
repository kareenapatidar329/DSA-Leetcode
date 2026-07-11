//tc = O(n)  /sc = O(1)

class Solution {
    public boolean isPalindrome(String s) {
       int left = 0;
       int right = s.length()-1;
       while(left<right){
        char leftChar = Character.toLowerCase(s.charAt(left));
        char rightChar = Character.toLowerCase(s.charAt(right));
        if(!Character.isLetterOrDigit(leftChar)){
            left++;
        }else if(!Character.isLetterOrDigit(rightChar)){
            right--;
        }else if(leftChar != rightChar){
            return false;
        }
        else{
            left++;
            right--;
        }

       }
       return true;
    }
}