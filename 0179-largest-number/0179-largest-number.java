//tc = O(n log n * k)  //sc = O(n)

class Solution {
    public String largestNumber(int[] nums) {
        String[] arr = new String[nums.length];
        for(int i=0; i<nums.length; i++){
            arr[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(arr,(a,b) -> {
            String ab = a + b;
            String ba = b + a;

            return ba.compareTo(ab);
        });
        if(arr[0].equals("0")){
            return "0";
        }
        StringBuilder ans = new StringBuilder();
        for(String s : arr){
            ans.append(s);
        }
        return ans.toString();
    }
}