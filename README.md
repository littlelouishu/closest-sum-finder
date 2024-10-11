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

---------

Understanding how the dynamic programming (DP) table is filled can be explained with a simple example. Suppose we have a target value target = 5, and we have a list of item values [2, 3, 4]. We want to determine if we can find a combination of these items that sums up to the target value 5.

(理解动态规划表的填充过程可以通过一个简单的例子直观说明。假设我们有一个目标值 target = 5，并且我们有一组项目的值 [2, 3, 4]，我们想知道是否可以通过这些项目的某些组合，使得它们的和等于目标值 5。)

### 1. Initializing the DP Table

We use a two-dimensional boolean array dp[i][j], where i represents the index of items considered, and j represents possible target sums. dp[i][j] is true if it's possible to achieve sum j using the first i items. Initially, we know that for j = 0, the sum can always be 0 by selecting no items, so we set all dp[i][0] to true.

(我们使用一个二维布尔数组 dp[i][j]，其中 i 表示考虑到第 i 个项目时，j 表示可能的目标和。dp[i][j] 为 true 表示通过前 i 个项目能否组成和为 j。首先，我们知道当 j=0 时，无论我们选择哪些项目，空集的和始终为 0，因此我们将所有 dp[i][0] 初始化为 true。)

```
Initial DP table:
i\j   0   1   2   3   4   5
-----------------------------
0   | T   F   F   F   F   F
1   | T   F   F   F   F   F
2   | T   F   F   F   F   F
3   | T   F   F   F   F   F
```
The 0th row indicates that with no items, we can only achieve a sum of 0, so dp[0][0] is true, and the rest are false.
Starting from the 1st row, we consider adding more items and gradually update the table.

(第 0 行表示不考虑任何项目，只能组成和为 0，其他的和都不能组成，因此除了 dp[0][0] 为 true 之外，其他都是 false。
从第 1 行开始，我们考虑加入更多的项目来逐渐更新表格。)

### 2. Filling the DP Table

We gradually consider each item:

Considering the 1st item (value = 2)
The value of dp[1][j] depends on dp[0][j] and whether we can include the current item 2 to form the sum. For example:
If we don't choose item 2, then dp[1][j] = dp[0][j].
If we do choose item 2, we check if we can form the sum j - 2 using the first 0 items (dp[0][j-2]).
So, the updated DP table looks like this:

(我们逐步考虑每一个项目：
考虑第 1 个项目（值为 2）
dp[1][j] 的计算依赖于 dp[0][j] 和是否可以通过加上当前项目 2 来组成新的和。例如：
如果不选择项目 2，则 dp[1][j] = dp[0][j]。
如果选择项目 2，则我们需要检查 dp[0][j-2] 是否为 true，即是否可以通过前 0 个项目组成和为 j-2。
因此更新后的 dp 表如下：)

```
i\j   0   1   2   3   4   5
-----------------------------
0   | T   F   F   F   F   F
1   | T   F   T   F   F   F  <-- 2 can form a sum of 2
2   | T   F   F   F   F   F
3   | T   F   F   F   F   F
```

Considering the 2nd item (value = 3)
Similarly, we update the second row by considering the inclusion of item 3:

dp[2][j] can be determined by dp[1][j] (not choosing the current item) or checking dp[1][j-3] (choosing item 3).
The updated DP table now looks like:

(考虑第 2 个项目（值为 3）
类似地，我们填充第二行，考虑加入项目 3：

dp[2][j] 可以由 dp[1][j] 决定（即不选择当前项目），或者检查 dp[1][j-3]（选择当前项目 3）。
更新后的 dp 表如下：)

```
i\j   0   1   2   3   4   5
-----------------------------
0   | T   F   F   F   F   F
1   | T   F   T   F   F   F
2   | T   F   T   T   F   T  <-- 3 can form sums of 3 and 5
3   | T   F   F   F   F   F
```

Now, we can see that using the 1st and 2nd items, we can form a sum of 5.

Considering the 3rd item (value = 4)
We continue updating the table, considering item 4:

dp[3][j] depends on dp[2][j] (not choosing the current item) or checking dp[2][j-4].

The final DP table is:

(现在可以看到，通过第 1 个和第 2 个项目，已经可以组成和为 5。

考虑第 3 个项目（值为 4）
我们继续更新表格，考虑项目 4：

dp[3][j] 可以由 dp[2][j] 决定（不选择当前项目），或者检查 dp[2][j-4]。
更新后的 dp 表如下：)

```
i\j   0   1   2   3   4   5
-----------------------------
0   | T   F   F   F   F   F
1   | T   F   T   F   F   F
2   | T   F   T   T   F   T
3   | T   F   T   T   T   T  <-- 4 can form a sum of 4 but no longer updates sum 5
```

Finally, by looking at the table, we see that dp[3][5] is true, which means we can find a combination (2 + 3 = 5) that forms the target sum of 5.

(最终通过这个表格我们可以看到，dp[3][5] 是 true，说明通过项目 [2, 3, 4] 可以找到一个组合（即 2 + 3 = 5）来使得和为 5。)

### 3. Summary

This process fills the DP table recursively by considering each item and whether it can contribute to the target sum j. In the end, the value of dp[n][target] tells us if we can find a combination of items that sums to the target.

(这个过程通过递推的方式逐步填充 dp 表，考虑每个项目时，看它是否能够组成目标和 j。最终在表格的最后一行判断 dp[n][target] 是否为 true 来决定能否找到和为目标的组合。)

For our use case find the combination to the closest sum, we still use dp[i][j] to indicate whether a sum of j can be achieved through some combination of the first i numbers. However, since we don't need to exactly match the target value, as we traverse through all possible sums, we need to search for the closest sum. Finally, we will backtrack from dp[n][target], looking for the closest achievable sum.

(对于此处的用例我们是寻找最近接目标值和的组合，我们仍然使用dp[i][j]表示是否可以通过前i个数字的某种组合达到一个和为j的值。但是，由于我们不需要精确匹配目标值，我们在遍历所有可能的和时，需要寻找最接近的和。最终我们会从dp[n][target]往回查找，直到找到一个可以被实现的最接近的和。)

---------
