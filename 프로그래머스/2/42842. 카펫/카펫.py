def solution(brown, yellow):
    answer = []
    size = brown + yellow
    for i in range(3, size):
        if size % i == 0:
            div = size // i
            if ((i - 2) * (div - 2)) == yellow:
                answer.append(div)
                answer.append(i)
                break
    return answer