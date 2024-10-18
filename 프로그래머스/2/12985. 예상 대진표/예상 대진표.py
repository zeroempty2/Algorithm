def solution(n,a,b):
    return matching(a,b,1)

def matching(a,b,count):
    if abs(a - b) == 1 and min(a, b) % 2 == 1:
        return count
    a = (a + 1) // 2
    b = (b + 1) // 2
    count += 1
    return matching(a,b,count)