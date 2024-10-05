package com.closetsumfinder;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

/**
 * This algorithm is based on the principle of dynamic programming, specifically the knapsack problem.<br>
 * <br>
 * The steps of the algorithm are as follows:<br>
 * <br>
 * 1.First, we create a two-dimensional boolean array dp[][], where dp[i][j] indicates whether there exists a combination of the first i
 * numbers whose sum equals j. <br>
 * <br>
 * 2.We initialize dp[][] so that all dp[i][0] are set to true when the target value j is 0. <br>
 * This is because when we don't select any numbers, the sum is 0. <br>
 * <br>
 * 3.Next, we fill in the remaining entries of the dp[][] array. For each number num, we try to include it in the combination and update
 * dp[i][j]. <br>
 * <br>
 * 4.After that, we find the combination closest to the target value. We traverse from dp[n][target] upwards and find the largest j such
 * that dp[n][j] is true. This j represents the closest sum to the target. <br>
 * <br>
 * 5.The final step is backtracking. Starting from dp[n][j], we backtrack to find the numbers in the combination. Whenever we find a number,
 * we subtract it from the target sum and continue searching backwards. <br>
 * <br>
 * Through this approach, the algorithm finds a combination of numbers whose sum is closest to the target value. <br>
 * 
 * @author Haku Ko
 * 
 */
public class ClosestSumFinder {
    @Builder
    @Getter
    @AllArgsConstructor
    public static class Item {
        String identifier;

        BigDecimal value;
    }

    // Method to find a combination of numbers from a list that sums up to the closest value to a specific target
    public static List<Item> findClosestSum(List<Item> itemList, BigDecimal target) {
        List<Item> arr = new ArrayList<>(itemList);
        int n = arr.size();
        boolean[][] dp = new boolean[n + 1][target.intValue() + 1];
        List<Item> closestCombination = new ArrayList<>();

        // Initialize the dynamic programming table
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        // Fill the dynamic programming table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= target.intValue(); j++) {
                if (j >= arr.get(i - 1).getValue().intValue()) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arr.get(i - 1).getValue().intValue()];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        // Find the closest sum
        int closestSum = 0;
        for (int j = target.intValue(); j >= 0; j--) {
            if (dp[n][j]) {
                closestSum = j;
                break;
            }
        }

        // Backtrack to find the combination of numbers
        int remaining = closestSum;
        for (int i = n; i > 0 && remaining > 0; i--) {
            if (dp[i - 1][remaining]) {
            } else {
                closestCombination.add(arr.get(i - 1));
                remaining -= arr.get(i - 1).getValue().intValue();
            }
        }

        // Retrieve the corresponding names from the list and remove used entries
        List<Item> result = new ArrayList<>();
        for (Item item : closestCombination) {
            for (Iterator<Item> iterator = itemList.iterator(); iterator.hasNext();) {
                Item entry = iterator.next();
                if (entry.getIdentifier().equals(item.getIdentifier())) {
                    result.add(entry);
                    iterator.remove();
                    break;
                }
            }
        }

        return result;
    }
}
