def solution(book_time):
    answer = 0
    max_minute = [0] * 1440
    
    for time in book_time:
        start = change(time[0])
        end = min(1439,change(time[1]) + 10)
        
        for i in range(start,end):
            max_minute[i] += 1
            
    for j in max_minute:
        answer = max(answer,j)
    
    return answer

def change(time):
    arr = time.split(":")
    #분으로 변환해서 반환
    return int(arr[0]) * 60 + int(arr[1])
        