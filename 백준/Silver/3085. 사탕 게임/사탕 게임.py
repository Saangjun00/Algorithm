import sys

input = sys.stdin.readline

N = int(input())
c = [list(input()) for _ in range(N)]

def checkCurMaxNum():
    max_cnt = 1
    for i in range(N):
        # 가로 확인
        cnt = 1
        for j in range(1, N):
            if c[i][j] == c[i][j - 1]:
                cnt += 1
            else:
                cnt = 1
            max_cnt = max(cnt, max_cnt)
        # 세로 확인
        cnt = 1
        for j in range(1, N):
            if c[j][i] == c[j - 1][i]:
                cnt += 1
            else:
                cnt = 1
            max_cnt = max(cnt, max_cnt)
        
    return max_cnt

result = 1
for i in range(N):
    for j in range(N - 1):
        # 오른쪽 swap
        if j + 1 < N and c[i][j] != c[i][j + 1]:
            c[i][j], c[i][j + 1] = c[i][j + 1], c[i][j]
            result = max(result, checkCurMaxNum())
            c[i][j], c[i][j + 1] = c[i][j + 1], c[i][j]
        # 왼쪽 swap
        if i + 1 < N and c[i][j] != c[i + 1][j]:
            c[i][j], c[i + 1][j] = c[i + 1][j], c[i][j]
            result = max(result, checkCurMaxNum())
            c[i][j], c[i + 1][j] = c[i + 1][j], c[i][j]

print(result)