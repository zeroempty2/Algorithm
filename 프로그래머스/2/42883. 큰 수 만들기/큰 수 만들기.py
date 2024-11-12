def solution(number, k):
    stack = []  
    remove_count = k 

    for num in number:
        while stack and remove_count > 0 and stack[-1] < num:
            stack.pop()  
            remove_count -= 1  
        stack.append(num)  


    return ''.join(stack[:len(number) - k])