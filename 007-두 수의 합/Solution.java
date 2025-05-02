class Solution {
    public int[] twoSum(int[] nums, int target) {

        var res = new HashMap<Integer, Integer>();

        for(int i=0; i<nums.length; i++){
            var value = res.get(target - nums[i]);
            if(value != null) return new int[]{i, value};
            else res.put(nums[i], i);
        }
        return null;
    }
}