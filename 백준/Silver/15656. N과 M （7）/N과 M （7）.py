import sys

input = sys.stdin.readline

N, M = map(int, input().split())
arr = sorted(list(map(int, input().split())))

result = []

def backtracking():
    if len(result) == M:
        print(*result)
        return
    
    for i in range(N):
        result.append(arr[i])
        backtracking()
        result.pop()

backtracking()