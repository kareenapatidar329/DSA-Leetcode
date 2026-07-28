//tc= O(n)  //sc = O(n)

class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;

        for(int i=0; i<heights.length; i++){
            while(!stack.isEmpty() && heights[i] < heights[stack.peek()]){
                int poppedIndex = stack.pop();
                int h = heights[poppedIndex];
                int right = i;
                int left;
                if(stack.isEmpty()){
                    left = -1;
                }else{
                    left = stack.peek();
                }
                int width = right - left -1;
                int area = h * width;
                maxArea = Math.max(maxArea,area);
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            int poppedIndex = stack.pop();
            int h = heights[poppedIndex];
            int right = heights.length;
            int left;
            if(stack.isEmpty()){
                left = -1;
            }else{
                left = stack.peek();
            }
            int width = right - left -1;
            int area = h *width;
            maxArea = Math.max(maxArea,area);
        }
        return maxArea;
    }
}