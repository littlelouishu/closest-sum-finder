# ClosestSumFinder

This algorithm is based on the principle of dynamic programming, specifically the knapsack problem.<br>
<br>
The steps of the algorithm are as follows:<br>
<br>
1.First, we create a two-dimensional boolean array dp[][], where dp[i][j] indicates whether there exists a combination of the first i
numbers whose sum equals j. <br>
<br>
2.We initialize dp[][] so that all dp[i][0] are set to true when the target value j is 0. <br>
This is because when we don't select any numbers, the sum is 0. <br>
  <br>
3.Next, we fill in the remaining entries of the dp[][] array. For each number num, we try to include it in the combination and update
dp[i][j]. <br>
<br>
4.After that, we find the combination closest to the target value. We traverse from dp[n][target] upwards and find the largest j such
that dp[n][j] is true. This j represents the closest sum to the target. <br>
<br>
5.The final step is backtracking. Starting from dp[n][j], we backtrack to find the numbers in the combination. Whenever we find a number,
  we subtract it from the target sum and continue searching backwards. <br>
<br>
Through this approach, the algorithm finds a combination of numbers whose sum is closest to the target value. <br>
