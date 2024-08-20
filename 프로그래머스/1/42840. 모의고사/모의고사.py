def solution(answers):
    a = [1, 2, 3, 4, 5]
    b = [2, 1, 2, 3, 2, 4, 2, 5]
    c = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5]
    
    score = [0, 0, 0]
    
    for i in range(len(answers)):
        if answers[i] == a[i % len(a)]:
            score[0] += 1
        if answers[i] == b[i % len(b)]:
            score[1] += 1
        if answers[i] == c[i % len(c)]:
            score[2] += 1
    
    max_score = max(score)
    
    result = []
    
    for j in range(len(score)):
        if score[j] == max_score:
            result.append(j + 1)
            
    return result