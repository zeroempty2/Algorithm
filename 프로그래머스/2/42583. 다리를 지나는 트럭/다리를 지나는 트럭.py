from queue import Queue

def solution(bridge_length, weight, truck_weights):
    answer = 0
    wait = Queue()
    move = Queue()
    bridge_weight = 0
    [wait.put(weight) for weight in truck_weights]
    
    while not wait.empty() or not move.empty():
        answer += 1
            
        # 다리 위 트럭이 다리를 건너면 내려줌
        if not move.empty() and move.queue[0][1] == answer:
            truck_weight, _ = move.get() #move의 시간값 무시
            bridge_weight -= truck_weight
            
        # 새로운 트럭이 다리로 진입할 수 있는지 확인
        if not wait.empty() and bridge_weight + wait.queue[0] <= weight and move.qsize() < bridge_length:
            truck_weight = wait.get()
            bridge_weight += truck_weight
            move.put((truck_weight, answer + bridge_length))  # 트럭의 무게와 다리를 완전히 건널 시간을 함께 저장

    return answer