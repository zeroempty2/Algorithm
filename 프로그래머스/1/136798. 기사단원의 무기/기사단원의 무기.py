def solution(number, limit, power):
    answer = 0
    for i in range(1, number + 1):
        a = count(i)
        if a > limit:
            answer += power
        else:
            answer += a
    
    return answer

def count(N):
    count = 0
    i = 1
    while i * i <= N:
        if i * i == N:
            count += 1
        elif N % i == 0:
            count += 2
        i += 1
    return count
