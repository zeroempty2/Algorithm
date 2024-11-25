def solution(n, computers):
    answer = 0
    check = [False] * n
    for i in range(0,n):
        if not check[i]:
            dfs(check, computers, i)
            answer += 1
        
    return answer

def dfs(check, computers, start):
    check[start] = True
    for i in range(0,len(computers)):
        if computers[start][i] == 1 and not check[i]:
            dfs(check, computers, i)
    