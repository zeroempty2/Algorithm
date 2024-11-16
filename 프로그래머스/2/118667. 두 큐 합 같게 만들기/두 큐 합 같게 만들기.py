from queue import Queue

def solution(queue1, queue2):
    answer = 0
    q1 = Queue()
    q2 = Queue()
    total_q1, total_q2 = 0, 0

    for i in range(len(queue1)):
        num1 = queue1[i]
        num2 = queue2[i]
        q1.put(num1)
        q2.put(num2)
        total_q1 += num1
        total_q2 += num2

    max_operations = len(queue1) * 3  

    while total_q1 != total_q2:
        if answer > max_operations:
            return -1

        if total_q1 > total_q2:
            num = q1.get()
            q2.put(num)
            total_q1 -= num
            total_q2 += num
        else:
            num = q2.get()
            q1.put(num)
            total_q2 -= num
            total_q1 += num

        answer += 1

    return answer
