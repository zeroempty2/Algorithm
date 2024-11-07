from collections import deque

def solution(x, y, n):
    answer = -1
    q = deque([(y,0)])
    
    while q:
        # 큐에서 현재 값과 연산 횟수를 꺼냄
        now, count = q.popleft()

        # 목표 값에 도달한 경우
        if now == x:
            return count

        # now가 x보다 크면 연산을 진행
        if now > x:
            # 3으로 나누어 떨어지면 3으로 나눈 값을 큐에 추가
            if now % 3 == 0:
                q.append((now // 3, count + 1))
            # 2로 나누어 떨어지면 2로 나눈 값을 큐에 추가
            if now % 2 == 0:
                q.append((now // 2, count + 1))
            # n을 빼면 새로운 값을 큐에 추가
            q.append((now - n, count + 1))
            
    return answer