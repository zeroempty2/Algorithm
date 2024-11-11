def solution(land):
    for i in range(1, len(land)):
        land[i][0] += math_max(land[i-1][1], land[i-1][2], land[i-1][3])
        land[i][1] += math_max(land[i-1][0], land[i-1][2], land[i-1][3])
        land[i][2] += math_max(land[i-1][0], land[i-1][1], land[i-1][3])
        land[i][3] += math_max(land[i-1][0], land[i-1][1], land[i-1][2])

    return max(land[-1])

def math_max(a,b,c):
    max_value = max(max(a,b),c)
    return max_value