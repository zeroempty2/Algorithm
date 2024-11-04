from collections import deque

def solution(order):
    answer = 0
    idx = 0
    stack = []
    queue = deque(range(1, len(order) + 1))  

    while queue or stack:
        if queue and queue[0] == order[idx]:
            queue.popleft()
            answer += 1
            idx += 1
        elif stack and stack[-1] == order[idx]:
            stack.pop()
            answer += 1
            idx += 1
        elif queue:
            stack.append(queue.popleft())
        else:
            break

    return answer