//tc = O(n)  //sc= O(n)
class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<num.length(); i++){
            char curr = num.charAt(i);
            while(!stack.isEmpty() && k > 0 && curr < stack.peek()){
                stack.pop();
                k--;
            }
            stack.push(curr);
        }
        while(k > 0){
            stack.pop();
            k--;
        }
        StringBuilder ans = new StringBuilder();
        while(!stack.isEmpty()){
            ans.append(stack.pop());
        }
            ans.reverse();
    
        while(ans.length() > 0 && ans.charAt(0)=='0'){
            ans.deleteCharAt(0);
        }
        if(ans.length() == 0){
            return "0";
        }
        return ans.toString();

    }

}
