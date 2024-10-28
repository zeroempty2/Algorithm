def solution(s):
    count = 0
    replace = 0
    
    while s != "1" :
        before = len(s)
        s = s.replace("0", "")
        after = len(s)
        
        replace += before - after
        s = bin(after)[2:]
        count += 1
        
    return [count,replace]