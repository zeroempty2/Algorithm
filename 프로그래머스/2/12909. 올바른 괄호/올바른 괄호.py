def solution(s):
    arr = list(s)
    stack = []
    
    for i in range(len(arr)):
        if len(stack) != 0:
            if arr[i] == ')' and stack[-1] == '(':
                stack.pop()
            else:
                stack.append(arr[i])
        else:
            stack.append(arr[i])
    
    return len(stack) == 0