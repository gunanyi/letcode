package leetcode.tech.hash;

import java.util.HashMap;

/**
 * @description: leetcode 1.两数之和
 * @author: wpwangwp
 * @create: 2021/7/8 23:33
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        // 1.定义一个hashtable来快速查找
        // key为 nums[i] value 为i
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.get(target - nums[i]) != null) {
                result[0] = i;
                result[1] = map.get(target - nums[i]);
                break;
            } else {
                map.put(nums[i], i);
            }
        }
        return result;
    }
}
