package prep2024.leetCode75.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KidsWithGreatestNumberOfCandies {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        // will try to find the max of int array
        // then will try to see if ith candidate given extra candies will give result
        // which is max or more
        // then change it to true in boolean array
        // if not keep the same

        int max = Arrays.stream(candies).max().orElse(0);
        List<Boolean> result = new ArrayList<>();
        for (int i = 0; i < candies.length; i++) {
            if (candies[i] + extraCandies >= max) {
                // max = candies[i]+extraCandies;
                result.add(true);
            } else {
                result.add(false);
            }
        }
        return result;
    }
    
    public static void main(String[] args) {
        KidsWithGreatestNumberOfCandies solution = new KidsWithGreatestNumberOfCandies();
        int[] candies = {2, 3, 5, 1, 3};
        int extraCandies = 3;
        List<Boolean> result = solution.kidsWithCandies(candies, extraCandies);
        System.out.println(result); // Expected output: [true, true, true, false, true]
    }

}
