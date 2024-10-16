def solution(arr):
    answer = arr[0]
    for num in arr:
        gcd = num/cal(min(num, answer), max(num, answer))
        answer = answer * gcd 
    return answer

def cal(a, b):
    if b == 0:
        return a
    return cal(b, a % b)