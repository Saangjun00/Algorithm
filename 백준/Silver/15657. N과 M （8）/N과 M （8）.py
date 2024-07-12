import sys

input = sys.stdin.readline

N, M = map(int, input().split())
arr = sorted(list(map(int, input().split())))

result = []

def backtracking(start):
    if len(result) == M:
        print(*result)
        return
    
    for i in range(start, N):
        result.append(arr[i])
        backtracking(i)
        result.pop()

backtracking(0)