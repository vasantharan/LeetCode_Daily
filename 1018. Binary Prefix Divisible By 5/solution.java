class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> ans = new ArrayList();
        int temp = 0;
        for (int bit : nums) {
            temp = (temp * 2 + bit) % 5;
            ans.add(temp == 0);
        }
        return ans;
    }
}