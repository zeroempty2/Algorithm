from collections import deque

def solution(priorities, location):
    move = deque()
    answer = 0
    for i in range(0,len(priorities)):
        new_pair = Pair(priorities[i],i)
        move.append(new_pair)

    while move:
        check = True
        pair = move[0]
        
        for j in move:
            if j.value > pair.value:
                check = False
                move.append(move.popleft())
                break
        
        if(check):
            ck_pair = move.popleft()
            answer += 1
            if location == ck_pair.location:
                break
                
        

    return answer

class Pair:
    def __init__(self, value, location):
        self.value = value
        self.location = location
        