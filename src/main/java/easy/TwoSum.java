package easy;

import java.util.HashMap;
import java.util.Map;

class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] result= new int[2];
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<nums.length;i++){
            int diff = 0;
            diff = target - nums[i];
            if(map.containsKey(diff)){
                result[0] = map.get(diff);
                result[1]= i;
            }
            else{
                map.put(nums[i],i);
            }
        }
        return result;
    }
}
class SollutionTwoSum{
    public static void main(String[] args) {
        TwoSum twoSum= new TwoSum();
        int[] result=twoSum.twoSum(new int[]{2,3,4,5,2},7);
        System.out.println("Result for two sum  - "+result[0]+":"+result[1]);
    }
}