def solution(s):
    result = ''
    capitalize_next = True 

    for char in s:
        if char == ' ':  
            result += char
            capitalize_next = True
        elif capitalize_next: 
            result += char.upper()
            capitalize_next = False
        else:
            result += char.lower()

    return result