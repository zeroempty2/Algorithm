import itertools

def solution(babbling):
    babb = ["aya", "ye", "woo", "ma"]
    possible_babbles = set(babb)

    for i in range(2, 5): 
        for combination in itertools.product(babb, repeat=i):
            possible_babbles.add(''.join(combination))
    
    answer = 0
    for word in babbling:
        if word in possible_babbles:
            answer += 1

    return answer