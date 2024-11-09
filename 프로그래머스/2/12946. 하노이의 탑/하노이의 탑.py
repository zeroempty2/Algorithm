answer = []

def solution(n):
    global answer
    answer = [] 
    dfs(n, 1, 3, 2)
    return answer

def dfs(n, start, end, mid):
    if n == 1:
        answer.append([start, end])
        return
    dfs(n - 1, start, mid, end)
    answer.append([start, end])
    dfs(n - 1, mid, end, start)