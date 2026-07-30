//tc = O(n) //sc = O(n)

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i< asteroids.length; i++){
            int curr = asteroids[i];
            boolean alive = true;

            while(!stack.isEmpty() && curr < 0 && stack.peek() > 0){
                if(stack.peek() < Math.abs(curr)){
                    stack.pop();
                }else if (stack.peek() == Math.abs(curr)){
                    stack.pop();
                    alive = false;
                    break;
                }else{
                    alive = false;
                    break;
                }
            }
            if(alive){
                stack.push(curr);
            }
        }
        int [] ans = new int [stack.size()];
        for(int i=ans.length-1; i>=0; i--){
            ans[i] = stack.pop();
        }
        return ans;
    }
}