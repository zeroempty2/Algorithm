from collections import Counter

def solution(weights):
    # 무게 빈도 계산
    weight_count = Counter(weights)
    answer = 0

    # 가능한 거리 비율
    ratios = [(2, 3), (3, 4), (2, 4), (1, 1)]

    for weight in weight_count:
        count = weight_count[weight]

        # 동일한 무게로 짝꿍 계산
        if (1, 1) in ratios:
            answer += count * (count - 1) // 2  # 조합 계산

        # 다른 거리 비율로 짝꿍 계산
        for r1, r2 in ratios:
            if r1 == r2:
                continue  # 동일한 비율은 위에서 처리됨
            
            # 다른 무게와의 짝꿍 확인
            pair_weight = (weight * r2) // r1 
            if (weight * r2) % r1 == 0 and pair_weight in weight_count:
                answer += count * weight_count[pair_weight]

    return answer
