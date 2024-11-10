from functools import cmp_to_key

def solution(numbers):
    num  = list(map(str, numbers)) 
    num = sorted(num, key = cmp_to_key(compare))
    if num[0] == "0" : return "0"
    answer = ''.join(num)
    return answer

def compare(x, y):
    if x + y > y + x:
        return -1
    elif x + y < y + x:
        return 1
    else:
        return 0