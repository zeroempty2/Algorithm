def solution(want, number, discount):
    answer = 0
    for i in range(len(discount) - 9):
        j = 0
        while j < len(want):
            check = 0
            for k in range(i, i + 10):
                if discount[k] == want[j]:
                    check += 1
            if check < number[j]:
                break
            j += 1
        if j == len(want):
            answer += 1
    return answer