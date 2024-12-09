from collections import deque

# 방향: 위, 아래, 왼쪽, 오른쪽, 앞, 뒤
directions = [
    (0, -1, 0),  # 위
    (0, 1, 0),   # 아래
    (-1, 0, 0),  # 왼쪽
    (1, 0, 0),   # 오른쪽
    (0, 0, -1),  # 앞
    (0, 0, 1)    # 뒤
]

def main():
    import sys
    input = sys.stdin.read
    data = input().splitlines()
    
    # 첫 줄 입력
    M, N, H = map(int, data[0].split())  # 가로, 세로, 높이
    
    box = []
    queue = deque()
    unripe = 0  # 익지 않은 토마토 수
    
    # 상자 상태 입력
    idx = 1
    for h in range(H):
        layer = []
        for n in range(N):
            row = list(map(int, data[idx].split()))
            layer.append(row)
            for m in range(M):
                if row[m] == 1:
                    queue.append((h, n, m, 0))  # 익은 토마토 위치 및 경과 일수
                elif row[m] == 0:
                    unripe += 1  # 익지 않은 토마토 수 증가
            idx += 1
        box.append(layer)
    
    # 모든 토마토가 이미 익어있는 경우
    if unripe == 0:
        print(0)
        return
    
    days = 0
    
    # BFS 시작
    while queue:
        z, x, y, days = queue.popleft()
        for dz, dx, dy in directions:
            nz, nx, ny = z + dz, x + dx, y + dy
            # 범위를 벗어나지 않고 익지 않은 토마토일 경우
            if 0 <= nz < H and 0 <= nx < N and 0 <= ny < M and box[nz][nx][ny] == 0:
                box[nz][nx][ny] = 1  # 익게 처리
                unripe -= 1
                queue.append((nz, nx, ny, days + 1))
    
    # 결과 출력
    print(-1 if unripe > 0 else days)

if __name__ == "__main__":
    main()
