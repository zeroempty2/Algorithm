def solution(k, tangerine):
    answer = 0
    dict = {}
    for i in range(len(tangerine)):
        dict[tangerine[i]] = dict.get(tangerine[i], 0) + 1
        
    sort = sorted(dict.values(), reverse=True)
    
    for j in range(len(sort)):
        answer += 1
        k -= sort[j]
        if k <= 0:
            break
    
    return answer