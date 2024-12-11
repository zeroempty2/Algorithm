def solution(m, n, puddles):
    MOD = 1000000007
    dp = [[0] * n for _ in range(m)]

    # 물 웅덩이 표시
    for puddle in puddles:
        x, y = puddle
        dp[x - 1][y - 1] = -1  # 1-based index를 0-based로 변환

    # 시작점 초기화
    dp[0][0] = 1

    # DP 계산
    for i in range(m):
        for j in range(n):
            if dp[i][j] == -1:
                dp[i][j] = 0  # 웅덩이는 경로가 없음
                continue
            if i > 0:
                dp[i][j] = (dp[i][j] + dp[i - 1][j]) % MOD  # 위쪽에서 오는 경로
            if j > 0:
                dp[i][j] = (dp[i][j] + dp[i][j - 1]) % MOD  # 왼쪽에서 오는 경로

    return dp[m - 1][n - 1]
