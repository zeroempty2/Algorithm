def solution(storey):
    answer = 0
    while storey > 0:
        unit = storey % 10  # 현재 자릿수
        higher_unit = (storey // 10) % 10  # 그 위의 자릿수 (10의 자리)

        # 자릿수가 0이면 그 자릿수는 건너뛰기
        if unit == 0:
            storey //= 10
            continue
        
        # 자릿수가 5 이상이고, 더 높은 자릿수가 있다면 한 자리를 올려주는 것이 유리
        if unit > 5:
            # 10에서 unit을 빼면 최소 돌 개수
            answer += (10 - unit)
            # 올라가야 할 만큼 storey 증가
            storey += (10 - unit)
        elif unit == 5 and higher_unit >= 5:
            # 자릿수가 5인데 그 위 자릿수가 5 이상이면 한 자리를 올려주는 것이 유리
            answer += (10 - unit)
            storey += (10 - unit)
        else:
            answer += unit  # unit 만큼 마법의 돌 사용
            storey -= unit  # 나머지 층을 빼서 처리

        # 한 자릿수씩 내려감
        storey //= 10

    return answer
