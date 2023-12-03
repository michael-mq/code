# https://www.programmercarl.com/背包理论基础01背包-1.html#其他语言版本
def test_2_wei_bag_problem1():
    weight = [1, 3, 4]
    value = [15, 20, 30]
    bagweight = 4

    m = len(weight)

    dp = [[0] * (bagweight + 1) for _ in range(m)]

    for j in range(weight[0], bagweight + 1):
        dp[0][j] = value[0]

    for i in range(1, m):
        for j in range(bagweight + 1):
            if weight[i] > j:
                dp[i][j] = dp[i - 1][j]
            else:
                dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i])

    print(dp)


test_2_wei_bag_problem1()
