import sys

def round_up(num):
    return int(num) + 1 if num - int(num) >= 0.5 else int(num)

n = int(sys.stdin.readline().rstrip())

if n == 0:
    print(0)
else:
    arr = [int(sys.stdin.readline().rstrip()) for _ in range(n)]
    
    arr.sort()
    border = round_up(n * 0.15)
    
    filtered_arr = arr[border:n-border]
    avg = sum(filtered_arr) / len(filtered_arr)
    
    print(round_up(avg))
