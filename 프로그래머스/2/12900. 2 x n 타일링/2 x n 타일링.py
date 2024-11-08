def solution(n):
    answer = 0
    a = 1
    b = 2
    
    for i in range(3, n + 1):
        answer = (a + b) % 1000000007
        a = b
        b = answer
        
    return answer