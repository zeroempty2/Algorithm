def solution(participant, completion):
    for a, b in zip(sorted(participant) , sorted(completion)):
        if a != b : return a
    return sorted(participant)[-1]