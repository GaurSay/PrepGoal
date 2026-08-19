package Arrays;

public class MaxProductSubArray {

    public static void main(String[] args) {

    }
    public int maxProduct(int[] nums) {

        int maxEnding = nums[0];
        int minEnding = nums[0];
        int ans = nums[0];

        for (int i = 1; i < nums.length; i++) {

            int x = nums[i];

            int tempMax = Math.max(x,
                    Math.max(maxEnding * x, minEnding * x));

            int tempMin = Math.min(x,
                    Math.min(maxEnding * x, minEnding * x));

            maxEnding = tempMax;
            minEnding = tempMin;

            ans = Math.max(ans, maxEnding);
        }

        return ans;
    }
}
