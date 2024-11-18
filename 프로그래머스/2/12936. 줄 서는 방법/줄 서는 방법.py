def solution(n, k):
    answer = [0] * n
    n_list = []
    num = k - 1

    for i in range(1,n + 1):
        n_list.append(i)
        
    for j in range(0,n):
        if num == 0:
            answer[j] = n_list.pop(0)
            continue
        factor = factorial(n - j - 1)
        list_index = num // factor
        answer[j] = n_list.pop(list_index)
        num %= factor
        
    return answer

def factorial(k):
    factor = 1
    
    for i in range(1,k+1):
        factor *= i
        
    return factor