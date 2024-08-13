def solution(s):
    부호 = s[0]
    if 부호 == "-" :
        return -1 * int(s.split("-")[1])
    else :
        return int(s)