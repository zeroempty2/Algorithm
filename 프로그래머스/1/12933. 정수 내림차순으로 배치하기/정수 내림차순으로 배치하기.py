def solution(n):
    s = list(str(n))
    s = sort(0, 1, s, len(s))
    answer = "".join(s)
    return int(answer)

def sort(a, b, s, length):
    if(length == 1):
        return s
    if b == length:
        a += 1
        b = 1 + a
    
    if a == length - 1:
        return s
    
    num_a = int(s[a])
    num_b = int(s[b])
    
    if num_a < num_b:
        s[a], s[b] = str(num_b), str(num_a)
    
    b += 1
    
    return sort(a, b, s, length)