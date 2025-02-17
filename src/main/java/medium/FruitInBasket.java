package medium;

import java.util.*;

/*
https://leetcode.com/problems/fruit-into-baskets/description/

You are visiting a farm that has a single row of fruit trees arranged from left to right. The trees are represented by an integer array fruits where fruits[i] is the type of fruit the ith tree produces.

You want to collect as much fruit as possible. However, the owner has some strict rules that you must follow:

    You only have two baskets, and each basket can only hold a single type of fruit. There is no limit on the amount of fruit each basket can hold.
    Starting from any tree of your choice, you must pick exactly one fruit from every tree (including the start tree) while moving to the right. The picked fruits must fit in one of your baskets.
    Once you reach a tree with fruit that cannot fit in your baskets, you must stop.

Given the integer array fruits, return the maximum number of fruits you can pick.



Example 1:

Input: fruits = [1,2,1]
Output: 3
Explanation: We can pick from all 3 trees.

Example 2:

Input: fruits = [0,1,2,2]
Output: 3
Explanation: We can pick from trees [1,2,2].
If we had started at the first tree, we would only pick from trees [0,1].

Example 3:

Input: fruits = [1,2,3,2,2]
Output: 4
Explanation: We can pick from trees [2,3,2,2].
If we had started at the first tree, we would only pick from trees [1,2].

 */

public class FruitInBasket {

    public int totalFruit(int[] fruits) {
        // create a hash map to count the fruits
        Map<Integer,Integer> map = new HashMap<>();
        int start = 0;
        int maxCount = 0;

        for(int end=0;end < fruits.length; end++){
            map.put(fruits[end], map.getOrDefault(fruits[end],0) + 1);

            // since we have two basket
            // we are making sure map size is less then two
            // we will shrink the map from start
            while (map.size() >2) {
                // decrementing the value
                map.put(fruits[start], map.getOrDefault(fruits[start],0) - 1);
                // if it becomes zero we remove from the map to shrink window
                if(map.get(fruits[start]) == 0){
                    map.remove(fruits[start]);
                }
                start++;
            }
            // update the maxCount as the size of window
            maxCount = Math.max(maxCount, end - start + 1 );
        }
        return maxCount;
    }
}
