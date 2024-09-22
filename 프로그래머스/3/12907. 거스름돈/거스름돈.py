def solution(n, money):
    dp = [0] * (n + 1)
    dp[0] = 1
    
    for i in range(len(money)):
        for j in range(money[i], n + 1):
            dp[j] += dp[j - money[i]]
    
    answer = dp[n]
    return answer % 1000000007