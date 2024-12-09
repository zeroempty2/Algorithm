import heapq

def solution(n, works):
    # 최대 힙을 구현하기 위해 음수로 변환
    pq = [-work for work in works]
    heapq.heapify(pq)
    
    for _ in range(n):
        if not pq or pq[0] == 0:
            return 0  # 남은 작업이 없으면 바로 0 반환
        max_work = -heapq.heappop(pq)
        max_work -= 1
        heapq.heappush(pq, -max_work)
    
    # 남은 작업의 제곱합 계산
    return sum((-work) ** 2 for work in pq)
