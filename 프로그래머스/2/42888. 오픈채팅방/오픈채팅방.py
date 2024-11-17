def solution(record):
    map = {}
    answer = []
    
    for i in record:
        parts = i.split()
        if len(parts) > 2:
            map[parts[1]] = parts[2]
       
    for j in record:
        parts = j.split()
        nickname = map.get(parts[1])
        if parts[0] == "Enter":
            answer.append(nickname+"님이 들어왔습니다.")
        elif parts[0] == "Leave":
            answer.append(nickname+"님이 나갔습니다.")
    
    return answer