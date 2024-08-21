def solution(babbling):
    babb = ["aya", "ye", "woo", "ma"]
    answer = 0
    
    for word in babbling:
        for able in babb:
            if able * 2 in word:
                break
            word = word.replace(able, " ")
        
        if word.strip() == "":
            answer += 1
    
    return answer