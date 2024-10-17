def solution(n):
    arr = [0] * 2000
    
    arr[0], arr[1], arr[2] = 1, 2, 3  
    
    for j in range(3, n):  
        arr[j] = (arr[j-1] + arr[j-2]) % 1234567
    
    return arr[n-1] 