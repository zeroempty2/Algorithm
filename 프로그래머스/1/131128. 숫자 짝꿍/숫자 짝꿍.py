def solution(X, Y):
    X_count = {}
    Y_count = {}
    
    for digit in X:
        if digit in X_count:
            X_count[digit] += 1
        else:
            X_count[digit] = 1
    
    for digit in Y:
        if digit in Y_count:
            Y_count[digit] += 1
        else:
            Y_count[digit] = 1
    
    common_elements = []
    
    for digit in X_count:
        if digit in Y_count:
            min_count = min(X_count[digit], Y_count[digit])
            common_elements.extend([digit] * min_count)

    common_elements.sort(reverse=True)

    if not common_elements:
        return "-1"
    

    if len(set(common_elements)) == 1 and common_elements[0] == '0':
        return "0"
    
    return ''.join(common_elements)