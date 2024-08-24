def solution(s, skip, index):
    skip_set = set(ord(char) for char in skip)
    answer = ''

    for char in s:
        count = 0
        code = ord(char)
        
        while count < index:
            code += 1
            if code > ord('z'):
                code = ord('a')
            
            if code not in skip_set:
                count += 1

        answer += chr(code)
            
    return answer