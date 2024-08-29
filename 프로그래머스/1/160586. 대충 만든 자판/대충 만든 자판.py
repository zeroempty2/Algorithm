def solution(keymap, targets):
    answer = []
    hash_map = {}
    
    for key in keymap:
        for i in range(len(key)):
            if key[i] in hash_map:
                if hash_map[key[i]] > i + 1:
                    hash_map[key[i]] = i + 1
            else:
                hash_map[key[i]] = i + 1
    
    for target in targets:
        count = 0
        for j in range(len(target)):
            if target[j] in hash_map:
                count += hash_map[target[j]]
            else:
                count = -1
                break
                
        answer.append(count)
    
    return answer