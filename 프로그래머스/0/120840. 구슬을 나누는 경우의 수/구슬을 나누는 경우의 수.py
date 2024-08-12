def solution(balls, share):
    return factorial(balls) / (factorial(balls-share) * factorial(share))

def factorial(n):
    if n == 0 or n == 1: return 1
    else: return n * factorial(n - 1)