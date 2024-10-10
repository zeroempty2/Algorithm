def solution(ingredient):
    burger = [1, 2, 3, 1]  
    answer = 0  
    i = 0  

    while i <= len(ingredient) - 4:  
        if ingredient[i:i+4] == burger:
            del ingredient[i:i+4]
            answer += 1 
            i = max(i - 2, 0) 
        else:
            i += 1 

    return answer