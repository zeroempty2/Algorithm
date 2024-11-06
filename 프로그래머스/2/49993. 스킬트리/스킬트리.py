def solution(skill, skill_trees):
    answer = 0
    count = 1
    skill_dict = {}  
    
    #skill 순서를 딕셔너리에 저장
    for i in skill:
        skill_dict[i] = count
        count += 1
    
    for j in skill_trees:
    # 스킬의 순서를 체크하는 count와 불가능한 스킬을 체크하는 wrong
        count = 1
        wrong = False 
        
        for k in j:
            if k in skill_dict:
                if count == len(skill): break
                #딕셔너리에 skill_trees의 요소가 있다면 몇번째 스킬인지 검사
                if skill_dict[k] != count:
                    #순서가 일치하지 않는다면 wrong True
                    wrong = True  
                    break
                else:
                    count += 1
                    
        if wrong == False: 
            #스킬 순서가 일치해 Wrong이 True가 되지 않았다면 answer++
            answer += 1
        
    return answer