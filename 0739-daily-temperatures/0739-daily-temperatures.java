//tc= O(n)  //sc= O(n)

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int ans [] = new int [temperatures.length];

        for(int i=0; i<temperatures.length; i++){
            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]){
                int poppedIndex = stack.pop();
                ans[poppedIndex] = i-poppedIndex;
            }
            stack.push(i);
        }
        return ans;
    }
}